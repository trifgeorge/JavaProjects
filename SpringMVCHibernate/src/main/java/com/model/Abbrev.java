package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="abbrev")
public class Abbrev {
	@Id
	@Column(name="abbrev_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int abbrev_id;
	@Column(name="city")
	public String city;
	@Column(name="abbrev")
	public String abbrev;
	public int getAbbrev_id() {
		return abbrev_id;
	}
	public void setAbbrev_id(int abbrev_id) {
		this.abbrev_id = abbrev_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAbbrev() {
		return abbrev;
	}
	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abbrev == null) ? 0 : abbrev.hashCode());
		result = prime * result + abbrev_id;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abbrev other = (Abbrev) obj;
		if (abbrev == null) {
			if (other.abbrev != null)
				return false;
		} else if (!abbrev.equals(other.abbrev))
			return false;
		if (abbrev_id != other.abbrev_id)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		return true;
	}

	
}
