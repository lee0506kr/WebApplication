package testAbc;

public class test3 {
	public static void main(String[] args) {

		int x = 50; //int x ���� ���� �� 50�� ����
		double y = 100.12; //double y ���� ���� �� 100.12�� ����

		System.out.printf("%d * %.0f = %.0f", x, y, x*y);
		//"%d * %.0f = %.0f"
		/*printf �� ��¹����� ��� �Ͽ����ϴ�. 
			%d ���� �� %.0f �Ǽ� �� ǥ��
			 = %.0f  (%.0f -> �Ҽ� 0��° ¥�� ���� ǥ�� �ϴ°��Դϴ�.)
			�׸��� , x ,y, x*y �� %d %f �� �����°��� ��Ÿ���ش�.
		*/
	}

}
