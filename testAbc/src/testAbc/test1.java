package testAbc;

public class test1 {
	public static void main(String[] args) {

		int x = 55; // int x ���� ���� �� �Ŀ� 55�� �����Ͽ����ϴ�.
		int y = 1999; //int y ���� ���� �� �Ŀ� 1999 ���� �����Ͽ����ϴ�.

		int result1, result2; 
		//int result1, result2  ���� ���� �Ѵ�.

		result1 = x - 10;
		//result1 �����밡 x-10 �� �����Ѵ�.
		result2 = 2008 - y;
		//result2 �����밡 2008 -y �� �����Ѵ�.

		System.out.println(x + " - 10 : " + result1); 
		// ��¹� : x + " - 10 : " + result 
		// x: x�� ������ 55�� ���´�.
		//" - 10 : " ���� ������ �ϱ�
		//result1�ȿ� ������ ��� ���� ���ɴϴ�.
		
		System.out.println("2008 - " + y + " : " + result2);
				// "2008 - " ���峪���� �Ѵ�
				// y: y�� ������ 1999�� ���´�.
				//" : " : " ���� ������ �ϱ�
				//result2�ȿ� ������ ��� ���� ���ɴϴ�.

	}

}
