package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ibm.entity.Flight;
import com.ibm.service.FlightService;
import com.ibm.service.InvalidFlightException;

@RestController
public class FlightController {
	
	@Autowired
	private FlightService service;
	
	@PostMapping(value="/flight", consumes="application/json")
	public String save(@RequestBody Flight f)
	{
		int code=service.save(f);
		return "Flight added with code:" + code;
	}
	
	@GetMapping(value="/flight/{code}", produces="application/json")
	public Flight get(@PathVariable int code)
	{
		try {
			return service.find(code);
		} catch (InvalidFlightException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/flights" , produces ="application/json")
	public List<Flight> list()
	{
		return service.list();
	}
	
	@DeleteMapping(value="/flight")
	public String delete(int code)
	{
		return service.remove(code)?"Flight removed":"Flight not found";
	}
	
	@GetMapping(value="/flights/{carrier}", produces="application/json")
	public List<Flight> listByCarrier(@PathVariable String carrier)
	{
		return service.byCarrier(carrier);
	}
	
	@GetMapping(value= "/flights/route",produces="application/json")
	public List<Flight> listByRoute(@RequestParam String src, @RequestParam String dest)
	{
		return service.byRoute(src, dest);
	}
	
	
	

}
