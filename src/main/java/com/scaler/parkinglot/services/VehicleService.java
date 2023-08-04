package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.Vehicle;
import com.scaler.parkinglot.models.VehicleType;
import com.scaler.parkinglot.repositories.VehicleRepository;

public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    public Vehicle getVehicle(String vehicleNumber) {
        //VehicleRepository
        return vehicleRepository.getVehicleFromVehicleNumber(vehicleNumber);
    }

    public Vehicle registerVehicle(String vehicleNumber, VehicleType vehicleType) {
        return null;
    }

}
