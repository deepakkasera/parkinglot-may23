package com.scaler.parkinglot.strategy;

import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.services.ParkingLotService;
import com.scaler.parkinglot.services.ParkingSpotService;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    private ParkingLotService parkingLotService;
    private ParkingSpotService parkingSpotService;

    public RandomSpotAssignmentStrategy(ParkingLotService parkingLotService,
                                        ParkingSpotService parkingSpotService) {
        this.parkingLotService = parkingLotService;
        this.parkingSpotService = parkingSpotService;
    }
    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {
        //For the gate, get the ParkingLot.

        ParkingLot parkingLot = parkingLotService.getParkingLotForGate(gate);
        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpotsByLot(parkingLot);

        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) &&
                parkingSpot.getSupportedVehicleTypes().contains(vehicleType)) {
                return parkingSpot;
            }
        }
        return null;
    }
}
