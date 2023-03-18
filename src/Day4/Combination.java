package Day4;

public class Combination {

// 중복 허용 X
static char [] arr;
static int R;                   // 선택개수
static int [] selection;         // 현재 선택한 요소
static boolean [] isSelected;     // 마킹배열 - 선택했는지 체크

static void combination(int r, int start) {

    if(r == R) {
        for(int i=0; i<R; i++) System.out.print(arr[selection[i]]);    // 결과 출력
        System.out.println();
        return;
    }

    for(int i=start; i<arr.length; i++) {
        if(isSelected[i]) continue;        // 중복인 경우 skip
        isSelected[i] = true;            // 중복 마킹
        selection[r] = i;                // 선택
        combination(r+1, i);                // 다음 재귀로
        isSelected[i] = false;            // 선택한걸 되돌려줘야 함
    }
}


public static void main(String[] args) {

    arr = new char [] {'A' , 'B' , 'C' , 'D'};
    R = 2;
    selection = new int [R];
    isSelected = new boolean [arr.length];

    combination(0, 0);

}
}