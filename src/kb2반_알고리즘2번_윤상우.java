import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb2반_알고리즘2번_윤상우 {
	
	static int n;
	static int R;
	static int max;
	static int ans;
	static int [] arr;
	static int [] selection;
	static boolean [] isSelected;

	public static void game(int r , int start) {
		if(r==R) {
			int sum = 0;
			for(int i=0; i<R; i++) {
				sum += arr[selection[i]];
			}
			if(sum <= max) 
				if(ans <= sum)
					ans = sum;
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			selection[r] = i;
			game(r+1, i);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		R = 3;
		max = Integer.parseInt(st.nextToken());
		arr = new int [n];
		isSelected = new boolean [n];
		selection = new int [R];
		ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		game(0,0);
		System.out.println(ans);
	}

}
