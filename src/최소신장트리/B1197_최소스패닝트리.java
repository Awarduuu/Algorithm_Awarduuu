package 최소신장트리;

import java.io.*;
import java.util.*;

public class B1197_최소스패닝트리 {
	
	static int N;
	static int E;
	// 가중치 오름차순으로 자동 정렬하기 위해 우선순위 큐 사용
	static PriorityQueue<Edge> que;
	// 유니온 파인드에 사용할 parent 배열
	static int[] parent;
	static int ans;
	static int useEdge;
	
	// 유니온 파인드 함수
	static int find(int n) {
		if(n==parent[n]) return n;
		return parent[n]=find(parent[n]);
	}
	
	static void union(int n1, int n2) {
		n1=find(n1);
		n2=find(n2);
		
		if(n1 > n2) {
			parent[n1]=n2;
		}else {
			parent[n2]=n1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		parent=new int[N+1];
		Arrays.setAll(parent, i -> i);
		que=new PriorityQueue<>();
		ans=0;
		useEdge=0;
		
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			que.add(new Edge(s,e,v));
		}
		
		// 연결 엣지의 최대 = 노드 개수 - 1
		while(useEdge!=N-1) {
			Edge edge = que.poll();
			
			// 부모가 같다 = 사이클이 만들어진다.
			if(find(edge.s)==find(edge.e)) continue;
			
			// 사이클이 없으면 연결
			union(edge.s, edge.e);
			ans+=edge.v;
			useEdge++;
		}
		
		System.out.println(ans);
	}

}

//가중치로 오름차순 정렬하기 위해 Comparable 인터페이스 참조
class Edge implements Comparable<Edge>{
	int s;
	int e;
	int v;
	
	Edge(int s, int e, int v){
		this.s=s;
		this.e=e;
		this.v=v;
	}
	
	// Comparable 인터페이스 참조했으니 compareTo() 오버라이딩
	@Override
	public int compareTo(Edge e) {
		return this.v - e.v;
	}
}
