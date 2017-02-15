package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.model.Airport;
@Repository
public class AirportDaoImpl implements AirportDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory=sf;
	}
	@Override
	public List<Airport> listAirports() {
		Session session=this.sessionFactory.getCurrentSession();
		List<Airport> airports=session.createQuery("from Airport").list();
		return airports;
	}

}
