package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Flight;
import com.ibm.repo.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
    
	@Autowired
	private FlightRepository repo;
	@Override
	public int save(Flight f) {
		// TODO Auto-generated method stub
		repo.save(f);
		return f.getId();
	}

	@Override
	public Flight find(int code) throws InvalidFlightException {
		// TODO Auto-generated method stub
		return repo.findById(code).orElseThrow(()-> new InvalidFlightException("Invalid Code  :" +code));
		
	}

	@Override
	public List<Flight> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean remove(int code) {
		// TODO Auto-generated method stub
         repo.deleteById(code);
		return true;
	}

	@Override
	public List<Flight> byCarrier(String carrier) {
		// TODO Auto-generated method stub
		return repo.findByCarrier(carrier);
	}

	@Override
	public List<Flight> byRoute(String src, String desc) {
		// TODO Auto-generated method stub
		return repo.findByRoute(src,desc);
	}

}
