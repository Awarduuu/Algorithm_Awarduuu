package 벼락치기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B11003_최솟값찾기 {
	
	// index와 값을 같이 관리하기 위해 Node 클래스 사용
	static class Node {
		 public int idx;
		 public int num;
		 public Node(int idx, int num) {
			// TODO Auto-generated constructor stub
			 this.idx=idx;
			 this.num=num;
		}
	}

	public static void main(String[] args) throws IOException {
		
		// 한 줄로 출력하기 위해서 bw 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		// 최솟값 찾기에서 정렬을 구현하기 위해 deque 사용
		Deque<Node> deque = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		
		// 시간복잡도 N
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			// 정렬 -> 자신보다 큰 수가 있다면 차례로 삭제
			while(!deque.isEmpty() && deque.getLast().num > now) {
				deque.removeLast();
			}
			
			// 슬라이딩 윈도우 -> 일정범위인 i-L 범위를 계속 관
			deque.addLast(new Node(i, now));
			if(deque.getFirst().idx <= i-L) {
				deque.removeFirst();
			}
			
			bw.write(deque.getFirst().num + " ");
			
		}
		bw.flush();
		bw.close();
		
	}
}