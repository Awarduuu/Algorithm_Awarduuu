package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_윤상우 {
	
	static int n;
	static int k;
	static int cnt;
	static final int max = 100_000;
	static boolean [] isVisited;
	static int [] moves = {1,-1,2};
	static int [] arr ;

	static void bfs(int node) {
	
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(node);
		arr[node]=0;
		if(node==k) return;
		isVisited[node] = true;
		
		
		while(!que.isEmpty()) {
			int now = que.poll();
			if(isVisited[k]) break;
			
			for(int i=0; i<3; i++) {
				int next;
				if(i == 2) next = now*moves[i];
				else next = now + moves[i];
				
				if(next >= 0 && next <= max && !isVisited[next]) {
					que.offer(next);
					isVisited[next] = true;
					arr[next] = arr[now] +1 ;
				}
			}
		
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		isVisited = new boolean[max+1];
		arr = new int[max+1];
		
		bfs(n);
		System.out.println(arr[k]);
		
	}

}
