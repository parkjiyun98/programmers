class Solution {
    public int solution(int n) {
        int answer = 1;
        int i = 1, start = 1, sum = 0;
        while(start <= n/2){
            sum += i;
            if(sum < n)
                i++;
            else if(sum == n){
                answer++;
                start++;
                i = start;
                sum = 0;
            }
            else{
                start++;
                i = start;
                sum = 0;
            }
        }
        return answer;
    }
}