package application;
import java.math.BigInteger;
import java.util.Random;

public class TestFerm {
	
	private BigInteger getRandomFermBase(BigInteger n)
	{
		Random rand = new Random();
		while (true)
        {
            final BigInteger a = new BigInteger (n.bitLength(), rand);
            if (BigInteger.ONE.compareTo(a) <= 0 && a.compareTo(n) < 0)
            {
                return a;
            }
        }
	}
	
	public boolean Execute(BigInteger Num, int maxIterations)
	{
		if (Num.equals(BigInteger.ONE))
            return false;

        for (int i = 0; i < maxIterations; i++)
        {
            BigInteger a = getRandomFermBase(Num);
            a = a.modPow(Num.subtract(BigInteger.ONE), Num);

            if (!a.equals(BigInteger.ONE))
                return false;
        }
        return true;
	}
}
