package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10806_개수세기_윤상우 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int [] arr = new int [n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		int v = Integer.parseInt(bf.readLine());
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			if(v == arr[i]) ans++;
		}
		
		System.out.println(ans);
	}

}
