package Day4;

public class Subset {
		
	static char [] arr;
	static int N;
	static boolean [] isSelected;
	static int cnt;
	
	static void subset(int num) {
		// 종료 조건
		if(num == N) {
			cnt++;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		// 분할
		// 선택 O
		isSelected[num] = true;
		subset(num+1);
		// 선택 X
		isSelected[num] = false;
		subset(num+1);
	}
	
	public static void main(String[] args) {
		arr = new char [] {'A', 'B', 'C', 'D'};
		N = arr.length;
		
		isSelected = new boolean[N];
		
		subset(0);
		System.out.println(cnt);
	}

}
