package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12865_평범한배낭 {
	
	static int N;
	static int K;
	static int [] weight;
	static int [] value;
	static int [][] dp;
	static int ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		weight=new int[N+1];
		value=new int[N+1];
		dp=new int[K+1][N+1];
		ans=1;
		
		
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			weight[i]=Integer.parseInt(st.nextToken());
			value[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			for(int k=1; k<=K; k++) {
				if (weight[i] > k) {
					dp[k][i]=dp[k][i-1];
					continue;
				}
				dp[k][i]=Math.max(dp[k][i-1],value[i]+dp[k-weight[i]][i-1]);
			}
		}
		
		System.out.println(dp[K][N]);
		
		for(int i=1; i<=K; i++) {
			System.out.println(Arrays.toString(dp[i]));
			
		}
		
	}

}
