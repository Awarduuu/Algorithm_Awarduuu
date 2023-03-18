package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식 {
	
	static int N;
	static int [] a;
	static int [] b;
	static long dif;
	static long best = Integer.MAX_VALUE;
	static boolean [] isSelected;
	
	public static void cook(int r) {
		if(r==N) {
			int a_mul = 1;
			int b_sum = 0;
			int cnt = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					a_mul *= a[i];
					b_sum += b[i];
					cnt ++;
				}
			}
			if(cnt != 0) {
				dif = Math.abs(a_mul - b_sum);
				if(dif < best) best = dif;
			}
			return;
		}
		
		isSelected[r] = true;
		cook(r+1);
		
		isSelected[r] = false;
		cook(r+1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		a = new int[N];
		b = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new boolean [N];
		cook(0);
		
		System.out.println(best);
	}
}
