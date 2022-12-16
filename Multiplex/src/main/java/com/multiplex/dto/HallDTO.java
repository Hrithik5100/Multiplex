package com.multiplex.dto;

import com.multiplex.entities.Movie;

public class HallDTO {
	private Integer hallId;
	private Movie movie;
	private Integer seatNumber;

	public HallDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HallDTO(Integer hallId, Movie movie, Integer seatNumber) {
		super();
		this.hallId = hallId;
		this.movie = movie;
		this.seatNumber = seatNumber;
	}

	public Integer getHallId() {
		return hallId;
	}

	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "HallDTO [hallId=" + hallId + ", movie=" + movie + ", seatNumber=" + seatNumber + "]";
	}
	
}
