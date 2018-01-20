package application;
import java.math.BigInteger;

public class FuncEler {
	
	public BigInteger Execute (BigInteger Num)
	{
		BigInteger result = Num;
		BigInteger fn = new BigInteger("2");
		for (BigInteger i = fn; (i.multiply(i)).compareTo(Num) <= 0; i = i.add(BigInteger.ONE))
			if (Num.remainder(i) == BigInteger.ZERO) {
				while (Num.remainder(i).equals(BigInteger.ZERO))
					Num = Num.divide(i);
				result = result.subtract(result.divide(i));
			}
		if (Num.compareTo(BigInteger.ONE) > 0)
			result = result.subtract(result.divide(Num));
		return result;
	}
}