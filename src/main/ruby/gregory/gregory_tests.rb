require 'test/unit'

require 'gregory'
require 'polynomial'

class GregoryTest < Test::Unit::TestCase

  def setup
    @squares = [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]
    @mystery = [5, 4, 5, 14, 37, 80, 149, 250, 389, 572]
  end

  def test_squares
    assert_equal(Polynomial.new(0, 0, 1), solve(@squares))
  end

  def test_mystery
    assert_equal(Polynomial.new(5, 0, -2, 1), solve(@mystery))
  end

  def test_forward_difference
    assert_equal([1, 3, 5, 7, 9, 11, 13, 15, 17], forward_difference(@squares))
  end

  def test_factorial
    assert_equal(40320, factorial(8))
  end

  def test_factorial_power
    assert_equal(Polynomial.new(0, -6, 11, -6, 1), factorial_power(4))
  end

  def test_calculate_coefficients
    assert_equal([5, -1, 1, 1], calculate_coefficients(@mystery))
  end

end

