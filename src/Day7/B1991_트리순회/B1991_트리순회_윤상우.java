package Day7.B1991_트리순회;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B1991_트리순회_윤상우 {

	static int n;
	static int tree [][];
	static boolean isVisited [];
	static int parent [];
	
	static void preorder(int nowNode) {
		if(nowNode == -19) return;
		
		System.out.print((char)(nowNode + 65));
		preorder(tree[nowNode][0]);
		preorder(tree[nowNode][1]);
	}
	
	static void inorder(int nowNode) {
		if(nowNode == -19) return;
		
		preorder(tree[nowNode][0]);
		System.out.print((char)(nowNode + 65));
		preorder(tree[nowNode][1]);
	}
	static void postorder(int nowNode) {
		if(nowNode == -19) return;
		
		preorder(tree[nowNode][0]);
		preorder(tree[nowNode][1]);
		System.out.print((char)(nowNode + 65));
	}
	
	static void BFS(int root) {
		Queue <Integer> que = new ArrayDeque<>();
		que.add(root);
		
		while(!que.isEmpty()) {
			int nowNode = que.poll();
			if(nowNode == -19) continue;
			System.out.print((char)(nowNode + 65));
			for(int nextNode : tree[nowNode]) {
				que.add(nextNode);
			}
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		tree = new int [n][2];
		isVisited = new boolean[n];
		parent = new int [n];
		
		for(int i=0; i<n; i++) {
			int node = (int)(sc.next().charAt(0)-'A');
			int left = (int)(sc.next().charAt(0)-'A');
			int right = (int)(sc.next().charAt(0)-'A');
			tree[node][0] = left;
			tree[node][1] = right;
		}
		
		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
		System.out.println();
		BFS(0);
		
		
	}

}
