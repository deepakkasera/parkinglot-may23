package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.Gate;
import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.repositories.ParkingLotRepository;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }
    public ParkingLot getParkingLotForGate(Gate gate) {
        return parkingLotRepository.getParkingLotByGate(gate);
    }
}
