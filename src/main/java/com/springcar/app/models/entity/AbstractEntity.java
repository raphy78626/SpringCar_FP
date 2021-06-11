package com.springcar.app.models.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import lombok.ToString;

@ToString
@MappedSuperclass
public abstract class AbstractEntity implements Serializable{

	/**
	 * Serial Version Id.
	 */
	private static final long serialVersionUID = 2051112041784928754L;
	
	@Override
	public int hashCode() {
			return super.hashCode();
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);	

	}
	
	
}
