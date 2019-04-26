package com.arise.hibernateProject.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="APR_HTL")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
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
	@OneToMany(mappedBy="hotel", cascade=CascadeType.ALL)
	private List<FlatsEntity> flats;
	
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
	public List<FlatsEntity> getFlats() {
		return flats;
	}
	public void setFlats(List<FlatsEntity> flats) {
		this.flats = flats;
	}
	
}
