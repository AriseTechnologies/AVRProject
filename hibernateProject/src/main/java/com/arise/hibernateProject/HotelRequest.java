package com.arise.hibernateProject;

import java.util.List;

public class HotelRequest extends BaseRequest{

	private String HotelName;
	private String ownerNm;
	private String ownEmailId;
	private String ownMobNo;
	private String rating;
	private List<FlatsEntity> flats;
	
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
