package com.multiplex.services;

import java.util.List;

import com.multiplex.dto.HallDTO;
import com.multiplex.entities.Hall;
import com.multiplex.exception.HallNotFoundException;

public interface HallService {
	public List<HallDTO> getAllHalls() throws HallNotFoundException;
	public Hall addHall(HallDTO hall);
	public HallDTO getHallById(Integer hallId) throws HallNotFoundException;
	public void deleteHallById(Integer hallId) throws HallNotFoundException;

}
