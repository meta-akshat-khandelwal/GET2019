import java.util.ArrayList;

/**
 * 
 * @author admin
 *
 */
public final class Polynomial {
 
  /*
   *  An 2d array to store coefficients and powers of polynomials 
   */
	private int polynomial[][];
	
	/*
	 * Constructor to create and initialize the object with given inputs 
	 */
	public Polynomial(int [] inputArray)
	{
		int length=0;
		// to calculate length of input array excluding zeros
		for(int i=0;i<inputArray.length;i++)
		{
			if(inputArray[i]>0)
			{
				length++;
			}
		}
		
		polynomial= new int[length][2];
		
		int coefficient=0;
		
		// to insert values in 
		for(int i=0;i<inputArray.length;i++)
		{
			if(inputArray[i]!=0 && coefficient<length)
			{
				polynomial[coefficient][0]=inputArray[i];
				
				polynomial[coefficient++][1]=i;
				
				
			}
		}
	}
	
	
	
	
	
	
	
	/*
	 * To add to Polynomials
	 * @param Polynomial 1
	 * @param Polynomial 2
	 * returns addition of polynomials in Poly class Object
	 */
	
	public  void addPoly(Polynomial p1 , Polynomial p2)
	{
	   ArrayList<Integer> coefficient= new ArrayList<Integer>();
	   ArrayList<Integer> degree= new ArrayList<Integer>();
	   
	   /* 
	    * to search and put addition of coefficients of 
	      polynomial 1 and 2 in coefficient arraylist and their power in degree arraylist 
	   */
	   for( int i=0;i<p1.polynomial.length;i++)
	   {
		   for(int j=0;j<p2.polynomial.length; j++)
		   {
			   if(p1.polynomial[i][1]==p2.polynomial[j][1])
			   {
				   coefficient.add(p1.polynomial[i][0]+p2.polynomial[j][0]);
				   degree.add(p1.polynomial[i][1]);
				   break;
				   
			   }
		   }
	   }
	   
	   /*
	    * to insert coefficient and power in coefficient arraylist and degree arraylist 
	      if not present of polynomial 1st  
	    */
	   for(int i=0;i<p1.polynomial.length;i++)
	   {
		   if (degree.contains(p1.polynomial[i][1])==false)
		   {
			   coefficient.add(p1.polynomial[i][0]);
			   degree.add(p1.polynomial[i][1]);
		   }
	   }
	
	   /*
	    * to insert coefficient and power in coefficient arraylist and degree arraylist 
	      if not present of polynomial 1st  
	    */
	   
	   for(int i=0;i<p2.polynomial.length;i++)
	   {
		   if (degree.contains(p2.polynomial[i][1])==false)
		   {
			   coefficient.add(p2.polynomial[i][0]);
			   degree.add(p2.polynomial[i][1]);
		   }
	   }

	}
	
	
	
	
	
	/*
	 * Multiplies two polynomials
	 * @param 1st Polynomial
	 * @param 2nd Polynomial
	 * returns multiplication in Poly class object
	 */
	 
	 public  void multiplyPoly(Polynomial p1, Polynomial p2)
	 {
		 ArrayList<Integer> coefficient= new ArrayList<Integer>();
		 ArrayList<Integer> degree=  new ArrayList<Integer>();
		 
		/*
		 * Multiplies coefficients of polynomial 1st with 
		   every coefficients of 2n polynomial and stores it into coefficient arraylist
		 * Adds power of coefficients of polynomial 1st with 
		   every coefficients of 2n polynomial and stores it into degree arraylist
		 */
		 for(int i=0;i<p1.polynomial.length;i++)
		 {
			
			 for(int j=0;j<p2.polynomial.length;j++)
			 {
				coefficient.add(p1.polynomial[i][0]*p2.polynomial[j][0]);
				degree.add(p1.polynomial[i][1]+p2.polynomial[j][1]);
			 }
		 }
		 
		 
		 ArrayList<Integer> finalcoefficient= new ArrayList<Integer>();
		 ArrayList<Integer> finaldegree= new ArrayList<Integer>(); 
		 int sum;
		 
		 /*
		  * adds coefficients of same power 
		    and insert them into finalcoefficient arraylist 
		    and their power into finaldegree arraylist
		  */
		 for(int i=0;i<degree.size();i++)
		 {
			 sum=coefficient.get(i);
			 if(!finaldegree.contains(degree.get(i)))
			 {
				 for(int j=i+1;j<degree.size();j++)
				 {
					 if(degree.get(i)==degree.get(j))
					 {
						 sum= sum+coefficient.get(j);
					 }
				 }
				 finalcoefficient.add(sum);
				 finaldegree.add(degree.get(i));
			 }
			 
		 }
		
		
	 }
	 
	 
	 
	 
	 /*
	  * finds the degree of polynomial(highest power in polynomial)
	  * @param does not require any parameter
	  * returns degree of polynomial
	  */
	 
	 public  int degree()
	 {
		 int maxDegree=polynomial[0][1];
		 
		 for(int i=1;i<polynomial.length;i++)
		 {
			 if(polynomial[i][1]>maxDegree)
			 {
				 maxDegree=polynomial[i][1];
			 }
		 }
		 
		 return maxDegree;
	 }
	 
	 
	 
	 
	 /*
	  * to calculate the value of polynomial
	  * @param value of variable in polynomial
	  * returns value of polynomial
	  */
	 
	 public float evaluate(float value)
	 {
		 float result=0.0f;
		 
		 for(int i=0;i<polynomial.length;i++)
		 {
			 result= result+(float)Math.pow(value, polynomial[i][1])*polynomial[i][0];
		 }
		 
		 return result;
	 }
	 
	 
	 /*
	  * 
	  */
	 
	public  static void main(String args[])
	{
		int num[]={5,8,3};
		int num2[]={1,2,3,6};
		Polynomial p1 = new Polynomial(num);
		Polynomial p2= new Polynomial(num2);
		p1.addPoly(p1, p2);
		//p1.print();
		p1.multiplyPoly(p1, p2);
		System.out.println(p1.degree());
		System.out.println(p1.evaluate(2));
		
	}
	
}
