package com.springcar.app.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String carLocation;
	@Enumerated(EnumType.STRING)
	private FuelType fuelType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_car")
	private Long idCar;
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "idCar")
	private Set<Images> images;
	
	
	private Long makeId;
	
	public Long getMakeId() {
		return makeId;
	}

	public void setMakeId(Long makeId) {
		this.makeId = makeId;
	}

	private String insuranceValidity;
	private int kilometers;
	private String make;
	private String makeYear;
	private String model;
	private int owner;
	private int price;
	private String registrationYear;
	private String rto;
	private String photo;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Enumerated(EnumType.STRING)
	private TypeTransmission transmission;

	public String getCarLocation() {
		return carLocation;
	}

	public FuelType getFuelType() {
		return fuelType;
	}



	public Long getIdCar() {
		return idCar;
	}
	public Set<Images> getImages() {
		return images;
	}
	

	public String getInsuranceValidity() {
		return insuranceValidity;
	}

	public int getKilometers() {
		return kilometers;
	}

	public String getMake() {
		return make;
	}

	public String getMakeYear() {
		return makeYear;
	}

	public String getModel() {
		return model;
	}

	public int getOwner() {
		return owner;
	}


	public int getPrice() {
		return price;
	}

	
	public String getRegistrationYear() {
		return registrationYear;
	}

	public String getRto() {
		return rto;
	}

	public TypeTransmission getTransmission() {
		return transmission;
	}

	public void setCarLocation(String carLocation) {
		this.carLocation = carLocation;
	}



	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}
	
	public void setImages(Set<Images> images) {
		this.images = images;
	}

	public void setInsuranceValidity(String insuranceValidity) {
		this.insuranceValidity = insuranceValidity;
	}

	
	
	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setMakeYear(String makeYear) {
		this.makeYear = makeYear;
	}

	

	public void setModel(String model) {
		this.model = model;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}


	

	public void setPrice(int price) {
		this.price = price;
	}


	public void setRegistrationYear(String registrationYear) {
		this.registrationYear = registrationYear;
	}

	public void setRto(String rto) {
		this.rto = rto;
	}

	public void setTransmission(TypeTransmission transmission) {
		this.transmission = transmission;
	}

}
