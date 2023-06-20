package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
	int start;
	int end;
	int weight;
	
	Edge(int start, int end, int weight){
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "[" + this.start + ", " + this.end + ", " + this.weight + "]"; 
	}
}

public class B1197_최소스패닝트리_윤상우 {
	
	static int v;
	static int e;
	static int [] parent;
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a!=b) {
			if(a<b) parent[b] = a;
			else parent[a] = b;
		}
	}
	
	static int find(int num) {
		if(num == parent[num]) return num;
		return parent[num] = find(parent[num]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		int ans = 0;
		parent = new int [v+1];
		Arrays.setAll(parent, (i) -> (i));
		
		Edge [] edges = new Edge [e];
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(start, end, weight);
		}
		
		// 간선 정렬
		Arrays.sort(edges, (o1, o2) -> (o1.weight - o2.weight));
				
		for(int i=0; i<e; i++) {
			// 사이클 돌지 않는 조건
			if(find(edges[i].start) != find(edges[i].end)) {
				union(edges[i].start, edges[i].end);
				ans += edges[i].weight;
			}

			
		}
		
		System.out.println(ans);
		
		
//		System.out.println(Arrays.toString(parent));
		
	}

}


