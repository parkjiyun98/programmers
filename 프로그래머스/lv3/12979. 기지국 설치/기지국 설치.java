class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 0;
        int cur = 1;

        while(cur <= n){
            if(index < stations.length && cur >= stations[index] - w){
                cur = stations[index] + w + 1;
                index++;
            }
            else{
                cur += 2*w + 1;
                answer++;
            }
        }

        return answer;
    }
}