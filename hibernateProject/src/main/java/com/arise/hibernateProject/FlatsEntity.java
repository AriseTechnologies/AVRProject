package com.arise.hibernateProject;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FLAT")
public class FlatsEntity {

	@Id
	private long flatId;
	private String flatType;
	private String flatNum;
	private List<String> rooms;
	
	@ManyToOne
	@JoinColumn(name = "hotelId")
	private HotelEntity hotel;
	
	public long getFlatId() {
		return flatId;
	}
	public void setFlatId(long flatId) {
		this.flatId = flatId;
	}
	public String getFlatType() {
		return flatType;
	}
	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	public String getFlatNum() {
		return flatNum;
	}
	public void setFlatNum(String flatNum) {
		this.flatNum = flatNum;
	}
	public HotelEntity getHotel() {
		return hotel;
	}
	public void setHotel(HotelEntity hotel) {
		this.hotel = hotel;
	}
	public List<String> getRooms() {
		return rooms;
	}
	public void setRooms(List<String> rooms) {
		this.rooms = rooms;
	}
	
}
