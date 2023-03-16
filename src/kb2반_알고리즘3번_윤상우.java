import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb2반_알고리즘3번_윤상우 {
	
	static int [] dx = {-1,0,1,1};
	static int [] dy = {1,1,1,0};
	static int [][] arr;
	
	// 같은 돌인지 체크
	static boolean checkPlayer(int player, int x, int y) {
		if(checkValid(x, y) && arr[x][y] == player) return true;
		else
			return false;
	}
	
	// 배열 인덱스가 유효한지 판단하는 함수
	static boolean checkValid(int x, int y) {
		if(x<1 || x>20 || y<1 || y>20) return false;
		return true;
	}
	
	static int  checkFinish(int x, int y) {
		int nowPlayer = arr[x][y];
		
		if(nowPlayer == 0) return nowPlayer;
		
		int next_x; int next_y;
		boolean flag;
		
		
		
		for(int i=0; i<4; i++) {
			
			next_x = x;
			next_y = y;
			flag = true;
			
			for(int cnt=0; cnt<4; cnt++) {
				next_x = x+dx[i];
				next_y = y+dy[i];
				
				if(!checkPlayer(nowPlayer, next_x, next_y)) {
					flag = false;
					break;
				}
			}
			
			if(flag == true) {
				if(checkPlayer(nowPlayer, next_x + dx[i], next_y + dy[i])) {
					flag = false;
					continue;
				}
				if(checkPlayer(nowPlayer, x - dx[i], y - dy[i])) {
					flag = false;
					continue;
				}
				return nowPlayer;
			}
		}
		
		return 0;
	}
	
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		arr = new int [20][20];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<20; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<20; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int x=1; x<20; x++) {
			for(int y=1; y<20; y++) {
				int check;
				if((check = checkFinish(x,y))!=0) {
					System.out.println(check);
					System.out.println(x + " " + y);
					return;
				};
			}
		}
		System.out.println(0);
		
		
		
	}

}
