package aa;

import java.util.Scanner;

public class Operator_ex2 {
	public static void main(String[] args) {
		// 사용자 에게 숫자 3개를 입력 받아서 중간 숫자 찾기(단, 세 숫자는 다르다),연산자 여러개써도됨

		Scanner str = new Scanner(System.in);

		int a, b, c;
		int x;

		System.out.println("숫자를 입력해주세요");
		a = str.nextInt();

		System.out.println("숫자를 입력해주세요");
		b = str.nextInt();

		System.out.println("숫자를 입력해주세요");
		c = str.nextInt();
		
		
		
		x = b > c && c > b || b > c && c > a ? 
				c: a > b && b > c || c > b && b > a ? 
						b: c > a && a > b || b > a && a > c ? a : b;

		System.out.println("두번째값은:" + x);

	}
}