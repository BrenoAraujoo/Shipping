package com.shipping.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Transport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "value_transport")
	private Double value;
	@JsonFormat(shape = Shape.STRING,pattern = "yyyy-MM-dd")
	private Date date;
	private String observation;
	private ShippingCompany company;

	public Transport() {
	}

	public Transport(Long id, Double value, Date date, String observation, ShippingCompany company) {
		super();
		this.id = id;
		this.value = value;
		this.date = date;
		this.observation = observation;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(company, date, id, observation, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transport other = (Transport) obj;
		return Objects.equals(company, other.company) && Objects.equals(date, other.date)
				&& Objects.equals(id, other.id) && Objects.equals(observation, other.observation)
				&& Objects.equals(value, other.value);
	}

	
	
}
