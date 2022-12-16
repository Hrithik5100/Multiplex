package com.multiplex.services;

import java.util.List;

import com.multiplex.dto.MovieDTO;
import com.multiplex.entities.Movie;
import com.multiplex.exception.MovieNotFoundException;

public interface MovieService {
	public List<MovieDTO> getAllMovies()throws MovieNotFoundException;
	public Movie addMovie(MovieDTO movieDTO);
	public MovieDTO getMovieById(Integer movieId) throws MovieNotFoundException;
	public void deleteMovieById(Integer movieId) throws MovieNotFoundException;
	public List<MovieDTO> getMovieByName(String movieName) throws MovieNotFoundException;
	public void updateMovieByName(Integer movieId, String movieName) throws MovieNotFoundException;

}
