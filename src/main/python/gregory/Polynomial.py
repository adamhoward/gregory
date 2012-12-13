class Polynomial(object):
    p = []
    def __init__(self, *coefficients):
        """Construct a polynomial given the coefficients in reverse order.
        To construct x^3 - 2x^2 + 5 you would call Polynomial(5, 0, -2, 1)

        """
        self.p = list(coefficients)

    def size(self):
        """Return the degree of the polynomial"""
        return len(self.p)

    def get(self, index):
        """Return the coefficient of power index"""
        return self.p[index]

    def times(self, rhs):
        """Return the product of multiplying self and another polynomial"""
        r = [0] * (self.size() + rhs.size())
        for i in xrange(0, self.size()):
            for j in xrange(0, rhs.size()):
                k = self.get(i) * rhs.get(j)
                r[i + j] += k
        return Polynomial(*r).removeTrailingZeroes()

    def plus(self, rhs):
        """Return the sum of adding self and another polynomial"""
        largest = max(self.size(), rhs.size())
        r = [0] * largest
        for i in xrange(0, largest):
            self_i = self.get(i) if self.size() > i else 0
            rhs_i = rhs.get(i) if rhs.size() > i else 0
            r[i] = self_i + rhs_i
        return Polynomial(*r).removeTrailingZeroes()

    def removeTrailingZeroes(self):
        """Cleanup polynomial by removing and extra zeroes"""
        for i in xrange(len(self.p) - 1, -1, -1):
            if self.p[i] != 0:
                break
            else:
                del self.p[i]
        return self

    def __str__(self):
        s = ""
        for power in xrange(len(self.p) - 1, -1, -1):
            coeff = self.p[power]
            if coeff != 0:
                if coeff > 0:
                    s += "+ "
                else:
                    s += "- "
                if power == 0:
                    s += str(abs(coeff))
                    s += " "
                elif power == 1:
                    if abs(coeff) != 1:
                        s += str(abs(coeff))
                    s += "x"
                    s += " "
                else:
                    if abs(coeff) != 1:
                        s += str(abs(coeff))
                    s += "x^"
                    s += str(power)
                    s += " "
        if s[0] == '+':
            s = s[2:]
        else:
            s = "-" + s[2:]
        return s

    def __eq__(self, other):
        return self.p == other.p

