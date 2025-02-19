package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B11725_트리의부모찾기_윤상우 {
	
	static int N;
	static List<Integer>[] graph;
	static int[] parent;
	static boolean[] visited;
	
	static void search(int start) {
		visited[start]=true;
		
		for(int next : graph[start]) {
			if(visited[next])continue;
			visited[next]=true;
			parent[next]=start;
			search(next);
			visited[next]=false;
		}
	}
	
	public static void main(String[] args) throws IOException {
				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		graph=new ArrayList [N+1];
		parent=new int [N+1];
		visited=new boolean [N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i]=new ArrayList<Integer>();
			parent[i]=i;
		}
		
		for(int i=1; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		
		search(1);
		
		for(int i=2; i<=N; i++) {
			System.out.println(parent[i]);
		}

	}

}
