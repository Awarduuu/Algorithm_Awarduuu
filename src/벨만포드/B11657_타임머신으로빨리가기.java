package 벨만포드;

import java.io.*;
import java.util.*;

public class B11657_타임머신으로빨리가기 {
	
	// 벨만포드 알고리즘은 start, end, time 속성을 가진 노드를 1차원배열로 관리한다.
	static class Node {
		int s;
		int e;
		int t;
		
		Node(int s, int e, int t){
			this.s=s;
			this.e=e;
			this.t=t;
		}
	}
	
	static int N;
	static int M;
	static List<Node> NodeList;
	static long[] distArr;
	
	// 벨만포드 알고리즘
	static boolean bf(int s) {
		// 1. 시작노드 최단거리 초기화
		distArr[s]=0;
		
		// 2. 최대 업데이트 반복 횟수 = 노드개수 - 1
		for(int i=0; i<N; i++) {
			// 3. 간선들 모조리 방문
			for(int j=0; j<M; j++) {
				Node node=NodeList.get(j);
				// 4. 방문을 하고 + 최단거리일시 -> 끝노드 최단거리 갱신
				if(distArr[node.s]!=Integer.MAX_VALUE && distArr[node.e]>distArr[node.s]+node.t) {
					// 단, N번 방문했는데도 불구하고 최단거리 갱신이 일어나면 -> 음수 사이클 존재
					// 음수 사이클이 있으면 최단거리들은 무의미해진다.
					if(i==N-1) return false;
					distArr[node.e]=distArr[node.s]+node.t;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		NodeList=new ArrayList<>();
		distArr=new long[N+1];
		
		// 최단거리배열 -> 최대값들로 초기화
		for(int i=1; i<=N; i++) {
			distArr[i]=Integer.MAX_VALUE;
		}
		
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int t=Integer.parseInt(st.nextToken());
			NodeList.add(new Node(s,e,t));
		}
		
		// 최단거리가 유의미할 때와 무의미할 때를 나눠서 출력
		if(bf(1)) {
			for(int i=2; i<=N; i++) {
				// MAX_VALUE라는 점은 방문을 안했다는 것
				if(distArr[i]==Integer.MAX_VALUE) {
					System.out.println(-1);
				}else {
					System.out.println(distArr[i]);
				}
			}
		}else {
			System.out.println(-1);
		}
		
	}

}
