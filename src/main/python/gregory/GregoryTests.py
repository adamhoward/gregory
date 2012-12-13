import Gregory
from Polynomial import Polynomial

def test(func, expected, *input):
    actual = func(*input)
    if actual == expected:
        print "Yay! %s(%s) -> %s" % (func.__name__, input, actual)
    else:
        print "Boo! Expected: %s Actual: %s" % (expected, actual)

squares = [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]
mystery = [5, 4, 5, 14, 37, 80, 149, 250, 389, 572]

test(Gregory.solve, Polynomial(0, 0, 1), squares)
test(Gregory.solve, Polynomial(5, 0, -2, 1), mystery)
test(Gregory.forwardDifference, [1, 3, 5, 7, 9, 11, 13, 15, 17], squares)
test(Gregory.factorial, 40320, 8)
test(Gregory.factorialPower, Polynomial(0, -6, 11, -6, 1), 4)
test(Gregory.calculateCoefficients, [5, -1, 1, 1], mystery)

