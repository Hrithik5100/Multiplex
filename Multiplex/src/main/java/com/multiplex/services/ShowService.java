package com.multiplex.services;

import java.util.List;

import com.multiplex.dto.ShowDTO;
import com.multiplex.entities.Show;
import com.multiplex.exception.ShowNotFoundException;

public interface ShowService {
	public List<ShowDTO> getAllShows() throws ShowNotFoundException;
	public Show addShow(ShowDTO showDTO);
	public ShowDTO getShowById(Integer showId) throws ShowNotFoundException;
	public void deleteByShowId(Integer showId) throws ShowNotFoundException;
	

}
