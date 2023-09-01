package com.allianz.healthtourism.exceptions;

public class PaymentException extends RuntimeException {
    public PaymentException() {
        super("Payment should be done first!");
    }

    public PaymentException(String s) {
        super(s);
    }

}
