from Polynomial import Polynomial

def solve(seq):
    """Return the Polynomial that can be used to compute the given sequence"""
    coefficients = calculateCoefficients(seq)
    p = Polynomial()
    for i in xrange(0, len(coefficients)):
        p = p.plus(Polynomial(coefficients[i]).times(factorialPower(i)))
    p.removeTrailingZeroes()
    return p

def calculateCoefficients(seq):
    """Return the coefficients based on Gregory's Theorem"""
    s = list(seq)
    coefficients = []
    i = 0
    while containsNonZeroes(s):
        coefficients.append(s[0] / factorial(i))
        s = forwardDifference(s)
        i += 1
    return coefficients

# The remaining functions are generic mathematical operations
def factorial(n):
    if n < 2:
        return 1
    else:
        return n * factorial(n - 1)

def forwardDifference(seq):
    delta = [None] * (len(seq) - 1)
    for i in xrange(0, len(seq) - 1):
        delta[i] = seq[i+1] - seq[i]
    return delta

def factorialPower(n):
    p = Polynomial(1)
    for i in xrange(1, n+1):
        p = p.times(Polynomial(1 - i, 1))
    p.removeTrailingZeroes()
    return p

def containsNonZeroes(seq):
    for e in seq:
        if e != 0:
            return True
    return False

