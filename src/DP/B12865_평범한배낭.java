package DP;

import java.io.*;
import java.util.*;

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
		// K=배낭의 무게 X N=물건의 개수 인 DP 배열 선언
		dp=new int[K+1][N+1];
		ans=1;
		
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			weight[i]=Integer.parseInt(st.nextToken());
			value[i]=Integer.parseInt(st.nextToken());
		}
		
		// 가방무게를 축으로 내려가며 최대가치 갱신
		for(int i=1; i<=N; i++) {
			for(int k=1; k<=K; k++) {
				// 현재 무게에 넣을 수 없을때
				// 못넣는다는 것 = 직전 결과 가져오기
				if (weight[i] > k) {
					dp[k][i]=dp[k][i-1];
					continue;
				}
				// 현재 무게에 넣을 수 있을때
				// 직전 무게와 현재무게 + 남은 가방 무게의 가치들을 비교하여 큰 가치로 갱신
				dp[k][i]=Math.max(dp[k][i-1],value[i]+dp[k-weight[i]][i-1]);
			}
		}
		
		System.out.println(dp[K][N]);
		
	}

}