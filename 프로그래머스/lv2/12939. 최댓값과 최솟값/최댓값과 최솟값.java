class Solution {
    public String solution(String s) {
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        String[] arr = s.split(" ");
        for(int i = 0; i < arr.length; i++){
            int number = Integer.parseInt(arr[i]);
            
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        return answer = min + " " + max;
    }
}