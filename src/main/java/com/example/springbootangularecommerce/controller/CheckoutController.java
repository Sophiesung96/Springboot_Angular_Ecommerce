package com.example.springbootangularecommerce.controller;

import com.example.springbootangularecommerce.Service.CheckoutService;
import com.example.springbootangularecommerce.Service.IdempotencyService;
import com.example.springbootangularecommerce.dto.Purchase;
import com.example.springbootangularecommerce.dto.PurchaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
@Tag(name = "", description = "")
public class CheckoutController {
    
    private final CheckoutService checkoutService;
    private final IdempotencyService idempotencyService;

    public CheckoutController(CheckoutService checkoutService, IdempotencyService idempotencyService) {
        this.checkoutService = checkoutService;
        this.idempotencyService = idempotencyService;
    }

    @PostMapping("/orders")
    @Operation(description = "")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200 OK"
            )
    })
    public ResponseEntity<PurchaseResponse> placeOrder(@RequestHeader(value = "Idempotency-Key", required = false) String idempotencyKey,
                                                       @RequestBody Purchase purchase) {

        HttpHeaders headers = new HttpHeaders();
        if(idempotencyKey == null || idempotencyKey.isEmpty()) {
            idempotencyKey= DigestUtils.sha1DigestAsHex(purchase.toString());
        }
        headers.set("Idempotency-Key", idempotencyKey);
        //check if the request was already requested
        if(idempotencyKey != null && idempotencyService.isDuplicateRequest(idempotencyKey)){
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(idempotencyService.getResponse(idempotencyKey,PurchaseResponse.class));
        }
       PurchaseResponse purchaseResponse=checkoutService.placeOrder(purchase);
        idempotencyService.storeResponse(idempotencyKey,purchaseResponse);

       return  ResponseEntity.ok().headers(headers).body(purchaseResponse);
    }
    
}
