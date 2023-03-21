class Solution {
    public int[] solution(int n, int s) {
        if(n > s) {
            return new int[] {-1};
        }
        int x = s % n;
        int[] answer = new int[n];
        for(int i = answer.length-1; i >= 0;i--){            
            answer[i] = s/n;
            if(x > 0){
                answer[i]++;
                x--;
            }
        }
        return answer;
    }
}