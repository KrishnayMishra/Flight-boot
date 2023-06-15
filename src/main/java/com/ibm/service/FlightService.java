package com.ibm.service;

import java.util.List;

import com.ibm.entity.Flight;

public interface FlightService {
	
	int save(Flight f);
	
	Flight find(int code) throws InvalidFlightException;
	
	List<Flight> list();
	
	boolean remove(int code);
	
	List<Flight> byCarrier(String carrier);
	
	List<Flight> byRoute(String src,String desc);

}
