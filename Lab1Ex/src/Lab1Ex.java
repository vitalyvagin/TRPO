import java.util.Scanner;
import java.math.BigInteger;

public class Lab1Ex {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = -1;
		while (n != 0)
		{
			System.out.print("Выберите нужное действие: \n 1 - Тест простоты Ферма; \n 2 - Функция Эйлера; \n 3 - Алгоритм Полларда; \n 0 - Завершение работы.\n");
			n = in.nextInt();
			switch (n)
			{
				case 0:
				{
					break;
				}
				case 1:
				{
					System.out.println("*Тест простоты Ферма*");
					System.out.println("Введите число: ");
					BigInteger Num = in.nextBigInteger();
					TestFerm TF = new TestFerm();
					if (TF.Execute(Num, 20))			
						System.out.println("Данное число простое.");
					else
						System.out.println("Данное число составное.");
					System.out.println();
				} break;
				case 2:
				{
					System.out.println("*Функция Эйлера*");
					System.out.println("Введите число: ");
					BigInteger Num = in.nextBigInteger();
					FuncEler FE = new FuncEler();
					System.out.println("Количество чисел взаимно простых с введенным числом и меньших его: " + FE.Execute(Num));				
					System.out.println();
				} break;
				case 3:
				{
					System.out.println("*Алгоритм Полларда*");
					System.out.println("Введите число: ");
					BigInteger Num = in.nextBigInteger();
					PollardRho PR = new PollardRho(); 
					System.out.println("Множители введенного числа: " + PR.Execute(Num));
					System.out.println();
				} break;
				default:
				{
					System.out.println("Неверное число!");
					System.out.println();
				}
			}
		
		}
	}
}
