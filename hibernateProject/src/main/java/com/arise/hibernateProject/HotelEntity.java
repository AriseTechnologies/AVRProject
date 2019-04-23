package com.arise.hibernateProject;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="APR_HTL")
public class HotelEntity{
	
	@Id
	@Column(name="hotelId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="htl_generator")
	@SequenceGenerator(name="htl_generator",initialValue=1,allocationSize=1,sequenceName="hotel_seq")
	private long hotelId;
	private String hotelName;
	private String ownerNm;
	private String ownEmailId;
	private String ownMobNo;
	private String rating;
	@OneToMany( mappedBy="hotel",cascade=CascadeType.ALL)
	private Set<FlatsEntity> flats;
	
	public long getHotelId() {
		return hotelId;
	}
	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
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
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Set<FlatsEntity> getFlats() {
		return flats;
	}
	public void setFlats(Set<FlatsEntity> flats) {
		this.flats = flats;
	}
	
}
