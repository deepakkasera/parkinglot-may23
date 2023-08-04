package com.scaler.parkinglot.models;

import java.util.List;

public class ParkingSpot extends BaseEntity {
    ParkingSpotStatus parkingSpotStatus;
    //private ParkingFloor parkingFloor;
    List<VehicleType> supportedVehicleTypes;
    int number;
    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
