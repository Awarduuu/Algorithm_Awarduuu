package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11724_연결요소의개수 {
	static int n;
	static int m;
	static int cnt;
	static ArrayList<Integer> [] arr;
	static boolean [] isVisited;
	
	static void dfs(int node) {
		isVisited[node] = true;
		
		for(int nextNode : arr[node]) {
			if(isVisited[nextNode]) continue;
			dfs(nextNode);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cnt = 0;
		arr = new ArrayList[n+1];
		
		for(int i=0; i<n+1; i++) arr[i] = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			arr[n1].add(n2);
			arr[n2].add(n1);
		}
			
		isVisited = new boolean [n+1];
		isVisited[0] = true;		
		

		for(int j=1; j<n+1; j++) {
			if(isVisited[j]) continue;
			dfs(j);
			cnt++;
		}
			
		
		System.out.println(cnt);
	}

}
