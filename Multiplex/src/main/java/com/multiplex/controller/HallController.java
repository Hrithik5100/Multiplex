package com.multiplex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.dto.HallDTO;
import com.multiplex.entities.Hall;
import com.multiplex.exception.HallNotFoundException;
import com.multiplex.services.HallService;
@RestController
@ResponseBody
public class HallController {
	@Autowired
	private HallService hallservice;
	
	@GetMapping(value= "/hall")
	public ResponseEntity<List<HallDTO>> getAllHalls() throws HallNotFoundException{
		List<HallDTO> hallList=hallservice.getAllHalls();
		return new ResponseEntity<List<HallDTO>>(hallList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/hall")
	public ResponseEntity<String> addHall(@RequestBody HallDTO hall){
		Hall hallId=hallservice.addHall(hall);
		return new ResponseEntity<String>("API.INSERT_CREATED", HttpStatus.OK);
	}
	
	@GetMapping(value="/hall/{hallId}")
	public ResponseEntity<HallDTO> getHallbyId(@PathVariable Integer hallId) throws HallNotFoundException{
		HallDTO hall=hallservice.getHallById(hallId);
		return new ResponseEntity<HallDTO>(hall, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/hall/{hallId}")
	public ResponseEntity deleteHallById(@PathVariable Integer hallId) throws HallNotFoundException{
		hallservice.deleteHallById(hallId);
		return new ResponseEntity("API.DELETE_SUCCESS", HttpStatus.OK);
	}

}
