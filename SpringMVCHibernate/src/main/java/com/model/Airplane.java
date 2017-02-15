package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "airplane")
public class Airplane {

	@Id
	@Column(name = "airplane_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int airplane_id;
	@Column(name = "aircrafttype")
	public String aircrafttype;
	@Column(name = "departure")
	public String departure;
	@Column(name = "arrival")
	public String arrival;
	@Column(name = "fromm")
	public String fromm;
	@Column(name = "too")
	public String too;
	@Column(name = "delay")
	public String delay;
	@Column(name = "seats")
	public int seats;
	@Column(name = "seatsr")
	public int seatsr;
	public int getAirplane_id() {
		return airplane_id;
	}
	public void setAirplane_id(int airplane_id) {
		this.airplane_id = airplane_id;
	}
	public String getAircrafttype() {
		return aircrafttype;
	}
	public void setAircrafttype(String aircrafttype) {
		this.aircrafttype = aircrafttype;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getFromm() {
		return fromm;
	}
	public void setFromm(String fromm) {
		this.fromm = fromm;
	}
	public String getToo() {
		return too;
	}
	public void setToo(String too) {
		this.too = too;
	}
	public String getDelay() {
		return delay;
	}
	public void setDelay(String delay) {
		this.delay = delay;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getSeatsr() {
		return seatsr;
	}
	public void setSeatsr(int seatsr) {
		this.seatsr = seatsr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aircrafttype == null) ? 0 : aircrafttype.hashCode());
		result = prime * result + airplane_id;
		result = prime * result + ((arrival == null) ? 0 : arrival.hashCode());
		result = prime * result + ((delay == null) ? 0 : delay.hashCode());
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + ((fromm == null) ? 0 : fromm.hashCode());
		result = prime * result + seats;
		result = prime * result + seatsr;
		result = prime * result + ((too == null) ? 0 : too.hashCode());
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
		Airplane other = (Airplane) obj;
		if (aircrafttype == null) {
			if (other.aircrafttype != null)
				return false;
		} else if (!aircrafttype.equals(other.aircrafttype))
			return false;
		if (airplane_id != other.airplane_id)
			return false;
		if (arrival == null) {
			if (other.arrival != null)
				return false;
		} else if (!arrival.equals(other.arrival))
			return false;
		if (delay == null) {
			if (other.delay != null)
				return false;
		} else if (!delay.equals(other.delay))
			return false;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		if (fromm == null) {
			if (other.fromm != null)
				return false;
		} else if (!fromm.equals(other.fromm))
			return false;
		if (seats != other.seats)
			return false;
		if (seatsr != other.seatsr)
			return false;
		if (too == null) {
			if (other.too != null)
				return false;
		} else if (!too.equals(other.too))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Airplane [airplane_id=" + airplane_id + ", aircrafttype=" + aircrafttype + ", departure=" + departure
				+ ", arrival=" + arrival + ", fromm=" + fromm + ", too=" + too + ", delay=" + delay + ", seats=" + seats
				+ ", seatsr=" + seatsr + "]";
	}

}
