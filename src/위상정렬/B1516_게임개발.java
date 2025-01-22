package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1516_게임개발 {
	
	static int [] d;
	static int [] t;
	static int [] result;
	static int N;
	static List<Integer> [] graph;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		d=new int[N+1];
		t=new int[N+1];
		result=new int[N+1];
		graph=new List [N+1];
		
		for(int i=1; i<N+1; i++) {
			graph[i]=new ArrayList<>();
		}
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<>();
			while(true) {
				int input=Integer.parseInt(st.nextToken());
				if (input==-1) break;
				list.add(input);
			}
			t[i]=list.remove(0);
			d[i]=list.size();
			for (int l:list) {
				graph[l].add(i);
			}
		}

		for(int i=1; i<N+1; i++) {
			if(d[i]==0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : graph[now]) {
				result[next]=Math.max(result[next], result[now]+t[now]);
				d[next]--;
				if(d[next]==0) queue.add(next);
			}
		}
		
		for(int i=1; i<N+1; i++) {
			System.out.println(result[i]+t[i]);
		}
		
		

	}

}
