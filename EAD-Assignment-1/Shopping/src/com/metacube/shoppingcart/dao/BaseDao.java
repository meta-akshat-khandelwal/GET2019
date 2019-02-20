package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.enums.status;

public interface BaseDao<T> {
	
	
	public status add(T entity);
	
	public status delete(T entity);
	
	public status update(T entity,T entityUpdate);
	
	
	

}
