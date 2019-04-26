package com.arise.hibernateProject.payload;

import java.util.List;


public class HotelResponse extends BaseResponse {

	private String hotelName;
	private String ownerNm;
	private String ownEmailId;
	private String ownMobNo;
	private List<FlatResponse> flats;
	
	
	public List<FlatResponse> getFlats() {
		return flats;
	}
	public void setFlats(List<FlatResponse> flats) {
		this.flats = flats;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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
	
}
