package com.arise.hibernateProject.handler;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.arise.hibernateProject.entity.FlatsEntity;
import com.arise.hibernateProject.entity.HotelEntity;
import com.arise.hibernateProject.payload.FlatResponse;
import com.arise.hibernateProject.payload.HotelRequest;
import com.arise.hibernateProject.payload.HotelResponse;
import com.arise.hibernateProject.util.HibernateUtil;
import com.arise.hibernateProject.util.Error;

public class HotelServiceHandler {

	/*
	 * Admin user entry to register their properties
	 */
	public static Response adminUserEntry(HotelRequest req) {

		HotelResponse hr = new HotelResponse();

		HotelEntity hotel = new HotelEntity();
		hotel.setHotelName(req.getHotelName().toUpperCase());
		hotel.setOwnerNm(req.getOwnerNm());
		hotel.setOwnEmailId(req.getOwnEmailId());
		hotel.setOwnMobNo(req.getOwnMobNo());
		hotel.setRating(req.getRating());
		List<FlatsEntity> flats = new ArrayList<>();
		for (FlatsEntity f : req.getFlats()) {
			FlatsEntity flat = new FlatsEntity();
			flat.setFlatNum(f.getFlatNum());
			flat.setFlatType(f.getFlatType());
			flat.setFlatArea(f.getFlatArea());
			flat.setFloorNo(f.getFloorNo());
			flat.setFurniture(f.getFurniture());
			flat.setMainEntrance(f.getMainEntrance());
			flat.setElectricity(f.getElectricity());
			flat.setGasConn(f.getGasConn());
			flat.setWater(f.getWater());
			flat.setMaintenanceCost(f.getMaintenanceCost());
			flat.setPayingGest(f.getPayingGest());
			flat.setHotel(hotel);
			flats.add(flat);
		}
		hotel.setFlats(flats);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.save(hotel);
		trx.commit();

		hr.setHotelName(req.getHotelName());
		hr.setOwnerNm(req.getOwnerNm());

		return Response.status(200).entity(hr).build();

	}

	public static Response getHotelDetails(String hotelName) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		HotelEntity hotel = getHotelDetailsByName(hotelName, session);
		
		HotelResponse res = new HotelResponse();
		if (null == hotel) {
			String msg = "No Hotel found";
			getError(res, msg);
			return Response.status(200).entity(res).build();
		}

		res.setHotelName(hotel.getHotelName());
		res.setOwnEmailId(hotel.getOwnEmailId());
		res.setOwnerNm(hotel.getOwnerNm());
		res.setOwnMobNo(hotel.getOwnMobNo());

		List<FlatResponse> flats = new ArrayList<>();
		for (FlatsEntity f : hotel.getFlats()) {
			FlatResponse flatRes = new FlatResponse();
			flatRes.setFlatNum(f.getFlatNum());

			flatRes.setFlatNum(f.getFlatNum());
			flatRes.setFlatType(f.getFlatType());
			flatRes.setFlatArea(f.getFlatArea());
			flatRes.setFloorNo(f.getFloorNo());
			flatRes.setFurniture(f.getFurniture());
			flatRes.setMainEntrance(f.getMainEntrance());
			flatRes.setElectricity(f.getElectricity());
			flatRes.setGasConn(f.getGasConn());
			flatRes.setWater(f.getWater());
			flatRes.setMaintenanceCost(f.getMaintenanceCost());
			flatRes.setPayingGest(f.getPayingGest());
			flats.add(flatRes);
		}
		res.setFlats(flats);

		return Response.status(200).entity(res).build();
	}

	/**
	 * Method to get the errors 
	 * @param res
	 */
	private static void getError(HotelResponse res, String msg) {
		List<Error> errors = new ArrayList<>();
		Error err = new Error();
		err.setMsg(msg);
		errors.add(err);
		res.setErrList(errors);
	}

	/**
	 * Method to fetch Hotel Entity by hotel name
	 * @param hotelName
	 * @param session
	 * @return
	 */
	private static HotelEntity getHotelDetailsByName(String hotelName,
			Session session) {
		String sql = "select hotel from HotelEntity hotel where hotel.hotelName=:hotelNm";
		Query query = session.createQuery(sql);
		query.setParameter("hotelNm", hotelName.toUpperCase());
		query.setCacheable(true);
		HotelEntity hotel = (HotelEntity) query.uniqueResult();
		return hotel;
	}

	public static Response adminUserUpdate(HotelRequest req) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		HotelResponse hr = new HotelResponse();
		HotelEntity hotel = getHotelDetailsByName(req.getHotelName().toUpperCase(), session);

		if (null == hotel) {
			String msg = "No Hotel found";
			getError(hr, msg);
			return Response.status(200).entity(hr).build();
		}

		if(null != req.getHotelName()){
		hotel.setHotelName(req.getHotelName().toUpperCase());
		}
		if(null != req.getOwnerNm()){
		hotel.setOwnerNm(req.getOwnerNm());
		}
		if(null != req.getOwnEmailId()){
		hotel.setOwnEmailId(req.getOwnEmailId());
		}
		if(null != req.getOwnMobNo()){
		hotel.setOwnMobNo(req.getOwnMobNo());
		}
		if(null != req.getRating()){
		hotel.setRating(req.getRating());
		}
		List<FlatsEntity> dbFlats = hotel.getFlats();
		if (null != req.getFlats()) {
			List<FlatsEntity> flats = new ArrayList<>();
			for (FlatsEntity f : req.getFlats()) {
				
				String sql = "select flat from FlatsEntity flat where flat.flatNum=:flatNum";
				Query query = session.createQuery(sql);
				query.setParameter("flatNum", f.getFlatNum());
				query.setCacheable(true);
				FlatsEntity flat = (FlatsEntity) query.uniqueResult();
				
				flat.setFlatNum(f.getFlatNum());
				flat.setFlatType(f.getFlatType());
				flat.setFlatArea(f.getFlatArea());
				flat.setFloorNo(f.getFloorNo());
				flat.setFurniture(f.getFurniture());
				flat.setMainEntrance(f.getMainEntrance());
				flat.setElectricity(f.getElectricity());
				flat.setGasConn(f.getGasConn());
				flat.setWater(f.getWater());
				flat.setMaintenanceCost(f.getMaintenanceCost());
				flat.setPayingGest(f.getPayingGest());
				flat.setHotel(hotel);
				flats.add(flat);
			}
			hotel.setFlats(flats);
		}

		session.update(hotel);
		trx.commit();

		hr.setHotelName(hotel.getHotelName());
		hr.setOwnerNm(hotel.getOwnerNm());

		return Response.status(200).entity(hr).build();

	}
}
