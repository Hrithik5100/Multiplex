package com.multiplex.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="hall")
public class Hall {
	@Id
	@Column(name="hallid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hallId;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "movieId")
	private Movie movie;
	private Integer seatNumber;

	public Hall() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hall(Integer hallId, Movie movie, Integer seatNumber) {
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
		return "Hall [hallId=" + hallId + ", movie=" + movie + ", seatNumber=" + seatNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hallId, movie, seatNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hall other = (Hall) obj;
		return Objects.equals(hallId, other.hallId) && Objects.equals(movie, other.movie)
				&& Objects.equals(seatNumber, other.seatNumber);
	}
	

}
