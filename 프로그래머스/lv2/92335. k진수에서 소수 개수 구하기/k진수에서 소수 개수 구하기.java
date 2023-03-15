import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        String[] arr = s.split("0");
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("")) continue;
            long num = Long.parseLong(arr[i]);                       
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
    public boolean isPrime(long n){
        if(n <= 1) return false;
        else if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0) 
                return false;
        return true;
    }
}