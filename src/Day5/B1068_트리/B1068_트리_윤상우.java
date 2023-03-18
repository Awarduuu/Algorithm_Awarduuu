package Day5.B1068_트리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B1068_트리_윤상우 {
	
	static int N;
	static int num;
	static int del;
	static int root;
	static int cnt;
	static int [] parent;
	static ArrayList<Integer> parentList;
	static ArrayList<Integer> tree [] ;
	static boolean isVisited [];

	
	public static void search(int node, int delete) {
		if(node == delete) {
			isVisited[node] = false;
			return;
		}
		
		for(int nextnode : tree[node]) {
			if(isVisited[nextnode]) continue;
			isVisited[nextnode] = true;
			search(nextnode, delete);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		tree = new ArrayList[N];
		isVisited = new boolean[N];
		parent = new int[N];
		parentList = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N; i++) {
			num = sc.nextInt();
			parent[i] = num;
			if(num != -1) {
				tree[num].add(i);
				tree[i].add(num);
			} else root = i;
		}
		
		del = sc.nextInt();
		
		isVisited[root] = true;
		search(root, del);
		
		for(int i=0; i<N; i++) {
			parentList.add(parent[i]);
		}
		
		for(int i=0; i<N; i++) {
			if(isVisited[i] == true && !parentList.contains(i)) cnt++;
		}
		
		System.out.println(cnt);
		
	}

}
