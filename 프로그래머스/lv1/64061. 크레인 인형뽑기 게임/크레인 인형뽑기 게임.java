import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for(Integer move : moves) {
            move = move - 1;
            // stack의 시작위치는 0부터이기 때문에 위치의 오류를 맞추기 위해서 -1 적용 
            for(int i = 0; i < board.length; i++) {
                int num = board[i][move];
                if(num == 0) continue;
                if(!stack.empty() && stack.peek() == num) {
                    stack.pop();
                    answer+=2;
                } else {
                    stack.push(num);
                }
                board[i][move] = 0;
                break;
            }
        }
        
        return answer;
    }
}