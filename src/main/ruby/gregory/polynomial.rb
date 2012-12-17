class Polynomial

  def initialize(*coefficients)
    @coefficients = coefficients
  end

  def *(other)
    r = Array.new(self.size + other.size, 0)
    for i in 0...self.size
      for j in 0...other.size
        k = self.get(i) * other.get(j)
        r[i + j] += k
      end
    end
    return Polynomial.new(*r).remove_trailing_zeroes
  end

  def +(other)
    largest = [self.size, other.size].max
    r = Array.new(largest, 0)
    for i in 0...largest
      self_i = self.size > i ? self.get(i) : 0
      other_i = other.size > i ? other.get(i) : 0
      r[i] = self_i + other_i
    end
    return Polynomial.new(*r).remove_trailing_zeroes
  end

  def ==(other)
    return @coefficients == other.coefficients
  end

  def to_s
    s = ""
    power = @coefficients.size - 1
    while power >= 0 do
      coeff = self.get(power)
      if coeff != 0
        if coeff > 0
          s += "+ "
        else
          s += "- "
        end

        if power == 0
          s += coeff.abs.to_s
          s += " "
        elsif power == 1
          if (coeff.abs != 1) then s += coeff.abs.to_s end
          s += "x"
          s += " "
        else
          if (coeff.abs != 1) then s += coeff.abs.to_s end
          s += "x**"
          s += power.to_s
          s += " "
        end
      end
      power -= 1
    end

    if s[0,1] == "+"
      s = s[2..-1]
    else
      s = "-" + s[2..-1]
    end

    return s
  end

  protected

  def size
    return @coefficients.size
  end

  def get(index)
    return @coefficients[index]
  end

  def coefficients
    return @coefficients
  end

  def remove_trailing_zeroes
    index = @coefficients.size - 1
    while index >= 0 && @coefficients[index] == 0 do
      @coefficients.delete_at index
      index -= 1
    end
    return self
  end

end

