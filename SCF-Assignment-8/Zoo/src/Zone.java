import java.util.ArrayList;
import java.util.List;
/**
 * Zone in a zoo
 * performs the following task
 * 1. add cage to zone
 * 2. to get the category of animal in zone
 * @author akshat khandelwal
 **/

public class Zone {
	int maxNoOfCages;
	String categoryOfAnimal;
	boolean hasCanteen;
	boolean hasPark;
	int occupiedCage = 0;
	public List<Cage> cageList= new ArrayList<Cage>();
	
   
	public Zone(String categoryOfAnimal,int maxNoOfCages, boolean hasCanteen, boolean hasPark) {
		this.maxNoOfCages = maxNoOfCages;
		this.categoryOfAnimal = categoryOfAnimal;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	}

	
	/* Get the category of animal
	 * @param, void
	 * @return category of animal
	 */
	public String getCategoryOfAnimal()
	{
		return categoryOfAnimal;
	}

	
	/*
	 * add cage to zone
	 * @param, cage to add in zone 
	 * @return true if successfully added, false otherwise
	 */
	boolean addCage(Cage cage)
	{	
		if(occupiedCage < maxNoOfCages)
		{
			cageList.add(cage);
			occupiedCage += 1;
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	
}
