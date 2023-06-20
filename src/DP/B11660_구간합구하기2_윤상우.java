package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11660_구간합구하기2_윤상우 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tkn = new StringTokenizer(bf.readLine(), " ");
		
		int n = Integer.parseInt(tkn.nextToken());
		int m = Integer.parseInt(tkn.nextToken());

		
		
		int [][] dp = new int [n+1][n+1];
		
		for(int i=1; i<n+1; i++) {
			tkn = new StringTokenizer(bf.readLine(), " ");
			for(int j=1; j<n+1; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + Integer.parseInt(tkn.nextToken());
			}
		}
		
		for(int i=0; i<m; i++) {
			tkn = new StringTokenizer(bf.readLine(), " ");
			int x1 = Integer.parseInt(tkn.nextToken());
			int y1 = Integer.parseInt(tkn.nextToken());
			int x2 = Integer.parseInt(tkn.nextToken());
			int y2 = Integer.parseInt(tkn.nextToken());
			
			System.out.println(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]);;
		}
		
	}

}
