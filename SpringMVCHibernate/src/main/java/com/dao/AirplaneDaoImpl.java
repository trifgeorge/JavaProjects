package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.model.Airplane;
@Repository
public class AirplaneDaoImpl implements AirplaneDao {

	public SessionFactory sessionFactory;
	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addAirplane(Airplane a) {
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(a);
	}

	@Override
	public void updateAirplane(Airplane a) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Airplane> listAllAirplanes() {
		Session session=this.sessionFactory.getCurrentSession();
		List<Airplane> airplanes=session.createQuery("from Airplane").list();
		return airplanes;
	}

	@Override
	public Airplane getAirplaneById(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		Airplane a=(Airplane) session.load(Airplane.class, new Integer(id));
		return a;
	}

	@Override
	public void removeAirplane(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		Airplane a=(Airplane) session.load(Airplane.class, new Integer(id));
		if(a!=null){
			session.delete(a);
		}

	}


}
