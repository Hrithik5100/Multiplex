package com.multiplex.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import com.multiplex.entities.Show;
import com.multiplex.entities.User;

public class BookingDTO {
	private Integer bookId;
	private User user;
	private Show show;
	private LocalDate date;
	private LocalTime time;
	public BookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingDTO(Integer bookId, User user, Show show, LocalDate date, LocalTime time) {
		super();
		this.bookId = bookId;
		this.user = user;
		this.show = show;
		this.date = date;
		this.time = time;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "BookingDTO [bookId=" + bookId + ", user=" + user + ", show=" + show + ", date=" + date + ", time="
				+ time + "]";
	}

}
