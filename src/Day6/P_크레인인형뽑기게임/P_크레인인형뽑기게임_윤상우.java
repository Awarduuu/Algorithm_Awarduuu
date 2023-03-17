package Day6.P_크레인인형뽑기게임;

import java.util.Stack;

public class P_크레인인형뽑기게임_윤상우 {

	static int [][] board =  {
			{0,0,0,0,0},
			{0,0,1,0,3},
			{0,2,5,0,1},
			{4,2,4,4,2},
			{3,5,1,3,1}
	};
	
	static int [] moves = {1,5,3,5,1,2,1,4};
	
	static Stack<Integer> basket = new Stack<>();
	
	public static int solution(int[][] board, int[] moves) {
        Stack<Integer>  basket = new Stack<>();
        int N = board.length;
        int answer = 0;
        
        for(int move : moves) {
        	for(int j=0; j<N; j++) {
        		if(board[j][move-1] != 0) {
        			
        			if(basket.isEmpty()) {
        				basket.push(board[j][move-1]);
        				board[j][move-1] = 0;
        				break;
        			}
        			
        			if(basket.peek() == board[j][move-1]) {
        				basket.pop();
        				answer += 2;
        			}else {
        				basket.push(board[j][move-1]);
        			}
        			
        			board[j][move-1] = 0;
    				break;
        			
        		}
        	}
        }
        return answer;
	}
//        for(int i=0; i<act; i++) {
//        	int num = moves[i]-1;
//        	for(int j=0; j<N; j++) {
//        		if(board[j][num] != 0) {
//        			doll = board[j][num];
//        			if(!basket.isEmpty()) {
//                		if(basket.peek() == doll) {
//                			basket.pop();
//                			answer += 2;
//                		} else {
//                			basket.push(doll);
//                		}
//                	}else {
//                		basket.push(doll);
//                	}
//        			board[j][num] = 0;
//        			break;
//        		}
//    			
//        	}
//        }
// 
//        return answer;
//    }
	public static void main(String[] args) {
		
		System.out.println(solution(board, moves));
	}

}
