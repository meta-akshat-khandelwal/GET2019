package com.metacube.restful.facade;

import java.util.ArrayList;

import Utility.Status;

import com.metacube.restful.dao.CategoryDao;
import com.metacube.restful.model.Category;
/**
 * Performs following operations
 *1. Get all category
 *2. Create new Category
 *3. update new Category
 * @author Akshat
 *
 */
public class CategoryFacade {

	CategoryDao categoryDao= new CategoryDao();
	
	/*
	 * Get all category
	 * @return, list of all category
	 */
	public ArrayList<Category> getAllCategory()
	{
		return categoryDao.getAllCategory();
	}
	
	/*
	 * Create new category
	 * @param, category
	 * @return, Status
	 */
	public Status createCategory(Category newCategory)
	{
		
		return categoryDao.createCategory(newCategory);
	}
	
	/*
	 * Update Category name 
	 * @param, category 
	 * @return, Status
	 */
	public Status updateCategoryName(Category category)
	{
		return categoryDao.updateCategoryName(category.getId(), category.getName());
	}
	
}
