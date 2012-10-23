/**
 * Copyright (c) 2010 Momentx Corporation
 */
package gregory;

import java.util.ArrayList;
import java.util.Collection;

/**
 * DOC: THIS CLASS HAS NO COMMENT!
 *
 * @author adam.howard
 */
public class Gregory {

	public Polynomial solve(Integer[] seq) {
		Integer[] c = calcCoefficients(seq);
		Polynomial p = new Polynomial();
		for (int i = 0; i < c.length; i++) {
			p = p.plus(new Polynomial(c[i]).times(fact_pow(i)));
		}
		p.removeTrailingZeroes();
		return p;
	}

	protected Integer[] calcCoefficients(Integer[] seq) {
		Integer[] s = seq.clone();
		Collection<Integer> c = new ArrayList<Integer>();
		for (int i = 0; containsNonZeroes(s); i++) {
			c.add(s[0]/fact(i));
			s = delta(s);
		}
		return c.toArray(new Integer[]{});
	}

	protected Integer fact(Integer n) {
		if (n < 2) return 1;
		int f = 1;
		for (int i = 2; i <= n; i++) {
			f *= i;
		}
		return f;
	}

	protected Integer[] delta(Integer ...seq) {
		Integer[] delta = new Integer[seq.length-1];
		for (int i = 0; i < seq.length-1; i++) {
			delta[i] = seq[i+1]-seq[i];
		}
		return delta;
	}

	protected Polynomial fact_pow(Integer n) {
		Polynomial f = new Polynomial(1);
		for (int i = 1; i <= n; i++) {
			f = f.times(new Polynomial(1-i, 1));
		}
		f.removeTrailingZeroes();
		return f;
	}

	protected boolean containsNonZeroes(Integer[] seq) {
		for (int i = 0; i < seq.length; i++) {
			if (seq[i] != 0) return true;
		}
		return false;
	}
}
