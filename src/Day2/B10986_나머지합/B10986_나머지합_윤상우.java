package Day2.B10986_나머지합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10986_나머지합_윤상우 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long [] arr = new long [n+1];
		long [] cnt = new long [m];
		long res = 0;
		
		// 합의 나머지로 이루어진 dp 생성
		// 구간 합 나머지를 cnt 배열에 넣기 나머지 0인 구간합의 개수는 cnt의 index가 0
		// ex) 나머지 0인 구간합의 개수는 cnt의 index가 0
		
		arr[0] = 0;
		st = new StringTokenizer(bf.readLine());
		for(int i=1; i<n+1; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = (arr[i-1] + num)%m;
			cnt[(int)arr[i]]++;
		}
		
		// 나머지가 0인 구간합은 이미 조건을 만족한다.
		res = cnt[0];
		for(int i=0; i<m; i++) {
			// 나머지가 같은 구간합 중 두개를 뽑는 경우는 빼면 나머지가 0이기 때문에 조건을 만족한다
			// n 콤비네이션 2 => n*(n-1)/2
			res += (cnt[i]*(cnt[i]-1)) / 2;
		}
		
		System.out.println(res);
		
		
		
		
		
		
		
		
		/*
		 * 3 #
		 * (1,2)# (2,3) (3,1) (1,2)# (1,2,3)# (2,3,1)# (3,1,2)# 
		 * (1,2,3,1) (2,3,1,2) (1,2,3,1,2)#
		 * 
		 */
		
		
	}

}
