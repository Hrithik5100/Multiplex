package com.multiplex.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dto.HallDTO;
import com.multiplex.entities.Hall;
import com.multiplex.exception.HallNotFoundException;
import com.multiplex.repository.HallRepository;
@Service
public class HallServiceImpl implements HallService{
	@Autowired
	private HallRepository hallRepository;

	@Override
	public List<HallDTO> getAllHalls() throws HallNotFoundException {
		Iterable<Hall> halls = hallRepository.findAll();
		List<HallDTO> hall2 = new ArrayList<>();
		halls.forEach(hall -> {
			HallDTO hall1 = new HallDTO();
			hall1.setHallId(hall.getHallId());
			hall1.setMovie(hall.getMovie());
			hall1.setSeatNumber(hall.getSeatNumber());
			hall2.add(hall1);
		});
		if(hall2.isEmpty()) {
			throw new HallNotFoundException();
		}
		return hall2;
	}

	@Override
	public Hall addHall(HallDTO hallDTO) {
		Hall hallEntity = new Hall();
		hallEntity.setHallId(hallDTO.getHallId());
		hallEntity.setMovie(hallDTO.getMovie());
		hallEntity.setSeatNumber(hallDTO.getSeatNumber());
		Hall hall = hallRepository.save(hallEntity);
		return hall;
	}

	@Override
	public HallDTO getHallById(Integer hallId) throws HallNotFoundException{
		Optional<Hall> optional = hallRepository.findById(hallId);
		Hall hall = optional.orElseThrow(() -> new HallNotFoundException());
		HallDTO hall1 = new HallDTO();
		hall1.setHallId(hall.getHallId());
		hall1.setMovie(hall.getMovie());
		hall1.setSeatNumber(hall.getSeatNumber());
		return hall1;
	}

	@Override
	public void deleteHallById(Integer hallId) throws HallNotFoundException{
		Optional<Hall> optional = hallRepository.findById(hallId);
		Hall hall = optional.orElseThrow(() -> new HallNotFoundException());
		HallDTO hall1 = new HallDTO();
		hall1.setHallId(hall.getHallId());
		hall1.setMovie(hall.getMovie());
		hall1.setSeatNumber(hall.getSeatNumber());
		hallRepository.deleteById(hallId);
	}
}
