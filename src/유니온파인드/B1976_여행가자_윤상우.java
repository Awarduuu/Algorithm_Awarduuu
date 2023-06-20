package 유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1976_여행가자_윤상우 {

	static int n;
	static int m;
	static int [] parent;
	static int [] plan;
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]); 
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x!=y) {
			if(x<y) parent[y] = x;
			else parent[x] = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int [n+1];
		plan = new int [m+1];
		// 람다식으로 배열에 값 넣기
		Arrays.setAll(parent, (i) -> (i));
		
//		for(int i=1; i<n+1; i++) {
//			parent[i]=i;
//		}
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1; j<n+1; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					union(i, j);
				}
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		
		for(int i=1; i<m+1; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		
		int root = find(plan[1]);
		boolean flag = true;
		
		for(int i=1; i<m+1; i++) {
			if(root != find(plan[i])) {
				flag = false;
				break;
			}
		}
		
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}

}
