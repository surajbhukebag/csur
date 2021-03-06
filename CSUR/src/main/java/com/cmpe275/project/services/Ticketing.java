package com.cmpe275.project.services;

import com.cmpe275.project.mapper.TicketMapper;
import com.cmpe275.project.model.Ticket;

import java.util.List;

public interface Ticketing {

    Ticket bookTicket(TicketMapper ticketMapper);
    void bookTicketDetails(TicketMapper ticketMapper);
    void runningTrain(TicketMapper ticketMapper);
    void travellerDetails(TicketMapper ticketMapper);

    List<TicketMapper> getTickets(long userId);

    boolean cancelTicket(long ticketId,long today);

}
