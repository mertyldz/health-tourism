package com.allianz.healthtourism.exceptions;

public class RecordNotFound extends NullPointerException {
    public RecordNotFound() {
        System.out.println("Record not found!");
    }

    public RecordNotFound(String s) {
        System.out.println("Record not found!");
    }
}
