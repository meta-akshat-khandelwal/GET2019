/*
 * To calculate LCM and HCF
 */
public class LcmHcf {

	/*
	* method  to compute HCF 
	* @param first holds first value
	* @param second holds the second value
	* returns the computed HCF
	*/
 public	int findHcf(int first, int second) 
    { 
      if (second == 0) 
      {
        return first; 
      }
      else
      {
    	return findHcf(second, first % second);  
      }
      
    } 
	
	/*
	* method to compute LCM 
	* @param first holds first value 
	* @param second holds  second value
	* return lCM
	*/
	public int findLcm(int first, int second)
	{  
	   // uses the HCF to find LCM 		
		int lcm = (first*second)/findHcf(first, second);
		return lcm;
	}
	
	
}
