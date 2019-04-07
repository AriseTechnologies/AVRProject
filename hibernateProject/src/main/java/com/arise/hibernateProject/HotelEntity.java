package com.arise.hibernateProject;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="APR_HTL")
public class HotelEntity{
	
	@Id
	private long hotelId;
	private String HotelName;
	private String ownerNm;
	private String ownEmailId;
	private String ownMobNo;
	private String rating;
	@OneToMany(mappedBy="hotel")
	private List<FlatsEntity> flats;
	
	public long getHotelId() {
		return hotelId;
	}
	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return HotelName;
	}
	public void setHotelName(String hotelName) {
		HotelName = hotelName;
	}
	public String getOwnerNm() {
		return ownerNm;
	}
	public void setOwnerNm(String ownerNm) {
		this.ownerNm = ownerNm;
	}
	public String getOwnEmailId() {
		return ownEmailId;
	}
	public void setOwnEmailId(String ownEmailId) {
		this.ownEmailId = ownEmailId;
	}
	public String getOwnMobNo() {
		return ownMobNo;
	}
	public void setOwnMobNo(String ownMobNo) {
		this.ownMobNo = ownMobNo;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public List<FlatsEntity> getFlats() {
		return flats;
	}
	public void setFlats(List<FlatsEntity> flats) {
		this.flats = flats;
	}
	
}
