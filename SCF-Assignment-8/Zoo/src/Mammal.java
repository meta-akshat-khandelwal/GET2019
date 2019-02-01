/**
 * @author Akshat Khandelwal 
 **/

public class Mammal extends Animal {
  static final String category="Mammal";
  static final String veg="Non veg";
  public Mammal(String name,int age, int weight, String sound)
	{
		super(name,age,weight,sound,category,veg);
	}
	
}
