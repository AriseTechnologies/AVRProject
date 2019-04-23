package com.arise.hibernateProject;


public class FlatReq {

	private long flatId;
	private String flatType;
	private String flatNum;
	private String rooms;
	
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
	public String getRooms() {
		return rooms;
	}
	public void setRooms(String rooms) {
		this.rooms = rooms;
	}
	
}
