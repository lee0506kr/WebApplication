package aa;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {

		
		int sum =0;
		for (int i = 1; i <= 100; i++) {
			sum += i;	
			if(i % 2==0) {
				System.out.println("¦�� :"+i);
			}
			if(i%3==0) {
				
				System.out.println("Ȧ�� :"+i);
			}
		}
		System.out.println(sum);
	}
}
