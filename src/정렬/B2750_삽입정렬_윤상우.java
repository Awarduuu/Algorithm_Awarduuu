package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_삽입정렬_윤상우 {

	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void insertSort(int [] arr) {
		int len = arr.length;
		for(int i=1; i<len; i++) {
			for(int j=i; j>0; j--) {
				if(arr[j-1]>arr[j]) {
					swap(arr, j, j-1);
				}else break;
			}
		}
	}
	
	public static void insertSort2(int [] arr) {
		int len = arr.length;
		for(int i=1; i<len; i++) {
			int target = arr[i];
			int j = i-1;
			while(j>=0 && target < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = target;
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
		
		insertSort(arr);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
