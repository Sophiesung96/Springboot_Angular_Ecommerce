package com.example.springbootangularecommerce.Service;

import com.example.springbootangularecommerce.dao.CustomerRepository;
import com.example.springbootangularecommerce.dto.PaymentInfo;
import com.example.springbootangularecommerce.dto.Purchase;
import com.example.springbootangularecommerce.dto.PurchaseResponse;
import com.example.springbootangularecommerce.entity.Customer;
import com.example.springbootangularecommerce.entity.Order;
import com.example.springbootangularecommerce.entity.OrderItem;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, @Value("${stripe.secret-key}") String secretKey) {
        this.customerRepository = customerRepository;
        Stripe.apiKey=secretKey;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //retrieve the order info from dto
        Order order=purchase.getOrder();
        //generate tracking number
        String orderTrackingNumber=generateOrderTrackingNUmber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        //populate order with orderItems
        List<OrderItem> orderItems=order.getOrderItems();
        orderItems.forEach(orderItem ->order.add(orderItem));
        //populate order shipping address and billing address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());
        //populate customer with order
        Customer customer=purchase.getCustomer();
        String theEmail=customer.getEmail();
        Customer customerDB=customerRepository.findByEmail(theEmail);
        if(customerDB!=null)
        {
            customer=customerDB;
        }
        customer.add(order);
        //save to the database
        customerRepository.save(order.getCustomer());
        return new PurchaseResponse(orderTrackingNumber);
    }

    @Override
    public PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException {
        List<String> paymentMethodType=new ArrayList<>();
        paymentMethodType.add("card");
        Map<String,Object> param=new HashMap<>();
        param.put("amount",paymentInfo.getAmount());
        param.put("currency",paymentInfo.getCurrency());
        param.put("payment_method_type",paymentMethodType);
        param.put("description","SunnyShop Purchase");
        return PaymentIntent.create(param);
    }

    private String generateOrderTrackingNUmber() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date()); // e.g., "20250209123045"
        int randomNum = new Random().nextInt(999999); // Random 6-digit number
        return "ORD-" + timestamp + "-" + String.format("%06d", randomNum); // e.g., "ORD-20250209123045-123456"

    }
}
