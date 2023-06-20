package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_병합정렬_윤상우 {

	public static void mergeSort(int [] arr, int start, int end) {
		// 재귀는 종료 조건이 꼭 필요하다!
		if(start >= end) return;
		
		// 분할
		int center = (start + end) / 2;
		mergeSort(arr, start, center);
		mergeSort(arr, center+1, end);
		
		// 병합
		int [] res = new int [arr.length];
		
		// 왼쪽 분할된 배열 인덱스 시작점
		int left_p = start;
		// 오른쪽 분할된 배열 인덱스 시작점
		int right_p = center + 1;
		// 임시 배열의 인덱스 시작점
		int idx = start;
		
		while(left_p <= center || right_p <= end) {
			// 어느 한 쪽이 정렬이 다 되었을 때 => 몰아넣기
			if(left_p>center) {
				res[idx++] = arr[right_p++];
			}
			else if(right_p>end) {
				res[idx++] = arr[left_p++];
			}
			// 둘 다 정렬이 안되었을 경우 비교해서 넣기
			else if(arr[left_p] > arr[right_p]) {
				res[idx++] = arr[right_p++];
			}
			else if(arr[left_p] < arr[right_p]){
				res[idx++] = arr[left_p++];
			}
		}
		
		for(int i=start; i<=end; i++) {
			arr[i] = res[i];
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int arr [] = new int [n];
	
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = n-1;
		
		mergeSort(arr, start, end);
		
		for(int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
	}
}
