package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2018_수들의합_윤상우 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int cnt = 1;
		int limit = n/2 +1;
		
		int start = 1;
		int end = 1;
		int tot = 1;
		
		while(end <= limit) {
			tot = (end * (end+1))/2 - (start*(start-1))/2; 
			if(tot == n) {
				start++;
				end++;
				cnt++;
				
			}else if (tot < n) {
				end++;
			}else {
				start++;
			}
		}
		
		
		System.out.println(cnt);
	}

}
