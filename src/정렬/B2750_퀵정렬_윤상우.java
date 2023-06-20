package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_퀵정렬_윤상우 {

	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static int partition(int [] arr, int start, int end) {
		int pivot = start;
		int left = start + 1;
		int right = end;
		while(left <= right) {
			while(left <= right && arr[left] < arr[pivot]) {
				left++;
			}
			while(left <= right && arr[right] > arr[pivot]) {
				right--;
			}
			
			if(left > right)
				swap(arr, pivot, right);
			else
				swap(arr, left, right);
		}
		pivot = right;
		
		return pivot;
	}
	
	public static void quickSort(int [] arr, int start, int end) {
		// 재귀는 종료 조건이 꼭 필요하다!
		if(start >= end) return;
		
		int pivot = partition(arr, start, end);
		quickSort(arr, start, pivot-1);
		quickSort(arr, pivot+1, end);
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
		
		quickSort(arr, start, end);
		
		for(int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
	}

}
