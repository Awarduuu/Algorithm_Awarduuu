package Day2.B1158_요세푸스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스_윤상우 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> que = new ArrayDeque<>();
		Queue<Integer> ans = new ArrayDeque<>();
		
		// 1~n 순서의 큐 만들기
		for(int i=1; i<=n; i++) {
			que.offer(i);
		}
		
		while(!que.isEmpty()) {
			for(int i=0; i<k-1; i++) {
				que.offer(que.poll());
			}
			ans.offer(que.poll());
		}
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("<");
		for(int i=0; i<n-1; i++) {
			builder.append(ans.poll());
			builder.append(", ");
		}
		builder.append(ans.poll());
		builder.append(">");
		
		System.out.println(builder);
		
		
		
	}

}
