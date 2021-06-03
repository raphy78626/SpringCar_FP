package com.springcar.app.models.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcar.app.models.dao.ICarDao;
import com.springcar.app.models.dao.ICarMakeDao;
import com.springcar.app.models.entity.Car;
import com.springcar.app.models.entity.CarMake;
import com.springcar.app.models.entity.TypeTransmission;
import com.springcar.app.models.service.interfaces.ICarService;

@Service
public class CarService implements ICarService {

	@Autowired
	ICarDao carDao;
	
	@Autowired 
	ICarMakeDao carMakeDao;

	@Override
	public List<Car> findByTransmission(TypeTransmission transmission) {
		return carDao.findByTransmission(transmission).orElse(null);
	}

	@Override
	public List<Car> findAll() {
		return (List<Car>) carDao.findAll();
	}

	@Override
	public Car findById(Long id) {
		
		return carDao.findById(id).orElse(null);
	}

	@Override
	public void save(Car car) {
		carDao.save(car);
	}

	@Override
	public Map<String, Set<String>> getAllCarMakes() {
		Map<String, List<String>> carMakeList = new HashMap<>();
		Optional<List<CarMake>> optionalCarMakeList = carMakeDao.getAllCarMake();
		if(optionalCarMakeList.isPresent()) {
			
			return buildHashmapCarMake(optionalCarMakeList.get());
		}
		return Collections.emptyMap();
	}

	private Map<String, Set<String>> buildHashmapCarMake(List<CarMake> carMakeList) {
		Map<String, Set<String>> carMakeMap = new HashMap<>();
		for(CarMake carMake : carMakeList) {
			if(carMakeMap.containsKey(carMake.getMake())) {
				Set<String> tempSet = carMakeMap.get(carMake.getMake());
				tempSet.add(carMake.getModel());
				carMakeMap.put(carMake.getMake(), tempSet);
			}
			else {
				Set<String> tempSet = new HashSet<>();
				tempSet.add(carMake.getModel());
				carMakeMap.put(carMake.getMake(), tempSet);
			}
		}
		return carMakeMap;
	}

	@Override
	public CarMake findByMake(String make, String model) {
		CarMake carMake = null;
		Optional<List<CarMake>> optionalCarMakeList = carMakeDao.findByCarMakeAndModel(make, model);
		if(optionalCarMakeList.isPresent() &&  !optionalCarMakeList.get().isEmpty()) {
			carMake = optionalCarMakeList.get().get(0);
		}
		
		return carMake;
	}

}
