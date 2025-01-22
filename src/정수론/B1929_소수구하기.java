package 정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1929_소수구하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[M+1];
		
		for(int i=2; i<=M; i++) {
			arr[i]=i;
		}
		
		for(int i=2; i<=Math.sqrt(M); i++) {
			if (arr[i]==0) {
				continue;
			}
			int k=2;
			while(i*k <= M) {
				arr[i*k]=0;
				k++;
			}
		}
		
		for(int i=N; i<=M; i++) {
			if(arr[i]!=0) {
				System.out.println(i);
			}
		}
		

	}

}
