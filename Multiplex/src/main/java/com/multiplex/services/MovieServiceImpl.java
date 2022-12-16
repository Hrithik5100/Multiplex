package com.multiplex.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dto.MovieDTO;
import com.multiplex.entities.Movie;
import com.multiplex.exception.MovieNotFoundException;
import com.multiplex.repository.MovieRepository;
@Service(value="movieservice")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<MovieDTO> getAllMovies() throws MovieNotFoundException {
		
		Iterable<Movie> movies = movieRepository.findAll();
		List<MovieDTO> movie1 = new ArrayList<>();
		movies.forEach(movie->{
			MovieDTO movie2 = new MovieDTO();
			movie2.setMovieId(movie.getMovieId());
			movie2.setMovieName(movie.getMovieName());
			movie2.setDate(movie.getDate());
			movie2.setTime(movie.getTime());
			movie1.add(movie2);
			
		});
		if(movie1.isEmpty()) {
			throw new MovieNotFoundException();
		}
		return movie1;
	}

	@Override
	public Movie addMovie(MovieDTO movieDTO) {
		Movie movieEntity = new Movie();
		movieEntity.setMovieId(movieDTO.getMovieId());
		movieEntity.setMovieName(movieDTO.getMovieName());
		movieEntity.setDate(movieDTO.getDate());
		movieEntity.setTime(movieDTO.getTime());
		Movie movie = movieRepository.save(movieEntity);
		return movie;
	}

	@Override
	public MovieDTO getMovieById(Integer movieId) throws MovieNotFoundException {
		Optional<Movie> optional = movieRepository.findById(movieId);
		Movie movie=optional.orElseThrow(() ->  new MovieNotFoundException());
		MovieDTO movie1 = new MovieDTO();
		movie1.setMovieId(movie.getMovieId());
		movie1.setMovieName(movie.getMovieName());
		movie1.setDate(movie.getDate());
		movie1.setTime(movie.getTime());
		return movie1;
	}

	@Override
	public void deleteMovieById(Integer movieId) throws MovieNotFoundException {
		Optional<Movie> optional=movieRepository.findById(movieId);
		Movie movie = optional.orElseThrow(() -> new MovieNotFoundException());
		MovieDTO movie1 = new MovieDTO();
		movie1.setMovieId(movie.getMovieId());
		movie1.setMovieName(movie.getMovieName());
		movie1.setDate(movie.getDate());
		movie1.setTime(movie.getTime());
		movieRepository.deleteById(movieId);
		
	}

	@Override
	public List<MovieDTO> getMovieByName(String movieName) throws MovieNotFoundException{
		List<Movie> movie = movieRepository.getMovieByName(movieName);
		if(movie.isEmpty()) {
			throw new MovieNotFoundException();
		}
		else {
			MovieDTO movie1 = new MovieDTO();
			List<MovieDTO> m = new ArrayList<>();
			for(Movie mo: movie) {
				movie1.setMovieId(mo.getMovieId());
		        movie1.setMovieName(mo.getMovieName());
		        movie1.setDate(mo.getDate());
		        movie1.setTime(mo.getTime());
		        m.add(movie1);
			
		}
			return m;
		}
}

	@Override
	public void updateMovieByName(Integer movieId, String movieName) throws MovieNotFoundException {
		 if(movieRepository.existsById(movieId)) {
		        Movie movie=movieRepository.findById(movieId).get();
		        movie.setMovieName(movieName);
		        movieRepository.save(movie);
		    }
		        else {
		    throw new MovieNotFoundException();
		    }
		
	}
}
