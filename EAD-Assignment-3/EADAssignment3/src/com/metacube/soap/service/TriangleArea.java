package com.metacube.soap.service;
/**
 * Calculate Area of Triangle
 * @author Akshat Khandelwal
 *
 */
public class TriangleArea {
	
	
	/*
	 * Calculates area of an Triangle
	 * @param, first side of triangle
	 * @param, second side of triangle
	 * @param, third side of triangle
	 * @return, area of triangle
	 */
	public double calculateArea(double side1, double side2, double side3)
	{
		// calculates half of perimeter of triangle
		double halfPerimeter=(side1+side2+side3)/2;
		
		//area using heron's formula
		double area= Math.sqrt(halfPerimeter*(halfPerimeter-side1)*(halfPerimeter-side2)*(halfPerimeter-side3));
		
		return area;
		
	}
}
