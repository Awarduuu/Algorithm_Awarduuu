package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14425_문자열집합 {
	
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int answer=0;
		tNode root=new tNode();
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			String text=st.nextToken();
			tNode now=root;
			for(int j=0; j<text.length(); j++) {
				char c=text.charAt(j);
				if(now.next[c-'a']==null) now.next[c-'a']=new tNode();
				now=now.next[c-'a'];
				if(j==text.length()-1) now.isEnd=true;
			}
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			String text=st.nextToken();
			tNode now=root;
			for(int j=0; j<text.length(); j++) {
				char c=text.charAt(j);
				if(now.next[c-'a']==null) break;
				now=now.next[c-'a'];
				if(j==text.length()-1 && now.isEnd) answer++;
			}
		}
		
		System.out.println(answer);
		
	}

}
class tNode {
	tNode[] next=new tNode[26];
	boolean isEnd;
}
