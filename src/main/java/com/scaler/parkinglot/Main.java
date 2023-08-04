package com.scaler.parkinglot;

import com.scaler.parkinglot.controllers.TicketController;
import com.scaler.parkinglot.dto.GenerateTicketRequestDto;
import com.scaler.parkinglot.dto.GenerateTicketResponseDto;
import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.models.VehicleType;
import com.scaler.parkinglot.repositories.ParkingLotRepository;
import com.scaler.parkinglot.repositories.VehicleRepository;
import com.scaler.parkinglot.services.*;
import com.scaler.parkinglot.strategy.RandomSpotAssignmentStrategy;
import com.scaler.parkinglot.strategy.SpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ObjectContainer objectContainer = new ObjectContainer();
        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        GateService gateService = new GateService();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);
        ParkingSpotService parkingSpotService = new ParkingSpotService();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingLotService, parkingSpotService);
        TicketService ticketService = new TicketService(vehicleService, gateService, spotAssignmentStrategy);
        TicketController ticketController = new TicketController();
        objectContainer.register("vehicleRepository", vehicleRepository);
        objectContainer.register("vehicleService", vehicleService);
        objectContainer.register("gateService", gateService);
        //and so on, store all the objets in the container.


        GenerateTicketRequestDto requestDto = new GenerateTicketRequestDto();
        requestDto.setGateId(123L);
        requestDto.setVehicleNumber("HR16X1234");
        requestDto.setVehicleType(VehicleType.MEDIUM);

        GenerateTicketResponseDto dto = ticketController.generateTicket(requestDto);

        Ticket ticket = dto.getTicket();

        //We can do whatever we want now.......
    }
}

//Spring uses Topological Sorting to resolve dependencies.