package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1182_부분수열의합_윤상우 {
	
	static int N;
	static int s;
	static int [] arr;
	static boolean [] isSelected;
	static int cnt;
	static int sum;
	
	public static void subset(int num) {
		if(num == N) {
			sum = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					sum += arr[i];
				}
			}
			if(sum == s) cnt++;
			return;
		}
		
		isSelected[num] = true;
		subset(num+1);
		
		isSelected[num] = false;
		subset(num+1);
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int [N];
		isSelected = new boolean [N];
		cnt = 0;

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		subset(0);
		
		int res = s == 0 ? cnt-1 : cnt;
		System.out.println(res);

	}

}
