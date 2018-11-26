package pkgOperations;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class OperationsTest {
	
	static Operations op1, op2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		op1 = new Operations();
		op2 = new Operations();
	}

	
	@Test
	public void shouldCompareTwoObjects() {
		assertNotSame(op1, op2);
		assertSame(op1, op1);
	}
	
	
	@Test
	public void shouldTestHighestOf() {
		assertEquals("CASO 1", 16, Operations.highestOf(16, 9),0);
		assertEquals("CASO 2", 17, Operations.highestOf(16, 9),1);
		assertEquals("CASO 3", 15, Operations.highestOf(16, 9),1);
	}

	
	@Test
	public void sohuldTestLowestOf() {
		assertFalse("CASO 4", 16 == Operations.lowestOf(16, 9));
		assertTrue("CASO 5", 9 == Operations.lowestOf(16, 9));
	}
	
	
	@Test
	public void shouldTestSqrt() {
		assertEquals("CASO 8", 9.380, Operations.sqrt(88),0.001);
	}

	
	@Test(expected = AssertionError.class)
	public void shouldTestDivide () throws Exception{
		assertEquals("CASO 9", 25, Operations.divide(50, 2),25);
		assertEquals("CASO 10", 0, Operations.divide(50, 0),0);
		assertEquals("CASO 11", 0, Operations.divide(0, 0),0);
	}
	

	@Test(expected = AssertionError.class)
	public void shouldTestMultiply() throws Exception {
		assertEquals("CASO 12", 1000000000, Operations.multiply(1000000, 1000000),0);
	}
	

	@Test
	public void shouldTestSum() {
		assertEquals("CASO 13", 20, Operations.sum(10, 10),0);
		assertFalse("CASO 14", 21 == Operations.sum(10, 10));
		assertTrue("CASO 15", 20 == Operations.sum(10, 10));
	}
}
