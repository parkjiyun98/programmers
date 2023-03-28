import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIndex = 0;
        int bIndex = 0;
        int bLength = B.length;
        while(bLength > 0){
            if(A[aIndex] < B[bIndex] ){
                aIndex++;
                bIndex++;
                bLength--;
                answer++;
            }
            else{
                bIndex++;
                bLength--;
            }
        }
        return answer;
    }
}