class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        int i = 1;
        while(i < n){
            answer[i] = answer[i-1] + x;
            i++;
        }
        return answer;
    }
}