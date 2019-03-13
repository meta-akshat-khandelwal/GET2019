package Question2;

import static org.junit.Assert.*;
import org.junit.Test;

public class NumberOfUniqueCharacterTestCase {

	
	@Test
	public void test_countsNmberOfUniqueCharacters_withString_shouldReturn_4()
	{
		 NumberOfUniqueCharacter uniqueCharacter = new  NumberOfUniqueCharacter();
		assertEquals(4,uniqueCharacter.countsNmberOfUniqueCharacters("Amit"));
	}
	@Test
	public void test_countsNmberOfUniqueCharacters_withString_shouldReturn_3()
	{
		 NumberOfUniqueCharacter uniqueCharacter = new NumberOfUniqueCharacter();
		assertEquals(3,uniqueCharacter.countsNmberOfUniqueCharacters("HELLO"));
	}
	
	@Test
	public void test_countsNmberOfUniqueCharacters_withString_shouldReturn_1()
	{
		 NumberOfUniqueCharacter uniqueCharacter = new NumberOfUniqueCharacter();
		assertEquals(1,uniqueCharacter.countsNmberOfUniqueCharacters("AaaaAmmM"));
	}
	
	@Test
	public void test_countsNmberOfUniqueCharacters_withNull_shouldReturn_0()
	{
		 NumberOfUniqueCharacter uniqueCharacter = new NumberOfUniqueCharacter();
		assertEquals(0,uniqueCharacter.countsNmberOfUniqueCharacters(""));
	}

}
