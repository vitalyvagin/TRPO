import java.util.Scanner;
import java.math.BigInteger;

public class Lab1Ex {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = -1;
		while (n != 0)
		{
			System.out.print("�������� ������ ��������: \n 1 - ���� �������� �����; \n 2 - ������� ������; \n 3 - �������� ��������; \n 0 - ���������� ������.\n");
			n = in.nextInt();
			switch (n)
			{
				case 0:
				{
					break;
				}
				case 1:
				{
					System.out.println("*���� �������� �����*");
					System.out.println("������� �����: ");
					BigInteger Num = in.nextBigInteger();
					TestFerm TF = new TestFerm();
					if (TF.Execute(Num, 20))			
						System.out.println("������ ����� �������.");
					else
						System.out.println("������ ����� ���������.");
					System.out.println();
				} break;
				case 2:
				{
					System.out.println("*������� ������*");
					System.out.println("������� �����: ");
					BigInteger Num = in.nextBigInteger();
					FuncEler FE = new FuncEler();
					System.out.println("���������� ����� ������� ������� � ��������� ������ � ������� ���: " + FE.Execute(Num));				
					System.out.println();
				} break;
				case 3:
				{
					System.out.println("*�������� ��������*");
					System.out.println("������� �����: ");
					BigInteger Num = in.nextBigInteger();
					PollardRho PR = new PollardRho(); 
					System.out.println("��������� ���������� �����: " + PR.Execute(Num));
					System.out.println();
				} break;
				default:
				{
					System.out.println("�������� �����!");
					System.out.println();
				}
			}
		
		}
	}
}
