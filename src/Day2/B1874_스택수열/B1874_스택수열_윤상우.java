package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1874_스택수열_윤상우 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		StringBuilder builder = new StringBuilder();
		
		int arr [] = new int [n];
		int idx = 1;

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			int now = arr[i];
			if(stack.isEmpty() || now > stack.peek()) {
				for(int j = idx; j<=now; j++) {
					stack.push(idx);
					idx++;
					builder.append("+\n");
				}
				stack.pop();
				builder.append("-\n");
			}else if(now == stack.peek()) {
				stack.pop();
				builder.append("-\n");
			}else {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println(builder.toString());
		
		
	}

}
