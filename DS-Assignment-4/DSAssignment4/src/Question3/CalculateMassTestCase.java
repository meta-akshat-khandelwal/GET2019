package Question3;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateMassTestCase {

	
	//positive  Test case of calculateMolecularMass
	@Test
	public void test_calculateMolecularMass_withCompound_ShouldReturn_massAs29()
	{
		CalculateMass chemicalAtomicMass = new CalculateMass();
		try {
			assertEquals(29,chemicalAtomicMass.calculateMolecularMass("CHO"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	// positive Test case of calculateMolecularMass
	@Test
	public void test_calculateMolecularMass_withCompound_ShouldReturn_massAs45()
	{
		CalculateMass chemicalAtomicMass = new CalculateMass();
		try {
			assertEquals(45,chemicalAtomicMass.calculateMolecularMass("CHO2"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Test case of calculateMolecularMass with error
	@Test
	public void test_calculateMolecularMass_withInvalidCompound_ShouldThrowError()
	{
		CalculateMass chemicalAtomicMass = new CalculateMass();
		try {
			assertEquals(29,chemicalAtomicMass.calculateMolecularMass("CHA"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Test case of calculateMolecularMass with null as input and 0 as output
	@Test
	public void test_calculateMolecularMass_withNull_ShouldReturn_0()
	{
		CalculateMass chemicalAtomicMass = new CalculateMass();
		try {
			assertEquals(0,chemicalAtomicMass.calculateMolecularMass(""));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
