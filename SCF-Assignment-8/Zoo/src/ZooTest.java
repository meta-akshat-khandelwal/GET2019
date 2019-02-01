import static org.junit.Assert.*;
import org.junit.Test;


public class ZooTest {
	Zoo zoo = new Zoo(5); // initializing zoo with 5 zones
	@Test
    public void testZoo_withDifferentInputs_shouldReturn_Output()throws Exception 
    {
			
		
		
			//adding the zone mammal type in zoo
			assertTrue(zoo.addZone( "Mammal",3, true, true));
			
			
			
			//adding the cage in the zone mammal
			assertTrue(zoo.addCage("Lion", "Mammal", 2));
			
			
			
			//adding of two animals in cage created above
			assertTrue(zoo.addAnimal(new Lion("Lion1" , 10 , 40)));
			assertTrue(zoo.addAnimal(new Lion("Lion2" , 16 , 50)));
			
			
						
			// will show the message to add zone first
		    try
			{
				assertTrue(zoo.addAnimal(new Sparrow("Sparrow-1" ,10 ,13)));
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage()); 
			}
			
		
			// will show the message to add zone first
			try
			{
				assertTrue(zoo.addAnimal(new Snake("Snake-1" ,10 ,13)));
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage()); 
			}
			
			
			//adding zone of reptile in zoo
			assertTrue(zoo.addZone("Reptile", 2, false, true));
			
			
			//adding cage of type snake in zone reptile in zoo
			assertTrue(zoo.addCage("Snake","Reptile", 3));
	
			// snake will be added in the cage as the zone of type reptile is present
			try
			{
				assertTrue(zoo.addAnimal(new Snake("Snake-1" ,10 ,13)));
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage()); 
			}
			
			
			//remove the animal lion from the cage
			assertTrue(zoo.removeAnimal(new Lion("Lion1" , 10 , 40)));
			
					
	}

   
}
