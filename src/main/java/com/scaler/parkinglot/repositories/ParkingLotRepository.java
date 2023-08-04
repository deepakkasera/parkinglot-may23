package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.Gate;
import com.scaler.parkinglot.models.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {
    //private List<ParkingLot> parkingLots = new ArrayList<>();
    private Map<Long, ParkingLot> parkingLots = new HashMap<>();
    public ParkingLot getParkingLotByGate(Gate gate){
//        for (ParkingLot parkingLot : parkingLots) {
//            if (parkingLot.getGates().contains(gate)) {
//                return parkingLot;
//            }
//        }
//        //return null;

        for (ParkingLot parkingLot : parkingLots.values()) {
            for (Gate gate1 : parkingLot.getGates()) {
                if (gate1.getId() == gate.getId()) {
                    return parkingLot;
                }
            }
        }
        return null;
    }
}
