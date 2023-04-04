class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        //징검다리 건널 친구 최소
        int min = 0;
        //징검다리 건널 친구 최대
        int max = Integer.MAX_VALUE;
        
        while(min <= max){
            //징검다리 건널 수 있는 친구
            int mid = (min + max) / 2;
            if(check(stones, k, mid)){
                //다리를 건널 수 있으면 친구 수 늘림
                min = mid + 1;
                answer = mid;
            }
            else
                //다리 건널 수 없으면 친구 수 줄임
                max = mid - 1;
                
        }
        return answer;
    }
    public boolean check(int[] stones, int k, int mid){
        //못 건너는 징검다리 개수
        int count = 0;
        for(int i = 0; i < stones.length; i++){
            if(stones[i] < mid){
                count++;
                if(count >= k)
                    return false;
            }
            else count = 0;
        }
        return true;
    }
}