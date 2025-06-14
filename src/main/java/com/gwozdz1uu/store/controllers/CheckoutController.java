package com.gwozdz1uu.store.controllers;

import com.gwozdz1uu.store.dtos.CheckoutRequest;
import com.gwozdz1uu.store.dtos.CheckoutResponse;
import com.gwozdz1uu.store.dtos.ErrorDto;
import com.gwozdz1uu.store.exceptions.CartEmptyException;
import com.gwozdz1uu.store.exceptions.CartNotFoundException;
import com.gwozdz1uu.store.exceptions.PaymentException;
import com.gwozdz1uu.store.services.CheckoutService;
import com.stripe.exception.StripeException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    private final CheckoutService checkoutService;

    @PostMapping
    public CheckoutResponse checkout(@Valid @RequestBody CheckoutRequest checkoutRequest)
    {
        return checkoutService.checkout(checkoutRequest);
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
