package application;
import java.math.BigInteger;

public class EasyTest {
	
	public boolean Execute(BigInteger Num)
	{
		BigInteger temp;
        for (BigInteger i = new BigInteger("2"); i.compareTo(Num.divide(new BigInteger("2"))) <= 0; i = i.add(BigInteger.ONE))
        {
        	temp = Num.divide(i);
        	if (temp == BigInteger.ZERO)
        	{
        		return false;
        	}
        }
        return true;
	}
}
