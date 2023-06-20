package 그리디;

import java.util.Scanner;

public class B2839_설탕배달_윤상우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int i = n/5;
//		int j = 0;
//		int res = 0;
		
		// 1번 풀이
//		while((n - 5*i) % 3 != 0) {
//			i--;
//			if(i < 0) break;
//		}
//		
//		if(i<0) {
//			res = -1;
//		}
//		else {
//			j = (n - 5*i) / 3;
//			res = i + j;
//		}
//		
//		sc.close();
//		System.out.println(res);
		
		// 2번 풀이
		while(i >= 0) {
			int j = (n - 5*i) / 3;
			int temp = 5*i + 3*j;
			if(temp == n) {
				int res = i+j;
				System.out.println(res);
				return;
			} else {
				i -= 1;
			}
		}
		
		sc.close();
		System.out.println(-1);
	}

}
