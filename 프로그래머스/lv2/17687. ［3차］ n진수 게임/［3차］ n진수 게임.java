class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder s = new StringBuilder();
        StringBuilder result = new StringBuilder();
        //String s = "";
        //String result = "";
        
        for(int i = 0; s.length() < t * m; i++){
            s.append(Integer.toString(i, n));
            //s += Integer.toString(i, n);
        }
        
        for(int i = p - 1; result.length() < t; i += m){
            result.append(s.charAt(i));
            //result += s.charAt(i);
        }
        
        return result.toString().toUpperCase();
    }
}