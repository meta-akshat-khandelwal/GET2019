package com.metacube.restful.controller;

import java.util.ArrayList;

import Utility.Status;

import com.metacube.restful.facade.CategoryFacade;
import com.metacube.restful.model.Category;
/**
 * Performs following operations
 *1. Get all category
 *2. Create new Category
 *3. update new Category
 * @author Akshat
 *
 */
public class CategoryController {
	
	CategoryFacade categoryFacade = new CategoryFacade();
	/*
	 * Get all category
	 * @return, list of all category
	 */
	public ArrayList<Category> getAllCategory()
	{
		return categoryFacade.getAllCategory();
	}
	
	/*
	 * Create new category
	 * @param, category
	 * @return, Status
	 */
	public Status createCategory(Category newCategory)
	{	
		return categoryFacade.createCategory(newCategory);
	}
	
	/*
	 * Update Category name 
	 * @param, category 
	 * @return, Status
	 */
	public Status UpdateCategoryName(Category category)
	{
		return categoryFacade.updateCategoryName(category);
	}
}