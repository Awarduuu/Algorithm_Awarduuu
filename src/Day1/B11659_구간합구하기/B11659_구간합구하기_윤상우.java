package Day1.B11659_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_구간합구하기_윤상우 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			StringTokenizer token1 = new StringTokenizer(bf.readLine(), " ");
			int n = Integer.parseInt(token1.nextToken());
			int m = Integer.parseInt(token1.nextToken());
			
			int [] sum = new int [n+1];
			int [] ans = new int [m];
			
			sum[0] = 0;
			
			StringTokenizer token2 = new StringTokenizer(bf.readLine(), " ");
//			sum[1] = Integer.parseInt(token2.nextToken());
			for(int k=0; k<n; k++) {
				int num = Integer.parseInt(token2.nextToken());
				sum[k+1] = sum[k] + num;
			}
			
			
			for(int k=0; k<m; k++) {
				StringTokenizer token3 = new StringTokenizer(bf.readLine(), " ");
				int i = Integer.parseInt(token3.nextToken());
				int j = Integer.parseInt(token3.nextToken());
				
				ans[k] = sum[j] - sum[i-1];
			}
			
			
			for(int k=0; k<m; k++) {
				System.out.println(ans[k]);
			}
	}

}
