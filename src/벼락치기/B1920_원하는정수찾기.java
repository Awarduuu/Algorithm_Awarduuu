package 벼락치기;
import java.util.*;
import java.io.*;
public class B1920_원하는정수찾기 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int [] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int target=Integer.parseInt(st.nextToken());
			boolean flag = false;
			int s=0; int e=N-1;
			while(s<=e) {
				int mid= (s+e)/2;
				if(arr[mid]==target) {
					flag=true;
					break;
				}else if(arr[mid]<target) {
					s++;
				}else {
					e--;
				}
			}
			if(flag) {
				System.out.println(1);
				continue;
			}
			System.out.println(0);
			
		}
	}

}
