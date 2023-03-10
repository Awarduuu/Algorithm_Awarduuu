package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_윤상우 {
	
	public static boolean checkPassword(int [] ruleDNA, int [] nowDNA) {
		for(int i=0; i<4; i++) {
			if(ruleDNA[i] < nowDNA[i]) return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		String dna = st.nextToken();	
		int ruleDNA [] = new int [4];
		int nowDNA [] = new int  [4];
		int res = 0;
		
		st = new StringTokenizer(bf.readLine());
		
		for(int i=0; i<4; i++) {
			ruleDNA[i] = Integer.parseInt(st.nextToken());
		}
		// A C G T
		
		// 현재 dna 초기화
		
		for(int i=0; i< s-p+1; i++) {
			
			if(i == 0) {
				for(int j=0; j<p; j++) {
					switch(dna.charAt(j)) {
					case 'A' : nowDNA[0]++; break;
					case 'C' : nowDNA[1]++; break;
					case 'G' : nowDNA[2]++; break;
					case 'T' : nowDNA[3]++; break;
					}
				}
			} else {
				char remove = dna.charAt(i-1);
				switch(remove) {
				case 'A' : nowDNA[0]--; break;
				case 'C' : nowDNA[1]--; break;
				case 'G' : nowDNA[2]--; break;
				case 'T' : nowDNA[3]--; break;
				}
				
				char add = dna.charAt(i+p-1);
				switch(add) {
				case 'A' : nowDNA[0]++; break;
				case 'C' : nowDNA[1]++; break;
				case 'G' : nowDNA[2]++; break;
				case 'T' : nowDNA[3]++; break;
				}
			}
			
			if(checkPassword(ruleDNA, nowDNA)) {
				res++;
			}
		}
	
		System.out.println(res);
		
	}

}
