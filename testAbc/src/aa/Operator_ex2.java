package aa;

import java.util.Scanner;

public class Operator_ex2 {
	public static void main(String[] args) {
		// ����� ���� ���� 3���� �Է� �޾Ƽ� �߰� ���� ã��(��, �� ���ڴ� �ٸ���),������ �������ᵵ��

		Scanner str = new Scanner(System.in);

		int a, b, c;
		int x;

		System.out.println("���ڸ� �Է����ּ���");
		a = str.nextInt();

		System.out.println("���ڸ� �Է����ּ���");
		b = str.nextInt();

		System.out.println("���ڸ� �Է����ּ���");
		c = str.nextInt();
		
		
		
		x = b > c && c > b || b > c && c > a ? 
				c: a > b && b > c || c > b && b > a ? 
						b: c > a && a > b || b > a && a > c ? a : b;

		System.out.println("�ι�°����:" + x);

	}
}