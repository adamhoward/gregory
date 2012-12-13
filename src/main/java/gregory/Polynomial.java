package gregory;

import java.util.ArrayList;
import java.util.Arrays;

public class Polynomial {

	private ArrayList<Integer> p = new ArrayList<Integer>();

	public Polynomial(Integer... coefficients) {
		p.addAll(Arrays.asList(coefficients));
	}

	public Integer size() {
		return p.size();
	}

	public Integer get(int index) {
		return p.get(index);
	}

	public Polynomial times(Polynomial rhs) {
		Integer[] r = new Integer[this.size()+rhs.size()];
		Arrays.fill(r, 0);
		for (int i = 0; i < this.size(); i++) {
			for (int j = 0; j < rhs.size(); j++) {
				Integer k = this.get(i) * rhs.get(j);
				r[i+j] += k;
			}
		}
		return new Polynomial(r).removeTrailingZeroes();
	}

	public Polynomial plus(Polynomial rhs) {
		int MAX = Math.max(this.size(), rhs.size());
		Integer[] r = new Integer[MAX];
		Arrays.fill(r, 0);
		for (int i = 0; i < MAX; i++) {
			Integer this_i = this.size() > i ? this.get(i) : 0;
			Integer rhs_i = rhs.size() > i ? rhs.get(i) :0;
			r[i] = (this_i + rhs_i);
		}
		return new Polynomial(r).removeTrailingZeroes();
		
	}

	public Polynomial removeTrailingZeroes() {
		for (int i = p.size()-1; i >= 0; i--) {
			if (p.get(i) != 0) break;
			p.remove(i);
		}
		return this;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = p.size()-1; i >= 0; i--) {
			switch (i) {
				case 0:
					if (p.get(i) != 0) sb.append((p.get(i) >= 0 ? "+ ":"- ")).append(Math.abs(p.get(i))).append(" ");
					break;
				case 1:
					if (p.get(i) != 0) sb.append((p.get(i) >= 0 ? "+ ":"- ")).append(Math.abs(p.get(i)) != 1 ? Math.abs(p.get(i)):"").append("x").append(" ");
					break;
				default:
					if (p.get(i) != 0) sb.append((p.get(i) >= 0 ? "+ ":"- ")).append(Math.abs(p.get(i)) != 1 ? Math.abs(p.get(i)):"").append("x^").append(i).append(" ");
			}
		}
		return sb.charAt(0) == '+' ? sb.substring(2, sb.length()-1) : sb.replace(0, 2, "-").substring(0, sb.length()-1); //.substring(0, sb.length()-3);
	}

	@Override
	public boolean equals(Object rhs) {
		if (!(rhs instanceof Polynomial)) return false;
		
		if (this.size() != ((Polynomial)rhs).size()) return false;

		for (int i = 0; i < this.size(); i++) {
			if (this.get(i) != ((Polynomial)rhs).get(i)) return false;
		}
		return true;
	}
}
