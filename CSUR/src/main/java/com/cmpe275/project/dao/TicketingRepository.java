package com.cmpe275.project.dao;

import com.cmpe275.project.model.TicketDetails;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketingRepository extends CrudRepository<TicketDetails ,Long> {


    //List<TicketDetails> findAllByUserId(String userId);
}