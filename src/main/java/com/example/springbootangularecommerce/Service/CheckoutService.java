package com.example.springbootangularecommerce.Service;

import com.example.springbootangularecommerce.dto.Purchase;
import com.example.springbootangularecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
