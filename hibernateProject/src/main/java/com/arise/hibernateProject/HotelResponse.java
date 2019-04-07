package com.arise.hibernateProject;

public class HotelResponse extends BaseResponse {

	private String HotelName;
	private String ownerNm;
	private String ownEmailId;
	private String ownMobNo;
	
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
	
}
