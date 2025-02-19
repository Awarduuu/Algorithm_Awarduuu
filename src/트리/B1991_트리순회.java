package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991_트리순회 {
	
	static int N;
	static int [][] binaryTree;
	
	// 루->전->후
	static void preOrder(int now) {
		if(now==-1) return;
		System.out.print((char)(now+'A'));
		preOrder(binaryTree[now][0]);
		preOrder(binaryTree[now][1]);
	}
	
	// 전->루->후
	static void inOrder(int now) {
		if(now==-1) return;
		inOrder(binaryTree[now][0]);
		System.out.print((char)(now+'A'));
		inOrder(binaryTree[now][1]);
	}
	
	// 전->후->루
	static void postOrder(int now) {
		if(now==-1) return;
		postOrder(binaryTree[now][0]);
		postOrder(binaryTree[now][1]);
		System.out.print((char)(now+'A'));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		binaryTree=new int[26][2];
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			int root=st.nextToken().charAt(0)-'A';
			char left=st.nextToken().charAt(0);
			char right=st.nextToken().charAt(0);
			
			if (left=='.') {
				binaryTree[root][0]=-1;
			}else {
				binaryTree[root][0]=left-'A';
			}
			
			if (right=='.') {
				binaryTree[root][1]=-1;
			}else {
				binaryTree[root][1]=right-'A';
			}
			
		}
		
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
		System.out.println();
		
	}
}