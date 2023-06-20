package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_윤상우 {
	
	static int n;
	static int m;
	static int [] a;
	static int [] b;

	public static int search(int num, int [] arr) {
		int start = 0;
		int end = arr.length-1;

		while(start <= end) {
			int mid = (start + end)/2;
			if(arr[mid] == num) {
				return 1;
			}else if(arr[mid] > num) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		return 0;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		b = new int[m];
		for(int i=0; i<m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		
		for(int i=0; i<m; i++) {
			System.out.println(search(b[i], a));
		}
		
	}

}
