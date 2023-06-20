package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14502_연구소_윤상우 {
	static int n;
	static int m;
	static int [][] lab;
	static int [][] temp_lab;
 	static int ans = 0;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	static boolean checkValid(int x, int y) {
		if(x < 0 || x >= n || y < 0 || y >= m) return false;
		return true;
	}
	
	static void makeWall(int cnt) {
		if(cnt == 3) {
			ans = Math.max(countSafe(), ans);
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(lab[i][j] != 0) continue;
				lab[i][j] = 1;
				makeWall(cnt+1);
				lab[i][j] = 0;
			}
		}
	}
	
	static int countSafe() {
		for(int i=0; i<n; i++) temp_lab[i] = lab[i].clone();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(lab[i][j] == 2) virus(i,j,temp_lab);
			}
		}
		
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(temp_lab[i][j] == 0) cnt++;
			}
		}
		
		return cnt;
	}
	
	static void virus(int x, int y, int [][] temp) {
		temp[x][y] = 2;
		int next_x, next_y;
		for(int i=0; i<4; i++) {
			next_x = x + dx[i];
			next_y = y + dy[i];
			if(!checkValid(next_x, next_y) || !(temp[next_x][next_y] == 0)) continue;
			virus(next_x, next_y, temp);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		lab = new int [n][m];
		temp_lab = new int [n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++) {
				lab [i][j] = Integer.parseInt(st.nextToken());
			}
		}

		makeWall(0);
		
		System.out.println(ans);

		
	}

}
