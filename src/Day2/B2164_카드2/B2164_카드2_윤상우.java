package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.management.Query;

public class B2164_카드2_윤상우 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		Queue<Integer> que = new ArrayDeque<>();
		
		for(int i=1; i<n+1; i++) {
			que.add(i);
		}
		
		while(que.size() > 1) {
			que.remove();
			que.add(que.remove());
		}
		
		int res = que.peek();
		
		System.out.println(res);
	}

}
