package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.AirportDao;
import com.model.Airport;

public class AirportServiceImpl implements AirportService {

	private AirportDao airportDao;

	public void setAirportDao(AirportDao airportDao) {
		this.airportDao = airportDao;
	}

	@Override
	@Transactional
	public List<Airport> listAirports() {
		return this.airportDao.listAirports();
	}

}
