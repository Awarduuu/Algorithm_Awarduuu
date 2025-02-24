package 트리;

import java.io.*;
import java.util.*;

public class B11437_LCA {
	static int N;
	static int M;
	static int [] parent;
	static int [] depth;
	static List<Integer> [] tree;
	static boolean [] visited;
	
	static void bfs(int root) {
		Queue<Node> que=new ArrayDeque<>();
		que.add(new Node(root, 0, 0));
		visited[root]=true;
		
		while(!que.isEmpty()) {
			Node nowNode=que.poll();
			for(int next : tree[nowNode.node]) {
				if(visited[next]) continue;
				int nextParent=nowNode.node;
				parent[next]=nextParent;
				int nextDepth=nowNode.depth+1;
				depth[next]=nextDepth;
				visited[next]=true;
				que.add(new Node(next, nextParent, nextDepth));
			}
		}
	}
	
	static int LCA(int n1, int n2) {
		if(depth[n1] < depth[n2]) {
			int temp=n1;
			n1=n2;
			n2=temp;
		}
		while(depth[n1]!=depth[n2]) {
			n1=parent[n1];
		}
		while(n1 != n2) {
			n1=parent[n1];
			n2=parent[n2];
		}
		return n1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		parent=new int[N+1];
		depth=new int[N+1];
		tree=new ArrayList[N+1];
		visited=new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			tree[i]=new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st=new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			tree[n1].add(n2);
			tree[n2].add(n1);
		}
		
		bfs(1);
		
		st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			System.out.println(LCA(n1, n2));
		}
	}

}
class Node{
	int node;
	int parent;
	int depth;
	
	Node(int node, int parent, int depth){
		this.node=node;
		this.parent=parent;
		this.depth=depth;
	}
}
