package com.springcar.app.models.service.interfaces;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springcar.app.models.entity.Car;
import com.springcar.app.models.entity.CarMake;
import com.springcar.app.models.entity.TypeTransmission;

public interface ICarService {
	public List<Car> findAll();
	public Car findById(Long id);
	public List<Car> findByTransmission(TypeTransmission transmission);
	public void save(Car car);
	public Map<String, Set<String>> getAllCarMakes();
	public CarMake findByMake(String make, String model);

}
