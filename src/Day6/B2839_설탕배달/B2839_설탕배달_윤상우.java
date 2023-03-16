package Day6.B2839_설탕배달;

import java.util.Scanner;

public class B2839_설탕배달_윤상우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int i = n/5;
		int j = 0;
		int res = 0;
		
		while((n - 5*i) % 3 != 0) {
			i--;
			if(i < 0) break;
		}
		
		j = (n - 5*i) / 3;
		
		if(i<0) {
			res = -1;
		}else {
			res = i + j;
		}
		
		
		System.out.println(res);
		
	}

}
