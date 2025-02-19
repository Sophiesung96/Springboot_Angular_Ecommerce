package com.example.springbootangularecommerce.Service;

import com.example.springbootangularecommerce.dto.PaymentInfo;
import com.example.springbootangularecommerce.dto.Purchase;
import com.example.springbootangularecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
