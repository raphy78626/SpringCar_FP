package com.springcar.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springcar.app.models.entity.Images;

public interface ICarImagesDao  extends CrudRepository<Images, Long>{

}
