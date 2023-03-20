package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13023_ABCDE_윤상우 {
	
	static int n;
	static int m;
	static ArrayList<Integer> [] arr;
	static boolean [] isVisited;
	static int walk [];
	static int ans = 0;
	
	static void dfs(int node, int cnt) {
		if(isVisited[node]) return;
		
		if(cnt == 5 || ans == 1) {
			ans = 1;
			return;
		}
		isVisited[node] = true;
		
		for(int nextnode : arr[node]) {
			dfs(nextnode, cnt+1);
		}
		
		isVisited[node] = false;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		isVisited = new boolean [n];
		arr = new ArrayList[n];
		ans = 0;

		for(int i=0; i<n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			arr[n1].add(n2);
			arr[n2].add(n1);
		}
		
		
		for(int i=0; i<n; i++) {
			isVisited = new boolean [n];
			dfs(i,1);
		}
		
		System.out.println(ans);
		
		
	}
}
