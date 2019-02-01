import java.util.ArrayList;
/**
 * Maintains the Zoo
 * Performs following task
 * 1. Add zone to zoo
 * 2. Add cage  to zoo
 * 3. Add animal to zoo
 * 4. Remove animal from zoo 
 * @author Akshat Khandelwal
 *
 */

public class Zoo {
	int maxNumberOfZone;		
    int occupiedZone;		
	
     //list of zones available in the zoo 
	public ArrayList<Zone> zoneList = new ArrayList<Zone>();		
	
	
	
	Zoo(int max)
	{
		maxNumberOfZone = max;
	    this.occupiedZone = 0;
	}

    /*
    * add a zone in zoo
    * @param, categoryOfAnimal should not be null otherwise @throws an exception
    * @param, maxNumberOfCages, maximum no. of cages in zone
    * @param, hasCanteen in zone
    * @param, haspPark in zone
    * @return true if added successfully, false otherwise.
    */
    boolean addZone( String categoryOfAnimal,int maxNoOfCages, boolean hasCanteen, boolean hasPark)
    {
        if (categoryOfAnimal == null)
        {
			throw new AssertionError();
		}
        
        //checks for the available space in the zoo for the zone
        if(occupiedZone < maxNumberOfZone)
        {
        	Zone newZone = new Zone(categoryOfAnimal,maxNoOfCages, hasCanteen, hasPark);
    		zoneList.add(newZone);
    		occupiedZone += 1;
    		return true;
        }
        else
        	return false;
		
	}

    /*
    * addCage method to add a new Cage in a zone
    * @param, typeOfAnimal (Lion, Peacock, etc.)
    * @param, categoryOfAnimal (Mammal, Reptile, etc)
    * @param, maxNoOfAnimals in cage.
    * return true if successful or @throws an exception if zone not available
    */
    boolean addCage(String typeOfAnimal, String categoryOfAnimal, int maxNoOfAnimals) throws Exception
    {
        if (typeOfAnimal == null)
        {
        	throw new AssertionError(" null ");
			
		}
		
        if (categoryOfAnimal == null)
        {
			throw new AssertionError("null");
		}

        for(int index=0;index<occupiedZone;index++)
        {	
        	//find the zone of the input available category
        	if(zoneList.get(index).getCategoryOfAnimal().equals(categoryOfAnimal) )
        	{   
        		//return true if cage is added to the zone
        		return zoneList.get(index).addCage(new Cage(typeOfAnimal,categoryOfAnimal,maxNoOfAnimals));
        		 
        	}
        }
        
        //throws an exception if zone is not found
        throw new Exception("Please add zone first");
      
	}

    
     /*
      *  add a new animal to zoo
      * @param, add animal to zoo
      * @return true if animal is added  successfully ,otherwise @throws exception 
      */
    
	boolean addAnimal(Animal animal) throws Exception
    {
		boolean flag=false;
        
        if (animal.getName() == null || animal.getName().length() == 0) 
        {
			throw new AssertionError();
        }
        
        Zone zone;
        int maximumCages=0;
		for (int i = 0; i < zoneList.size(); i++) 
		{	
			zone = zoneList.get(i);
			maximumCages = zone.maxNoOfCages;
			
			//it will check for the zone is available for input type of animal or not
			if(zone.categoryOfAnimal.equals(animal.getCategory()))
			{
				flag=true;
				for(int j=0;j<zone.cageList.size();j++)
				{
					Cage cage = zone.cageList.get(j);
					
					//it will check for the animal present in cage is of same type as of input
					if(cage.typeOfAnimal.equals(animal.getClass().getSimpleName()) 
							&& cage.maxNoOfAnimals > cage.noOfAnimals )
					{
						return zone.cageList.get(j).addAnimal(animal);
					}
				}
			}
		}
		
		if(!flag)
		{
			throw new Exception("Please Add Zone First");
		}
		
		
		
		if(this.addCage(animal.getClass().getSimpleName(), animal.getCategory(), maximumCages))
		{			
			
			 return addAnimal(animal);
		}
		
		return false;
		
	}
		
    
    /*
     * removes animal from zoo
     * @param , animal to remove 
     * @return true if removed, false otherwise
     */
    
    boolean removeAnimal(Animal animal) throws Exception
    {
        if(animal.getName() == null || animal.getName().length() == 0) 
        {
			throw new AssertionError();
        }
       
		for (int i = 0; i < zoneList.size(); i++) 
		{	
			Zone zone = zoneList.get(i);
			
			//find the zone of the input available category
			if(zone.categoryOfAnimal.equals(animal.getCategory()))
			{
				for(int j=0;j<zone.cageList.size();j++)
				{
					Cage cage = zone.cageList.get(j);
					
					//find the cage of input animal type
					if(cage.typeOfAnimal.equals(animal.getClass().getSimpleName()) )
					{
						return zone.cageList.get(j).deathOfAnimal(animal);
						
					}
				}	
			}	
		}
		
		return false;
	}		
}
