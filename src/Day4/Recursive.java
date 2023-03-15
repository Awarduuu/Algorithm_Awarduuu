package Day4;

public class Recursive {
	
	// 재귀는 스태틱 쓰면 편함
	static char [] arr = {'A', 'B', 'C', 'D'};
	static int R;
	static int [] selection = new int [R];
	static boolean [] isSelected = new boolean [arr.length];
	
	// 중복 허용 O
	static void permutation(int r) {
		if(r == R) {
			for(int i=0; i<R; i++) System.out.print(arr[selection[i]]);
			System.out.println();
			return;
		}
		
		for(int i=0; i< arr.length; i++) {
			selection[r] = i;
			permutation(r+1);
		}
		
	}
	
	// 중복 허용 X
	static void permutation2(int r) {
		if(r == R) {
			for(int i=0; i<R; i++) System.out.print(arr[selection[i]]);
			System.out.println();
			return;
		}
		
		for(int i=0; i< arr.length; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			selection[r] = i;
			permutation2(r+1);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) {
		// 재귀의 필수 조건
		// 1. 종료 조건
		// 2. 재귀 확장
		R = 2;
		permutation(0);
	}

}
