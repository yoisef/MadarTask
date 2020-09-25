package com.example.madarsofttask.Utils;

public enum GenderEnum {
    MALE("Male", 1),
    FEMALE("Female", 2);

    private String stringValue;
    private int intValue;
    private GenderEnum(String toString, int value) {
        stringValue = toString;
        intValue = value;
    }

    @Override
    public String toString() {
        return stringValue;
    }

    public int getIntValue() {
        return intValue;
    }
}