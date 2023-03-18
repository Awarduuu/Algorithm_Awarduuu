package Day4.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15650_N과M1_윤상우 {
	
	static int n;
	static int R;
	static int [] arr;
	static int [] selection;
	static boolean [] isSelected;
	
	public static void combination(int r, int start) {
		if(r==R) {
			for(int i=0; i<R; i++) {
				System.out.print(arr[selection[i]] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			selection[r] = i;
			combination(r+1, i);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int [n];
		selection = new int [R];
		isSelected = new boolean [n];
		
		for(int i=1; i<=n; i++) {
			arr[i-1] = i;
		}
		
		combination(0, 0);
			
		

	}

}
