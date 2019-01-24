import static  org.junit.Assert.*;    
import org.junit.Test;

public class LcmHcfTest {
	/*
	    * test case for findLcm() for pass case
	    */
		@Test
	    public void getLcmPassTest() {
	    	int expected = 20;
	    	int numberOne = 10;
	        int numberTwo = 20;
	    	assertEquals(expected, new LcmHcf().findLcm(numberOne,numberTwo));
	    }

	    /*
	    * test case for findLcm() in failure case
	    */
	    @Test
	    public void getLcmFailTest() {
	    	int expected = 15;
	    	int numberOne = 10;
	        int numberTwo = 20;
	    	assertNotEquals(expected, new LcmHcf().findLcm(numberOne,numberTwo));
	    }

	    /*
	    * test case for findHcf() for a pass case 
	    */
	    @Test
	    public void getHcfPassTest() {
	    	int expected = 2;
	    	int numberOne = 8;
	        int numberTwo = 10;
	    	assertEquals(expected, new LcmHcf().findHcf(numberOne,numberTwo));
	    }

	    /*
	    * test case for findHcf() for a failure case 
	    */
	    @Test
	    public void getHcfFailTest() {
	    	int expected = 2;
	    	int numberOne = 8;
	        int numberTwo = 12;
	    	assertNotEquals(expected, new LcmHcf().findHcf(numberOne,numberTwo));
	    }

}
