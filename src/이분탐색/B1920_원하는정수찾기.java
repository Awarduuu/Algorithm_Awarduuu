package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_원하는정수찾기 {
	
	static int N;
	static int[] array;
	static int binarySearch(int t) {
		
		int s=0;
		int e=N-1;
		
		while(s<=e) {
			int mid=(s+e)/2;
			if(array[mid]==t) {
				return 1;
			}else if(array[mid]<t) {
				s=mid+1;
			}else {
				e=mid-1;
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		array=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		
		st=new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int target=Integer.parseInt(st.nextToken());
			System.out.println(binarySearch(target));
		}
		
		

	}

}
