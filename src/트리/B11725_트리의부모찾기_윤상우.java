package 트리;

import java.util.ArrayList;
import java.util.Scanner;

public class B11725_트리의부모찾기_윤상우 {

	
	static int N;
	static ArrayList<Integer> tree [];
	static boolean [] isVisited;
	static int [] parent;
	static int [] cnt;
	
	public static void search(int node) {
		
		for(int nextnode : tree[node]) {
			if(isVisited[nextnode]) continue;
			isVisited[nextnode] = true;
			search(nextnode);
			parent[nextnode] = node;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		tree = new ArrayList[N+1];
		isVisited = new boolean[N+1];
		parent = new int[N+1];
		cnt = new int[N+1];
		
		for(int i=0; i<N+1; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			tree[u].add(v);
			tree[v].add(u);
		}

		// 탐색
		isVisited[1] = true;
		search(1);


	}

}
