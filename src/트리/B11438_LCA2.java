package 트리;

import java.io.*;
import java.util.*;

import 트리.Node;


public class B11438_LCA2 {
	static int N;
	static int M;
	static List<Integer> [] tree;
	static int [] depth;
	static int [][] parent;
	static int maxK;
	static boolean[] visited;
	
	// LCA에 필요한 depth, parent[0] 만들어주기 위한 bfs
	static void bfs(int root) {
		Queue<Node> queue=new ArrayDeque<>();
		queue.add(new Node(root,0,0));
		visited[root]=true;
		
		while(!queue.isEmpty()) {
			Node nowNode=queue.poll();
			for(int next : tree[nowNode.node]) {
				if(visited[next]) continue;
				int nextDepth=nowNode.depth+1;
				int nextParent=nowNode.node;
				depth[next]=nextDepth;
				parent[0][next]=nextParent;
				visited[next]=true;
				queue.add(new Node(next, nextParent, nextDepth));
			}
		}
	}
	
	// 최소 공통 조상 탐색
	static int LCA(int n1, int n2) {
		
		// 깊이가 큰 쪽을 n1으로 두기위해 swap
		if(depth[n1] < depth[n2]) {
			int temp=n1;
			n1=n2;
			n2=temp;
		}
		
		// n1과 n2의 깊이를 맞춰주는 작업
		for(int k=maxK-1; k>=0; k--) {
			if(Math.pow(2, k) <= depth[n1]-depth[n2]) {
				n1=parent[k][n1];
			}
		}
		
		// 같은 깊이인데 서로 같은 노드다 = 그 노드가 바로 최소 공통 조상
		if(n1==n2) return n1;
		
		// 같은 깊이인데 서로 다른 노드다 => 2^k씩 올라가며 부모노드가 다른지 확인
		for(int k=maxK-1; k>=0; k--) {
			// 부모 노드가 다르면 갱신
			if(parent[k][n1]!=parent[k][n2]) {
				n1=parent[k][n1];
				n2=parent[k][n2];
			}
		}
		
		// 바로 위 노드 = 최소 공통 조상
		return parent[0][n1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		tree=new ArrayList[N+1];
		depth=new int[N+1];
		visited=new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			tree[i]=new ArrayList<Integer>();
		}
		
		// 최대 차수 K 설정
		int temp=1;
		while(N > temp) {
			temp*=2;
			maxK++;
		}
		parent=new int[maxK][N+1];
		
		for(int i=0; i<N-1; i++) {
			st=new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			tree[n1].add(n2);
			tree[n2].add(n1);
		}
		
		// depth와 parent[0] (바로 윗 부모) 탐색
		bfs(1);
		
		// 점화식으로 2^k번째 부모 탐색
		// 2^k-1번째 부모 노드의 2^k-1번째 부모 = 2^k번째 부모
		for(int k=1; k<maxK; k++) {
			for(int n=1; n<=N; n++) {
				parent[k][n]=parent[k-1][parent[k-1][n]];
			}
		}
		
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


