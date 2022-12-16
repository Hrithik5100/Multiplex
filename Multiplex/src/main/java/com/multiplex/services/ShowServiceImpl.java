package com.multiplex.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dto.ShowDTO;
import com.multiplex.entities.Show;
import com.multiplex.exception.ShowNotFoundException;
import com.multiplex.repository.ShowRepository;
@Service
public class ShowServiceImpl implements ShowService {
	@Autowired
	private ShowRepository showRepository;

	@Override
	public List<ShowDTO> getAllShows() throws ShowNotFoundException {
		Iterable<Show> shows = showRepository.findAll();
		List<ShowDTO> show1 = new ArrayList<>();
		shows.forEach(show->{
			ShowDTO show2 = new ShowDTO();
			show2.setShowId(show.getShowId());
			show2.setHall(show.getHall());
			show1.add(show2);
		});
		if(show1.isEmpty()) {
			throw new ShowNotFoundException();
		}
		return show1;
	}

	@Override
	public Show addShow(ShowDTO showDTO) {
		Show showEntity = new Show();
		showEntity.setShowId(showDTO.getShowId());
		showEntity.setHall(showDTO.getHall());
		Show show = showRepository.save(showEntity);
		return show;
	}

	@Override
	public ShowDTO getShowById(Integer showId) throws ShowNotFoundException{
		Optional<Show> optional=showRepository.findById(showId);
		Show show=optional.orElseThrow(() -> new ShowNotFoundException());
		ShowDTO show2 = new ShowDTO();
		show2.setShowId(show.getShowId());
		show2.setHall(show.getHall());
		return show2;
	}

	@Override
	public void deleteByShowId(Integer showId) throws ShowNotFoundException{
		Optional<Show> optional=showRepository.findById(showId);
		Show show=optional.orElseThrow(() -> new ShowNotFoundException());
		ShowDTO show2=new ShowDTO();
		show2.setShowId(show.getShowId());
		show2.setHall(show.getHall());
		showRepository.deleteById(showId);
	}
	
	

}
