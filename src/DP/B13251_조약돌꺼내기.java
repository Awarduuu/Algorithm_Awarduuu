package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13251_조약돌꺼내기 {
	static int M;
	static int N;
	static int K;
	static int [] color;
	static double answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		M=Integer.parseInt(st.nextToken());
		color=new int[M];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int n=Integer.parseInt(st.nextToken());
			color[i]=n;
			N+=n;
		}
		
		st=new StringTokenizer(br.readLine());
		K=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			double tmp = 1;
			int tmpN=color[i];
			int tmpAll=N;
			for(int k=0; k<K; k++) {
				tmp *= (double) (tmpN--) / (tmpAll--);
			}
			answer += tmp;
		}
		
		System.out.println(answer);
		
	}

}
