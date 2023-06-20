package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9742_순열_윤상우 {
	
	static String s;
	static int n;
	static int R;
	static int [] selection;
	static boolean [] isSelected;
	static int cnt;
	static String ans;
	
	public static void permutation(int r, int n) {
		if(r==R) {
			if(++cnt==n) {
				System.out.print(ans);
				for(int i=0; i<R; i++) {
					System.out.print(s.charAt(selection[i]));
				}
				System.out.println();
				return;
			}
			
		}

		for(int i=0; i<R; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			selection[r] = i;
			permutation(r+1, n);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		while(true) {
			String input = bf.readLine();
			if(input == null) break;
			st = new StringTokenizer(input, " ");
			s = st.nextToken();
			n = Integer.parseInt(st.nextToken());
			R = s.length();
			isSelected = new boolean[R];
			selection = new int[R];
			cnt = 0;
			ans = s + " " + n + " = ";
			permutation(0, n);
			
			if(cnt < n) {
				System.out.println(ans + "No permutation");
			}
		}
	}
}

