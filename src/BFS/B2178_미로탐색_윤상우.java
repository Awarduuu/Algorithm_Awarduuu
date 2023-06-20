package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색_윤상우 {
	
	static int n;
	static int m;

	// 상하좌우
	static int []dx = {-1,1,0,0};
	static int []dy = {0,0,-1,1};
	
	static int [][] arr;	
	static boolean [][] isVisited;
	
	public static boolean checkValid(int x, int y) {
		if(x<0 || x>=n || y<0 || y>=m) return false;
		else return true;
	}
	
	static void bfs(int x, int y) {
		Queue<int []> que = new ArrayDeque<>();
		que.offer(new int [] {x, y});
		isVisited[x][y] = true;
		
		while(!que.isEmpty()) {
			int now [] = que.poll();
			int now_x = now[0];
			int now_y = now[1];
			
			for(int i=0; i<4; i++) {
				int next_x = now_x + dx[i];
				int next_y = now_y + dy[i];
				
				if(!checkValid(next_x, next_y)) continue;
				if(isVisited[next_x][next_y]) continue;
				
				if(arr[next_x][next_y] == 1) {
					que.offer(new int [] {next_x, next_y});
					isVisited[next_x][next_y] = true;
					arr[next_x][next_y] = arr[now_x][now_y] + 1; 
				}
				
				
			}
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		arr = new int [n][m];
		isVisited = new boolean [n][m];
		
		for(int i=0; i<n; i++) {
			String line = bf.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = (int)(line.charAt(j) - '0');
			}
		}
		
		bfs(0,0);
		System.out.println(arr[n-1][m-1]);
	}

}
