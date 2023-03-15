package Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_윤상우 {
	static int l;
	static int c;
	static String [] arr;
	static boolean [] isSelected;
	static int [] selection;
	static int flag1;
	static int flag2;
	static int cnt;

	public static void password(int num, int start) {
		if(num == l) {
			cnt++;
//			String ans = "";
			int flag1 = 0;
			int flag2 = 0;
			for(int i=0; i<l; i++) {
				if("aeiou".contains(arr[selection[i]]) ) {
					flag1++;
				} else {
					flag2++;
				}
			}
			
			if(flag1>=1 && flag2 >=2) {
				 for(int i=0; i<l; i++) System.out.print(arr[selection[i]]);    // 결과 출력
				 System.out.println();
			}
			
			return;
		}
		
		
		for(int i=start; i<c; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			selection[num] = i;
			password(num+1, i);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new String [c];
		isSelected = new boolean [c];
		selection = new int [l];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++) arr[i] = st.nextToken();
		
		Arrays.sort(arr);
		cnt = 0;
		
		password(0, 0);
				
	}
}
