package com.springcar.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcar.app.models.dao.ICarImagesDao;
import com.springcar.app.models.entity.Images;
import com.springcar.app.models.service.interfaces.ICarImagesService;

@Service
public class CarImagesService implements ICarImagesService{

	
	@Autowired
	private ICarImagesDao carImagesDao;
	@Override
	public void save(List<Images> images) {
		carImagesDao.saveAll(images);
	}
	

}
