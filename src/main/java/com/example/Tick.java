package com.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tick")
public class Tick {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tick", nullable = false)
	private Calendar tick;

	public Tick() {
		tick = Calendar.getInstance();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getTick() {
		return tick;
	}
	
	public String getTickString() {
		return formatarData(tick);
	}

	public void setTick(Calendar tick) {
		this.tick = tick;
	}

	@Override
	public String toString() {
		return "Tick [id=" + id + ", tick=" + formatarData(tick) + "]";
	}

	private String formatarData(Calendar data) {
		String dataFormatada = "";
		try {
			if (data != null) {
				dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data.getTime());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return dataFormatada;
	}

}
