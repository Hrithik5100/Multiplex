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

import com.multiplex.dto.ShowDTO;
import com.multiplex.entities.Show;
import com.multiplex.exception.ShowNotFoundException;
import com.multiplex.services.ShowService;

@RestController
@ResponseBody
public class ShowController {
	@Autowired
	private ShowService showService;
	@GetMapping(value="/show")
	public ResponseEntity<List<ShowDTO>> getAllShows() throws ShowNotFoundException{
		List<ShowDTO> showList=showService.getAllShows();
		return new ResponseEntity<List<ShowDTO>>(showList, HttpStatus.OK);
	}
	
	@PostMapping(value="/show")
	public ResponseEntity<String> addShow(@RequestBody ShowDTO showDTO) throws ShowNotFoundException{
		Show showId=showService.addShow(showDTO);
		return new ResponseEntity<String>("API.INSERT_CREATED", HttpStatus.CREATED);
	}
	
	@GetMapping(value="/show/{showId}")
	public ResponseEntity<ShowDTO> getShowById(@PathVariable Integer showId) throws ShowNotFoundException{
		ShowDTO show=showService.getShowById(showId);
		return new ResponseEntity<ShowDTO>(show, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/show/{showId}")
	public ResponseEntity deleteShowById(@PathVariable Integer showId) throws ShowNotFoundException{
		showService.deleteByShowId(showId);
		return new ResponseEntity("API.DELETE_SUCCESS", HttpStatus.OK);
	}
}
