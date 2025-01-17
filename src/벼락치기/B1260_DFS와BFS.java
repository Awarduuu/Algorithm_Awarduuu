package 벼락치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_DFS와BFS {
	static List<Integer> [] graph;
	static boolean [] visited;
	static List<Integer> dfsList;
	static List<Integer> bfsList;
	
	static void dfs(int start) {
		visited[start]=true;
		dfsList.add(start);
		
		for(int i : graph[start]) {
			if(visited[i]) continue;
			dfs(i);
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.add(start);
		visited[start]=true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			bfsList.add(now);
			for (int next : graph[now]) {
				if(visited[next]) continue;
				visited[next]=true;
				queue.add(next);
				
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int V=Integer.parseInt(st.nextToken());
		
		graph = new ArrayList [N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean [N+1];
		dfsList = new ArrayList<>();
		bfsList = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i=0; i<N+1; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(V);
		visited = new boolean [N+1];
		bfs(V);
		System.out.println(dfsList);
		System.out.println(bfsList);
		
	}

}
