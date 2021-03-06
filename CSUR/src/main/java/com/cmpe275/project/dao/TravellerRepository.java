package com.cmpe275.project.dao;

import com.cmpe275.project.model.Travellers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravellerRepository extends CrudRepository<Travellers,Long> {

    List<Travellers> findAllByTicketId(long ticketId);
}
