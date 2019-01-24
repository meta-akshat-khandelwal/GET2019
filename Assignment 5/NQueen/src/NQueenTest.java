import static  org.junit.Assert.*;    
import org.junit.Test;
public class NQueenTest 
{
	
	//test case with board of dimension 8
	@Test
    public void QueentestPassTest() {
    	boolean expected = true;
    	int startingRow = 4;
        int sizeOfBoard = 8;
        int[][] array = new int[sizeOfBoard][sizeOfBoard];
    	assertEquals(expected, new NQueen().solveQueen(array,startingRow,sizeOfBoard));
    }

	//test case with false expected output
    @Test
    public void QueentestFailTest() {
    	boolean expected = false;
    	int startingRow = 0;
        int sizeOfBoard = 3;
        int[][] array = new int[sizeOfBoard][sizeOfBoard];
    	assertEquals(expected, new NQueen().solveQueen(array,startingRow,sizeOfBoard));
    }
}
