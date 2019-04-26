package com.arise.hibernateProject.entity;

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
	private String flatArea;
	private String furniture;//1.fully-furnished, 2.semi-furnished, 3. non-furnished
	private int floorNo;
	private String mainEntrance;//South,North,East
	private String water;
	private String electricity;
	private String gasConn;
	private double maintenanceCost;
	private String payingGest;
	private String flatType;
	private String flatNum;
	private String available;
	
	@ManyToOne
	@JoinColumn(name = "hotelId")
	private HotelEntity hotel;
	
	
	public String getFlatArea() {
		return flatArea;
	}
	public void setFlatArea(String flatArea) {
		this.flatArea = flatArea;
	}
	public String getFurniture() {
		return furniture;
	}
	public void setFurniture(String furniture) {
		this.furniture = furniture;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public String getMainEntrance() {
		return mainEntrance;
	}
	public void setMainEntrance(String mainEntrance) {
		this.mainEntrance = mainEntrance;
	}
	public String getWater() {
		return water;
	}
	public void setWater(String water) {
		this.water = water;
	}
	public String getElectricity() {
		return electricity;
	}
	public void setElectricity(String electricity) {
		this.electricity = electricity;
	}
	public String getGasConn() {
		return gasConn;
	}
	public void setGasConn(String gasConn) {
		this.gasConn = gasConn;
	}
	public double getMaintenanceCost() {
		return maintenanceCost;
	}
	public void setMaintenanceCost(double maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}
	public String getPayingGest() {
		return payingGest;
	}
	public void setPayingGest(String payingGest) {
		this.payingGest = payingGest;
	}
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
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	
	
}
