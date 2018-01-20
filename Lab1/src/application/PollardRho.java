package application;
import java.math.BigInteger;
import java.util.ArrayList;

public class PollardRho {

	private BigInteger gcd(BigInteger p, BigInteger q)
    {
        if (p.remainder(q) == BigInteger.ZERO)
            return q;
        return gcd(q, p.remainder(q));
    }
	
	public ArrayList <BigInteger> Execute (BigInteger a)
	{
		return Factorization2 (a);
	}
	
	private ArrayList <BigInteger> Factorization2(BigInteger a)
	{
		if ((new TestFerm()).Execute(a, 20))
		{
			ArrayList <BigInteger> FactList = new ArrayList <BigInteger> ();
			FactList.add(a);
			return FactList;
		}
		ArrayList <BigInteger> ans = new ArrayList <BigInteger>();
		BigInteger b = new BigInteger(a.toString());
		for (int i = 2; i < 100; i++) 
		{ 
			BigInteger temp = new BigInteger(String.valueOf(i)); 
			if (b.mod(temp).equals(BigInteger.ZERO)) 
			{ 
				ans.addAll(Factorization2(temp));
				b = b.divide(temp); 
				ans.addAll(Factorization2(b)); 
				return ans; 
			} 
		} 
		return Factorization(a); 
	} 

	private ArrayList <BigInteger> Factorization (BigInteger a)
	{
		ArrayList <BigInteger> ans = new ArrayList <BigInteger>();
		BigInteger temp = new BigInteger(a.toString());
		while (!(new TestFerm()).Execute(temp, 20))
		{
			BigInteger temp2 = Pollard(temp);
			if (temp.equals(temp2))
			{
				continue;
			}
			if (((new TestFerm()).Execute(temp, 20)))
			{
				ans.add(temp2);
			}
			else
			{
				ans.addAll(Factorization(temp2));
			}
			temp = temp.divide(temp2);
		}
		ans.add(temp);
		return ans;
	}

	private BigInteger Pollard(BigInteger n)
	{
		int i = 1;
		BigInteger x = (n.subtract((new BigInteger("2"))));
		BigInteger y = new BigInteger(x.toString());
		int k = 2;
		while (true)
		{
			i++;
			if (i > 10000)
			{
				return n;
			}
			x = ((((x.multiply(x)).subtract(BigInteger.ONE))).add(n)).mod(n);
			BigInteger temp = y.subtract(x);
			BigInteger d = gcd(temp, n);
			if (!d.equals(BigInteger.ONE) && !d.equals(n))
			{
				return d;
			}
			if (i == k)
			{
				y = x;
				k = 2 * k;
			}
		}
	}
}