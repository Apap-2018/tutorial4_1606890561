package com.apap.tutorial4.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.repository.FlightDB;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDB flightDB;
	
	@Override
	public void addFlight(FlightModel flight) {
		// TODO Auto-generated method stub
		flightDB.save(flight);
	}

	@Override
	public void deleteFlight(Long id) {
		// TODO Auto-generated method stub
		flightDB.deleteById(id);
	}
	
	

}
