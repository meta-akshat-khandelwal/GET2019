import java.util.ArrayList;
/**
 * Cage of animal
 * Performs the following task:
 * 1. Adds the animal to cage
 * 2. Removes the animal from cage
 * @author Akshat Khandelwal
 */

public class Cage {
	
	int noOfAnimals=0;
	String typeOfAnimal;
	int maxNoOfAnimals;
	String categoryofAnimal;
	ArrayList<Animal> animalList = new ArrayList<Animal>(); 
	
	
   
	public Cage( String typeOfAnimal, String categryofAnimal, int maxNoOfAnimals) {
		this.typeOfAnimal = typeOfAnimal;
		this.categoryofAnimal = categryofAnimal;
		this.maxNoOfAnimals = maxNoOfAnimals;
	}

	/*
	 * Add the animal to  cage 
	 * @param, Animal to add in cage of Animal object
	 * @return, true if animal is added , false otherwise
	 */
	boolean addAnimal(Animal animal)
	{
		for(int index=0;index<animalList.size();index++)
		{
			//checks for the same name of animal already exist or not
			if(animalList.get(index).getName().equals(animal.getName()))
			{
				return false;
			}
		}

		animalList.add(animal);
		noOfAnimals += 1;
		return true;
		
	}
	

	/*
	 * remove animal from cage
	 * @param, Animal to be removed of animal 
	 * @return if successfully remove, false otherwise
	 */
	boolean deathOfAnimal(Animal animal)
	{

		for(int index=0;index<animalList.size();index++)
		{
			if(animalList.get(index).getName().equals(animal.getName()))
			{
				animalList.remove(animal);
				noOfAnimals -= 1;
				return true;
			}
		}

		return false;
	}

}
