package 벼락치기;

import java.util.*;
import java.io.*;

public class B1541_최솟값괄호배치 {
	static int sum(String str) {
		int s=0;
		String[] temp=str.split("\\+");
		for(String t:temp) {
			s+=Integer.parseInt(t);
		}
		return s;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		String example= st.nextToken();
		String[] arr= example.split("-");
		int l=arr.length;
		int ans=sum(arr[0]);
				
		for(int i=1; i<l; i++) {
			ans-=sum(arr[i]);
		}
		
		System.out.println(ans);
	}

}
