package com.gwozdz1uu.store.controllers;

import com.gwozdz1uu.store.dtos.CheckoutRequest;
import com.gwozdz1uu.store.dtos.CheckoutResponse;
import com.gwozdz1uu.store.dtos.ErrorDto;
import com.gwozdz1uu.store.exceptions.CartEmptyException;
import com.gwozdz1uu.store.exceptions.CartNotFoundException;
import com.gwozdz1uu.store.exceptions.PaymentException;
import com.gwozdz1uu.store.services.CheckoutService;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.net.Webhook;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    private final CheckoutService checkoutService;

    @Value("${stripe.webhookSecretKey}")
    private String webhookSecretKey;

    @PostMapping
    public CheckoutResponse checkout(@Valid @RequestBody CheckoutRequest checkoutRequest)
    {
        return checkoutService.checkout(checkoutRequest);
    }

    @PostMapping("/webhook")
    public ResponseEntity<Void> handleWebhook(
            @RequestHeader("Stripe-Signature") String signature,
            @RequestBody String payload)
    {
        try {
            var event = Webhook.constructEvent(payload,signature,webhookSecretKey);
            System.out.println(event.getType());

            var stripeObject = event.getDataObjectDeserializer().getObject().orElse(null);
            switch (event.getType()){
                case "payment_intent.succeeded"-> {}
                case "payment_intent.failed"-> {}
            }
            return ResponseEntity.ok().build();

        } catch (SignatureVerificationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<ErrorDto> handlePaymentException(PaymentException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDto("Error creating a checkout session."));
    }

    @ExceptionHandler({CartNotFoundException.class, CartEmptyException.class})
    public ResponseEntity<ErrorDto> handleException(Exception exception){
        return ResponseEntity.badRequest().body(new ErrorDto(exception.getMessage()));
    }
}
