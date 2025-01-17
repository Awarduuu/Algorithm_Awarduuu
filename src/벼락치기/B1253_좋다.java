package 벼락치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253_좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int[] l=new int[N];
		for(int i=0; i<N; i++) {
			l[i]=Integer.parseInt(st.nextToken());
		}
		// 정렬 시간복잡도 nlogn
		Arrays.sort(l);
		
		int ans=0;
		// 총 시간복잡도 n^2
		for(int i=0; i<N; i++) {
			int K=l[i];
			int s=0;
			int e=N-1;
			// 투포인터 시간복잡도 = n
			while(s<e) {
				if(l[s]+l[e]==K) {
					if(i!=s && i!=e) {
						ans++;
						break;
					} else if(i==s) {
						s++;
					}else {
						e--;
					}
				}else if(l[s]+l[e]<K) {
					s++;
				}else {
					e--;
				}
			}
		}
		System.out.println(ans);
		
	}
}
