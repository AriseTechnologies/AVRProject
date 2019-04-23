package com.arise.hibernateProject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FLAT")
public class FlatsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="flat_generator")
	@SequenceGenerator(name="flat_generator",initialValue=1,allocationSize=1,sequenceName="flat_seq")
	private long flatId;
	private String flatType;
	private String flatNum;
	private String rooms;
	
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
	public String getRooms() {
		return rooms;
	}
	public void setRooms(String rooms) {
		this.rooms = rooms;
	}
	
	
	
}
