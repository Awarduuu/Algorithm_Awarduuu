package Day9.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_윤상우 {

	static int n;
	static int m;
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
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int [n+1];
		
		for(int i=0; i<n+1; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int cal = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(cal == 0) {
				union(a,b);
			}
			else if(cal == 1){
				if(find(a) != find(b)) System.out.println("NO");
				else System.out.println("YES");
			}
		}
	}

}
