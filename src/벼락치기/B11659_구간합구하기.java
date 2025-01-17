package 벼락치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11659_구간합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		long[] dp = new long [n+1];
		st = new StringTokenizer(bf.readLine());
		for(int i=1; i<n+1; i++) {
			dp[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<n; i++) {
			dp[i+1]+=dp[i];
		}		
		
		for(int k=0; k<m; k++) {
			st = new StringTokenizer(bf.readLine());
			int i=Integer.parseInt(st.nextToken());
			int j=Integer.parseInt(st.nextToken());
			
			System.out.println(dp[j]-dp[i-1]);
		}
		
	}

}
