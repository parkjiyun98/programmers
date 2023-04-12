class Solution {
    public int solution(int n) {
        /*
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
        */
        if(n == 2 || n == 1)
            return 1;
        int answer = 1, sum = 0, lt = 0;
        int m = n/2 + 1;
        int[] arr = new int[m];
        for(int i = 0; i < m; i++){
            arr[i] = i+1;
        }
        for(int rt = 0; rt < m; rt++){
            sum += arr[rt];
            if(sum == n)
                answer++;
            while(sum >= n){
                sum -= arr[lt++];
                if(sum == n) answer++;
            }
        }
        return answer;
    }
}