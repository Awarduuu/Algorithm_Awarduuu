package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1854_K번째최단경로찾기 {
	static int N;
	static int M;
	static int k;
	static List<Node> [] graph;
	static PriorityQueue<Integer> [] queueArray;
	static PriorityQueue<Node> queue;
	
	// '연결노드', '연결노드까지 가는 거리'를 속성으로 가지는 Node 클래스선
	static class Node implements Comparable<Node>{
		// 연결노드
		int node;
		// 연결노드까지 가는 거리
		int time;
		
		Node(int next, int time){
			this.node=next;
			this.time=time;
		}
		
		// time이 큰 순서로 우선순위를 설정하기 위해 선언
		public int compareTo(Node n) {
			return this.time-n.time;
		}
	}
	
	// 최소거리를 구하기 위한 dijkstra 함수 선언
	static void dijkstra(Node n) {
		queue.add(n);
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			for(Node next : graph[now.node]) {
				int cost = now.time+next.time;
				// k번째 거리를 구하기 위해 일단 k번째까지 기록 (이때는 k번째 최단거리인지 불확실함)
				if(queueArray[next.node].size() < k) {
					queueArray[next.node].add(cost);
					queue.add(new Node(next.node, cost));
					continue;
				}
				// k번째 최단거리를 갱신하는 단계(확실하게 만드는 단계)
				if(queueArray[next.node].peek() > cost) {
					queueArray[next.node].poll();
					queueArray[next.node].add(cost);
					queue.add(new Node(next.node, cost));
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		graph=new List[N+1];
		queue=new PriorityQueue<Node>();
		// 각 노드 별 K번째 최소거리를 기록하기 위해 우선순위큐를 자료구조로 사용
		// 큐에 이미 들어온 순간 정렬이 되어있기 때문에 k번째 값만 계속 비교해주면 된다!
		queueArray=new PriorityQueue [N+1];
		// 오름차순 우선순위를 적용하기 위해 Comparator 객체 생성
		Comparator<Integer> cp=new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		};
	
		for(int i=1; i<N+1; i++) {
			graph[i]=new ArrayList<>();
			queueArray[i]=new PriorityQueue<>(cp);
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int now=Integer.parseInt(st.nextToken());
			int node=Integer.parseInt(st.nextToken());
			int time=Integer.parseInt(st.nextToken());
			graph[now].add(new Node(node, time));
		}
		
		queueArray[1].add(0);
		dijkstra(new Node(1, 0));
		
		
		for(int i=1; i<N+1; i++) {
			if(queueArray[i].size()<k) {
				System.out.println(-1);
				continue;
			}
			System.out.println(queueArray[i].peek());
		}
	}

}
