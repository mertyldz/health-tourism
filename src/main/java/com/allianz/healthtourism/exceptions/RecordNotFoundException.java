package com.allianz.healthtourism.exceptions;

public class RecordNotFoundException extends NullPointerException {
    public RecordNotFoundException() {
        super("Record not found!");
    }

    public RecordNotFoundException(String s) {
        super(s);
    }

}
