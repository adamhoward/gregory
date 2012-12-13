package gregory;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class GregoryTest extends Gregory {

	private Integer[] squaresSeq = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
	private Integer[] mysterySeq = {5, 4, 5, 14, 37, 80, 149, 250, 389, 572};

	@Test
	public void squares() {
		Gregory g = new Gregory();
		Polynomial p = g.solve(squaresSeq);
		assertEquals(new Polynomial(0,0,1), p);
		System.out.println("Squares: " + Arrays.toString(squaresSeq) + " -> " + p);
		System.out.println();
	}

	@Test
	public void mystery() {
		Gregory g = new Gregory();
		Polynomial p = g.solve(mysterySeq);
		assertEquals(new Polynomial(5, 0, -2, 1), p);
		System.out.println("Mystery: " + Arrays.toString(mysterySeq) + " -> " + p);
		System.out.println();
	}

	@Test
	public void testDelta() {
		Gregory g = new Gregory();
		Integer[] a = g.delta(squaresSeq);
		assertEquals(new Integer[] {1,3,5,7,9,11,13,15,17}, a);
	}

	@Test
	public void testFact() {
		Gregory g = new Gregory();
		Integer f = g.factorial(8);
		assertEquals((Integer)40320, f);
	}

	@Test
	public void testFactPow() {
		Gregory g = new Gregory();
		Polynomial p = g.factorialPower(4);
		assertEquals(new Polynomial(0, -6, 11, -6, 1), p);
		System.out.println("factorialPower(4) -> " + p);
		System.out.println();
	}

	@Test
	public void testCoefficients() {
		Gregory g = new Gregory();
		Integer[] c = g.calcCoefficients(mysterySeq);
		assertEquals(new Integer[] {5, -1, 1, 1}, c);
		for (int i = 0; i < c.length; i++) {
			System.out.println(i + ": " + c[i]);
		}
		System.out.println();
	}
}
