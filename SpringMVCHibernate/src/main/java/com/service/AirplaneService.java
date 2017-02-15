package com.service;

import java.util.List;

import com.model.Airplane;

public interface AirplaneService {
	
	public void addAirplane(Airplane a);
	public void updateAirplane(Airplane a);
	public List<Airplane> listAllAirplanes();
	public Airplane getAirplaneById(int id);
	public void removeAirplane(int id);

}
