package com.example;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tick")
public class Tick {
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tick", nullable = false)
	private Calendar tick;

	public Tick() {
		tick = Calendar.getInstance();
	}
	
	public Calendar getTick() {
		return tick;
	}

	public void setTick(Calendar tick) {
		this.tick = tick;
	}

	@Override
	public String toString() {
		return "Tick [tick=" + tick + "]";
	}

}
