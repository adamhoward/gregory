require 'polynomial'

def solve(seq)
  coefficients = calculate_coefficients(seq)
  p = Polynomial.new()
  for i in 0...coefficients.size
    p = p + (Polynomial.new(coefficients[i]) * factorial_power(i))
  end
  return p
end

def calculate_coefficients(seq)
  s = seq
  coefficients = []
  i = 0
  while contains_non_zeroes?(s)
    coefficients << (s[0] / factorial(i))
    s = forward_difference(s)
    i += 1
  end
  return coefficients
end

def factorial(n)
  if n < 2
    return 1
  else
    return n * factorial(n - 1)
  end
end

def forward_difference(seq)
  delta = []
  for i in 0...(seq.length - 1)
    delta << seq[i + 1] - seq[i]
  end
  return delta
end

def factorial_power(n)
  p = Polynomial.new(1)
  for i in 1..n
    p = p * Polynomial.new(1 - i, 1)
  end
  return p
end

def contains_non_zeroes?(seq)
  seq.any? {|num| num != 0}
end

