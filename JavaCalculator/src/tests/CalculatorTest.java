package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import arithmetics.*;

public class CalculatorTest {
	
	@Test
	  public void testAdd() throws ArithmeticException {
		
		int x = 2, y = 10;
		String sign = "+";
		int actual = 0, expected = 12;
	    actual = ArithmeticOperations.calculate(x, y, sign);
	    assertEquals(expected, actual);
	  }
	
	@Test
	  public void testSub() throws ArithmeticException {
		
		int x = 2, y = 10;
		String sign = "-";
		int actual = 0, expected = -8;
	    actual = ArithmeticOperations.calculate(x, y, sign);
	    assertEquals(expected, actual);
	  }
	
	@Test
	  public void testMul() throws ArithmeticException {
		
		int x = 2, y = 10;
		String sign = "*";
		int actual = 0, expected = 20;
	    actual = ArithmeticOperations.calculate(x, y, sign);
	    assertEquals(expected, actual);
	  }
	
	@Test
	  public void testDiv() throws ArithmeticException {
		
		int x = 10, y = 2;
		String sign = "/";
		int actual = 0, expected = 5;
	    actual = ArithmeticOperations.calculate(x, y, sign);
	    assertEquals(expected, actual);
	  }
	
	@Test(expected = ArithmeticException.class)
	public void testZeroDivision() throws ArithmeticException {
		
		int x = 10, y = 0;
		String sign = "/";
		int actual = 0, expected = 5;
	    actual = ArithmeticOperations.calculate(x, y, sign);
	}

}
