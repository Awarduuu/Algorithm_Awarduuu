package 플로이드워셜;

import java.io.*;
import java.util.*;

public class B11404_가장빠른버스노선 {
	static int N;
	static int M;
	// 플로이드 워셜은 MAX_VALUE로 최대값을 설정하면 오버플로우가 날 수 있으니, 임의의 최대값 만들기
	static int max=10000000;
	// 플로이드 워셜은 NxN 배열에 최단거리를 기록한다.
	static int [][] D;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		D=new int[N+1][N+1];
		
		// 자기 자신으로 가는길은 0으로, 나머지는 max로 초기화
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) {
					D[i][j]=0;
					continue;
				}
				D[i][j]=max;
			}
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			if(D[s][e] > v) D[s][e]=v;
		}
		
		// 항상 3중 포문 순서는 경유점, 시작점, 끝점으로!
		// 어디를 경유했나가 포인트기 때문이다.
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					D[i][j]=Math.min(D[i][j], D[i][k]+D[k][j]);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(D[i][j]==max) {
					System.out.print(0+" ");
					continue;
				}
				System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}
