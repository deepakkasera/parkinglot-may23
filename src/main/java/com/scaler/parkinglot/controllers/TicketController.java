package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dto.GenerateTicketRequestDto;
import com.scaler.parkinglot.dto.GenerateTicketResponseDto;
import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    //generateTicket API will be used by the Client, so it's not a good idea to expose our internal models to the Client.
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) {
        //1.Get the Vehicle from the DB.
        //2. If the Vehicle is there fetch the details, else create the vehicle and store it in the DB.

        // 2 Ways :-
        /*
           => Controllers should be as light as possible.
            -> 1. vehicleService.getVehicleByVehicleNumber(number) :: Better approach.
            -> 2. vehicleRepository.fetchVehicle(number)
         */

        Ticket ticket = ticketService.generateTicket(requestDto.getVehicleNumber(),
                requestDto.getVehicleType(), requestDto.getGateId());

        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        responseDto.setTicket(ticket);
        //responseDto.setResponseStatus();



        return null;
    }

}

/*
We are exposing the models directly to the client, Not a good approach.

problems with directly involving Models in the Controller API's :-

1. If we add/remove models from the input, current clients will start failing.
2. We should not expose the Model details to client because of privacy.

The solution to this : Data Transfer Objects (DTO).
 */
