package com.cmpe275.project.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cmpe275.project.model.Station;

public interface StationDao extends CrudRepository<Station, Long> {

	@Query(value = "SELECT id FROM station WHERE name = ?1", nativeQuery = true)
	public String findStationIdByName(@Param("name") String name);
	
}
