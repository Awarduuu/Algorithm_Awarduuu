package Day8.B9663_NQueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B9663_NQueen_윤상우 {
	
	static int n;
	static int [] arr;
 	static boolean [] isSelected;
	static int cnt;
	
	static boolean checkValid(int x, int y) {
		for(int i=0; i<n; i++) {
			if(x == i || arr[i] == -1) continue;						// 자기자신이나 안 고른 경우는 pass
			if(Math.abs(x - i) == Math.abs(y - arr[i])) return false;	// 대각선 걸리는 경우
		}
		return true;
	}
	
	static void queen(int r) {
		if(r>=n) {
			cnt++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(isSelected[i]) continue;
			if(!checkValid(r, i)) continue;
			
			isSelected[i] = true;
			arr[r] = i;
			
			queen(r+1);
			
			isSelected[i] = false;
			arr[r] = -1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int [n];
		isSelected = new boolean [n];
		cnt = 0;
		
		for(int i=0; i<n; i++) arr[i] = -1;
		queen(0);
		
		
		System.out.println(cnt);
		
		
	}

}
