package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 자작_슝슝 {
	static int N;
	static int K;
	static int X;
	static int[] B;
	static int[][] graph;
	static int[] selection;
	static boolean[] isSelected;
	static int[] dx={1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static boolean [][] temp_isVisited;
	static Set[] arrowSets;
	static int answer;
	static Set[][] dp;
	
//	static void combination(int start, int r, int R) {
//		if(r == R) {
//	        shooting(selection);
//	        return;
//	    }
//
//	    for(int i=start; i<B.length; i++) {
//	        if(isSelected[i]) continue;        // 중복인 경우 skip
//	        isSelected[i] = true;            // 중복 마킹
//	        selection[r] = i;                // 선택
//	        combination(i, r+1, R);                // 다음 재귀로
//	        isSelected[i] = false;            // 선택한걸 되돌려줘야 함
//	    }
//	}
	
//	static void shooting (int [] selection) {
//		int temp=0;
//		int [][] temp_graph = new int[N][N];
//		
//		for(int s : selection) {
//			int b=B[s];
//			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					temp_graph[i][j]+=bfs(new int [] {i,j,1},s);
//				}
//			}
//
//			temp+=b;
//			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					if(temp_graph[i][j]==X) {
//						if (answer==-1) {
//							answer=temp;
//							continue;
//						}
//						answer=Math.min(answer, temp);
//					}
//				}
//			}
//		}
//	}
//	
	static int bfs(int [] start, int arrow) {
		int temp=0;
		Queue<int[]> queue=new ArrayDeque<>();
		queue.add(start);
		temp_isVisited=new boolean[N][N];
		temp_isVisited[start[0]][start[1]]=true;
		
		while(!queue.isEmpty()) {
			int [] now=queue.poll();
			temp+=graph[now[0]][now[1]];

			for(int i=0; i<4; i++) {
				int next_x=now[0]+dx[i];
				int next_y=now[1]+dy[i];
				int next_d=now[2]+1;
				
				if(next_x<0 || next_x>=N || next_y<0 || next_y>=N) continue;
				if(temp_isVisited[next_x][next_y]) continue;
				if(next_d > arrow) continue;
				
				queue.add(new int[] {next_x, next_y, next_d});
				temp_isVisited[next_x][next_y]=true;
			}
		}
		
		return temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		B=new int[K+1];
		graph=new int[N][N];
		arrowSets=new Set[K+1];
		int total=0;
			
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=1; i<=K; i++) {
			B[i]=Integer.parseInt(st.nextToken());
			total+=B[i];
		}
		
		dp=new Set[K+1][total+1];
		for(int k=0; k<=K; k++) {
			for(int i=0; i<=total; i++) {
				dp[k][i]=new HashSet<>();
			}
		}

		for(int k=1; k<=K; k++) {
			Set<Integer> value = new HashSet<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					value.add(bfs(new int [] {i,j,1},k));
				}
			}
			arrowSets[k]=value;
		}
		
		for(int k=1; k<=K; k++) {
			for(int i=0; i<=total; i++) {
				int weight=B[k];
				Set<Integer> value=arrowSets[k];
				
				if (i<weight) {
					// 못쏴
					dp[k][i]=dp[k-1][i];
				}else {
					// 쏴
					Set<Integer> prev=dp[k-1][i-weight];
					boolean flag=false;
					Set<Integer> next=new HashSet<>();
					
					if(prev.isEmpty()) {
						dp[k][i]=value; 
						continue;
					}
					for(int p : prev) {
						for(int v : value) {
							next.add(p+v);
							if (p+v==X) flag=true;
						}
					}
					if (flag) {
						answer=i;
						return;
					}
					dp[k][i]=next;
				}
			}
		}
		
		for(int k=1; k<=K; k++) {
			for(int i=0; i<=total; i++) {
				System.out.print(dp[k][i].toString()+" ");
			}
			System.out.println();
		}
//		for(int k=1; k<=K; k++) {
//			isSelected=new boolean[K+1];
//			selection=new int[k];
//			combination(1,0,k);
//		}
		
		System.out.println(answer);
		
	}

}
