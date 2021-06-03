package com.springcar.app.models.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springcar.app.models.entity.Car;
import com.springcar.app.models.entity.CarMake;
import com.springcar.app.models.entity.TypeTransmission;

public interface ICarMakeDao extends CrudRepository<CarMake, Long> { 
	
	

	@Query("select u from CarMake u")
	public Optional<List<CarMake>> getAllCarMake();
	
	@Query("select u from CarMake u where u.make = ?1 and u.model= ?2 ")
	public Optional<List<CarMake>> findByCarMakeAndModel(String carMake, String carModel);

}
