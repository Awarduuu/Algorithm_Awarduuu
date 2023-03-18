import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb2반_알고리즘1번_윤상우 {
	
	static int n;
	static int [] arr;
	
	
	public static void swap (int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void selectSort(int [] arr) {
		for(int i=0; i<n; i++) {
			int target = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j] > arr[target]) {
					target = j;
				}
			}
			swap(arr, i, target);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int [n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		selectSort(arr);
		
		for(int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
