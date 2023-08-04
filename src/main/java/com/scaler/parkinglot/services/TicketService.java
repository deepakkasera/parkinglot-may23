package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.strategy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Vector;

public class TicketService {
    private VehicleService vehicleService;
    private GateService gateService;
    private SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketService(VehicleService vehicleService, GateService gateService,
                         SpotAssignmentStrategy spotAssignmentStrategy) {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) {
        /*
        Flow :-
            -> Get the vehicle details from the DB, if the Vehicle is not present then
            create a vehicle object and store in the DB.

         */

        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);

        if (vehicle == null) {
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        Gate gate = gateService.getGateUsingId(gateId);

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        ticket.setEntryTime(System.currentTimeMillis());

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate);

        if (parkingSpot == null) {
            //No ParkingSpot is available.
            //Throw an Exception.
        }

        //ParkingSpot assignment
        ticket.setParkingSpot();

        return null;
    }
}
