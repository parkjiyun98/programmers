import java.util.*;
class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        arr = numbers.toCharArray();
        visited = new boolean[numbers.length()];
          
        check("",0);
        
        answer = set.size();
        return answer;
    }
    public void check(String str, int index){
        int num;
        if(str!=""){
            num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }
        if(index == arr.length) return; 
        
        for(int i=0;i<arr.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            check(str+arr[i], index+1);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}