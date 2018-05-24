package testAbc;

public class test1 {
	public static void main(String[] args) {

		int x = 55; // int x 변수 선언 한 후에 55를 대입하였습니다.
		int y = 1999; //int y 변수 선언 한 후에 1999 값을 대입하였습니다.

		int result1, result2; 
		//int result1, result2  변수 선언 한다.

		result1 = x - 10;
		//result1 값에대가 x-10 을 대입한다.
		result2 = 2008 - y;
		//result2 값에대가 2008 -y 을 대입한다.

		System.out.println(x + " - 10 : " + result1); 
		// 출력문 : x + " - 10 : " + result 
		// x: x에 선언한 55가 나온다.
		//" - 10 : " 문장 나오게 하기
		//result1안에 대입한 결과 값이 나옵니다.
		
		System.out.println("2008 - " + y + " : " + result2);
				// "2008 - " 문장나오게 한다
				// y: y에 선언한 1999가 나온다.
				//" : " : " 문장 나오게 하기
				//result2안에 대입한 결과 값이 나옵니다.

	}

}
