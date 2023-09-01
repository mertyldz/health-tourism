package com.allianz.healthtourism.exceptions;

public class CapacityException extends NullPointerException {
    public CapacityException() {
        super("Capacity is full!");
    }

    public CapacityException(String s) {
        super(s);
    }
}
