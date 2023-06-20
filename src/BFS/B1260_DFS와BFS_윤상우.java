package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_DFS와BFS_윤상우 {
	
	static int n;
	static int v;
	static int start;
	static ArrayList<Integer> arr [];
	static boolean isVisited [];
	
	static void dfs(int node) {
		
		isVisited[node] = true;
		System.out.print(node + " ");
		
		for(int nextNode : arr[node]) {
			if(isVisited[nextNode]) continue;
			dfs(nextNode);
		}
	}
	
	static void bfs(int node) {
		
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(node);
		isVisited[node] = true;
		
		while(!que.isEmpty()) {
			int nowNode = que.poll();
			System.out.print(nowNode + " ");
			
			for(int nextNode : arr[nowNode]) {
				if(isVisited[nextNode]) continue;
				que.offer(nextNode);
				isVisited[nextNode] = true;
			}
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		
		for(int i=0; i<n+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<v; i++) {
			st = new StringTokenizer(bf.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			arr[n1].add(n2);
			arr[n2].add(n1);
		}
	
		for(int i=0; i<n+1; i++) {
			Collections.sort(arr[i]);
		}
		
		isVisited = new boolean [n+1];
		dfs(start);
		
		System.out.println();
		isVisited = new boolean [n+1];
		bfs(start);
	}

}
