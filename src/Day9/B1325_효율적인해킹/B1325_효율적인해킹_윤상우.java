package Day9.B1325_효율적인해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1325_효율적인해킹_윤상우 {
	
	static int n;
	static int m;
	static ArrayList<Integer> [] arr;
	static boolean [] isVisited;
	static int [] ans;
	static int cnt1;
	
	
	static void dfs(int node) {
 		isVisited[node] = true;
		
		for(int nextnode : arr[node]) {
			if(isVisited[nextnode]) continue;
			ans[nextnode]++;
			dfs(nextnode);
		}
	}
	
	static void bfs(int node) {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(node);
		isVisited[node] = true;
		
		while(!que.isEmpty()) {
			int nextnode = que.poll();
			
			for(int i : arr[nextnode]) {
				if(isVisited[i]) continue;
				que.add(i);
				isVisited[i] = true;
				ans[i]++;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int max = 0;
		
		arr = new ArrayList[n+1];
		ans = new int [n+1];
		isVisited = new boolean [n+1];
		
		for(int i=0; i<n+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			arr[n1].add((n2));
		}
		
		
		for(int i=1; i<n+1; i++) {
			isVisited = new boolean [n+1];
			bfs(i);
		}
		
		for(int i=1; i<n+1; i++) {
			if(max < ans[i]) {
				max = ans[i];
			}
		}
				
		for(int i=1; i<n+1; i++) {
			if(ans[i] == max) System.out.print(i + " ");
		}
		
	}

}
