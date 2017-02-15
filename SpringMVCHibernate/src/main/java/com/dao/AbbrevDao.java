package com.dao;

import java.util.List;

import com.model.Abbrev;

public interface AbbrevDao {

	public void addAbbrev(Abbrev a);
	public void updateAbbrev(Abbrev a);
	public List<Abbrev> listAllAbbrevs();
	public Abbrev getAbbrevById(int id);
	public void removeAbbrev(int id);
}
