package com.example.springbootangularecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
public class PurchaseResponse {
    private final String orderTrackingNumber;

}
