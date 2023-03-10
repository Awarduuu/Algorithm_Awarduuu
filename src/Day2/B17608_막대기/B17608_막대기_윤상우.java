package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17608_막대기_윤상우 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		// 정답
		int res = 1;
		
		// 막대기 높이 값을 넣은 스택 생성
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			stack.push(Integer.parseInt(st.nextToken()));
		}
		
		// pop하며 비교
		
		int now = stack.pop();
		
		while(!stack.isEmpty()) {
			int next = stack.pop();
			if(next > now) {
				res++;
			}
		}
		
		System.out.println(res);
	}

}
