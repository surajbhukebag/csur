package com.cmpe275.project.csur.services;

import com.cmpe275.project.csur.model.TicketDetails;

import java.util.List;

public interface Ticketing {

    void bookTicket(TicketDetails ticketDetails);

    boolean cancelTicket(long ticketId) ;

    List<TicketDetails> getTickets(String userId);

}
