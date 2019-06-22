package calc;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @see calc.Calculator
 */
public class CalculatorTest {

	private double run(String... args) {
		return Calculator.run(args).doubleValue();
	}

	@Test
	public void testTokenizer() {
		assertEquals(3.0, run("1", "+", "2"));
		assertEquals(3.0, run("1 +", "2"));
		assertEquals(3.0, run("1", "+ 2"));
		assertEquals(3.0, run("1+2"));
		assertEquals(3.0, run("1 + 2"));
		assertEquals(3.0, run("1+ 2"));
		assertEquals(3.0, run("1 +2"));
	}

	@Test
	public void testScope() {
		assertEquals(2.0, run("(3 - 2) * 2"));
		assertEquals(2.0, run("3 - 2 * 2"));
		assertEquals(-1.0, run("3 - (2 * 2)"));
	}

	@Test
	public void testCommaToPoint() {
		assertEquals(3.5, run("1,2 + 2,3"));
	}

	@Test
	public void testComputation() {
		assertEquals(3.0, run("1 + 2"));
		assertEquals(-1.0, run("1 - 2"));

		assertEquals(3.0, run("1 * 2"));
		assertEquals(0.5, run("1 / 2"));
		assertNull(run("1 / 0"));

		assertEquals(1.0, run("1 % 2"));
		assertEquals(1.0, run("3 % 2"));
		assertEquals(2.0, run("5 % 3"));
		assertEquals(0.0, run("1 \\ 2"));
		assertEquals(1.0, run("3 \\ 2"));
		assertEquals(2.0, run("5 \\ 2"));

		assertEquals(9.0, run("3 ^ 2"));
		assertEquals(3.0, run("9 ^ 0.5"));
		assertEquals(3.0, run("9 µ 2"));

		assertEquals(-1.0, run("1 ~ 2"));
		assertEquals(1.0, run("2 ~ 1"));
		assertEquals(0.0, run("1 ~ 1"));

	}
}
