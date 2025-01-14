package com.springcar.app.models.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springcar.app.models.entity.Car;
import com.springcar.app.models.entity.Category;
import com.springcar.app.models.entity.TypeTransmission;

public interface ICarDao extends CrudRepository<Car, Long> {



	@Query("select u from Car u where u.transmission = ?1")
	public Optional<List<Car>> findByTransmission(TypeTransmission transmission);
	

}
