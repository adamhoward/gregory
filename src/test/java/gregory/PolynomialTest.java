package gregory;

import org.junit.Test;
import org.junit.Assert;


public class PolynomialTest {

	@Test
	public void testToString() {
		Polynomial p = new Polynomial(-1, 2, -3);
		Assert.assertEquals("-3x^2 + 2x - 1", p.toString());
	}

	@Test
	public void testMultiplication() {
		Polynomial p = new Polynomial(1, 1);
		Polynomial q = new Polynomial(-1, 1);
		Assert.assertEquals("x^2 - 1", p.times(q).toString());
		Assert.assertEquals(new Polynomial(-1, 0, 1), p.times(q));
	}

	@Test
	public void testEquality() {
		Assert.assertEquals(new Polynomial(-1, 0, 1), new Polynomial(-1, 0, 1));
	}
}
