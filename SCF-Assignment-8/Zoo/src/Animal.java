/**
 * 
 * @author Akshat Khandelwal
 *
 */
public class Animal {
 
	private String name;
	private int age;
	private int weight;
	private String sound;
	private String category;
	private String veg;
		
	public Animal()
	{
		
	}
	public Animal(String name, int age, int weight,String sound, String category,String veg)
	{
		this.name=name;
		this.age=age;
		this.weight=weight;
		this.sound=sound;
		this.category=category;
		this.veg=veg;
	}
	public void setVeg(String veg) 
	{
		this.veg = veg;
	}
	
	public String getName()
	{
		return name;
	}
	public String getVeg() 
	{
		return veg;
	}
	public int getAge()
	{
		return age;
	}
	public int getWeight()
	{
		return weight;
	}
	public String getSound()
	{
		return sound;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	public void setSound(String sound)
	{
		this.sound = sound;
	}
	public String getCategory() 
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	
}
