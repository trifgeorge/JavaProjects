package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.model.Abbrev;

@Repository
public class AbbrevDaoImpl implements AbbrevDao {

	public SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addAbbrev(Abbrev a) {
		

	}

	@Override
	public void updateAbbrev(Abbrev a) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Abbrev> listAllAbbrevs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Abbrev getAbbrevById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAbbrev(int id) {
		// TODO Auto-generated method stub

	}

	

}
