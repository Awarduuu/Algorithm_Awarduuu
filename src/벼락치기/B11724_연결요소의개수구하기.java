package 벼락치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B11724_연결요소의개수구하기 {
	static List<Integer>[] graph;
	static boolean [] visited;
	static int ans;
	
	static void dfs(int start) {
		visited[start]=true;
		
		for (int i : graph[start]) {
			if(visited[i]) continue;
			dfs(i);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		graph=new List[N+1];
		for(int i=1; i<N+1; i++) {
			graph[i]=new ArrayList<>();
		}
		visited = new boolean [N+1];
		ans=0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
			
		}
		
		for(int i=1; i<N+1; i++) {
			if(!visited[i]) {
				ans++;
				dfs(i);
			}
		}
		System.out.println(ans);

	}

}
