package testAbc;

public class test3 {
	public static void main(String[] args) {

		int x = 50; //int x 선언 한후 에 50을 대입
		double y = 100.12; //double y 선언 한후 에 100.12을 대입

		System.out.printf("%d * %.0f = %.0f", x, y, x*y);
		//"%d * %.0f = %.0f"
		/*printf 를 출력문으로 사용 하였습니다. 
			%d 정수 값 %.0f 실수 값 표현
			 = %.0f  (%.0f -> 소수 0번째 짜리 까지 표현 하는것입니다.)
			그리고 , x ,y, x*y 로 %d %f 에 나오는값을 나타내준다.
		*/
	}

}
