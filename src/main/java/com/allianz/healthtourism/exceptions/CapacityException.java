package com.allianz.healthtourism.exceptions;

public class CapacityException extends NullPointerException {
    public CapacityException() {
        System.out.println("Capacity is full");
    }

    public CapacityException(String s) {
        System.out.println("Capacity is full");
    }

    @Override
    public String getMessage() {
        return "Capacity is full";
    }
}
