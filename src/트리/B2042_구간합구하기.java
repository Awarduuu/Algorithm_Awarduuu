package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2042_구간합구하기 {
	
	static int N;
	static int M;
	static int K;
	static long[] tree;
	static int size;
	
	// 3. 세그먼트 트리 (합) 완성하기
	static void setTree() {
		for(int i=size-1; i>0; i--) {
			// 이진트리 -> 부모노드(i) = 자식노드1(i*2) + 자식노드2(i*2+1)
			tree[i]=tree[i*2]+tree[i*2+1];
		}
	}
	
	// 4-1. 값 변경 (데이터 업데이트)
	static void changeVal(long idx, long val) {
		idx=idx+size-1;
		// 변경값 계산
		long diff=val-tree[(int)idx];
		while(idx>0) {
			// 부모노드(i/2)만 변경값 갱신
			tree[(int)idx]+=diff;
			idx/=2;
		}
	}
	
	// 4-2. 부분합 구하기 (질의값 변경)
	static void getPartSum(long s, long e) {
		long partSum=0;
		s=s+size-1;
		e=e+size-1;
		
		while(s<=e) {
			// s가 오른쪽 노드일 경우 = 독립노드
			if(s%2==1) {
				partSum+=tree[(int)s];
				s++;
			}
			// e가 왼쪽 노드일 경우 = 독립노드
			if(e%2==0) {
				partSum+=tree[(int)e];
				e--;
			}
			s/=2;
			e/=2;
		}
		System.out.println(partSum);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		// 1. 세그먼트 트리 사이즈 정하기
		size=1;
		while(size < N) {
			size*=2;
		}
		tree=new long[size*2];
		
		// 2. 루트 노드들 트리에 입력
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			tree[size+i]=Long.parseLong(st.nextToken());
		}
		
		// 3. 세그먼트 트리 (합) 완성
		setTree();
		
		// 4. 작업 시작
		for(int i=0; i<M+K; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			long b=Long.parseLong(st.nextToken());
			long c=Long.parseLong(st.nextToken());
			
			switch(a) {
			// 4-1. 값 변경
			case 1:
				changeVal(b, c);
				break;
			// 4-2. 부분합 계산
			case 2:
				getPartSum(b, c);
				break;
			}
		}

	}

}
