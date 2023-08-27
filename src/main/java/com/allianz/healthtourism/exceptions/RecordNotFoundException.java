package com.allianz.healthtourism.exceptions;

public class RecordNotFoundException extends NullPointerException {
    public RecordNotFoundException() {
        System.out.println("Record not found!");
    }

    public RecordNotFoundException(String s) {
        System.out.println("Record not found!");
    }
}
