package com.scaler.parkinglot.excpetions;

public class NoParkingSpotFoundException extends Exception {
    public NoParkingSpotFoundException(String message) {
        super(message);
    }
}
