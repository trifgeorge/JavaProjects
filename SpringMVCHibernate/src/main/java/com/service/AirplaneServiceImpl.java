package com.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AirplaneDao;
import com.model.Airplane;

@Service
public class AirplaneServiceImpl implements AirplaneService {

	
	
	public AirplaneDao airplaneDao;
	
	
	public void setAirplaneDao(AirplaneDao airplaneDao) {
		this.airplaneDao = airplaneDao;
	}

	@Override
	@Transactional
	//proxy methods
	public void addAirplane(Airplane a) {
		this.airplaneDao.addAirplane(a);

	}

	@Override
	@Transactional
	public void updateAirplane(Airplane a) {
		this.airplaneDao.updateAirplane(a);

	}

	@Override
	@Transactional
	public List<Airplane> listAllAirplanes() {
		return this.airplaneDao.listAllAirplanes();
	}

	@Override
	@Transactional
	public Airplane getAirplaneById(int id) {
		return this.airplaneDao.getAirplaneById(id);
	}

	@Override
	@Transactional
	public void removeAirplane(int id) {
		this.airplaneDao.removeAirplane(id);

	}

	
}
