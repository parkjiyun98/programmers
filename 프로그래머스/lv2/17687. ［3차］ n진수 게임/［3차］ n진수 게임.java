class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder x = new StringBuilder();
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; x.length() <= t * m; i++){
            x.append(Integer.toString(i, n));
        }
        
        for(int i = p - 1;  result.length() < t; i += m){
            result.append(x.charAt(i));
        }
        
        return result.toString().toUpperCase();
        
    }
}