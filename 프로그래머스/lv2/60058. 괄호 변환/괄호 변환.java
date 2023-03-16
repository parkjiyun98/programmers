class Solution {
    public String solution(String p) {
        if(check(p))
            return p;
        return dfs(p);
    }
    public String dfs(String t) {
        if(t.length() == 0)
            return "";
        String u = "";
        String v = "";
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(c == '(')
                count1++;
            else
                count2++;
            if(count1 != 0 && count2 != 0 && count1 == count2){
                u = t.substring(0, i+1);
                if(i != t.length() - 1)
                    v = t.substring(i+1, t.length());
                break;
            }
        }
        if(!check(u)){
            String temp = "(" + dfs(v) + ")";
            u = u.substring(1, u.length() - 1);
            
            for(int i=0; i<u.length(); i++){
                if(u.charAt(i) == '('){
                    temp += ')';
                }else{
                    temp += '(';
                }
            }
            return temp;
        }
            
        return u + dfs(v);
    }
    public boolean check(String s){
        int count = 0;            
        if(s.charAt(0) == ')') return false;
        
        for(int i =0; i < s.length(); i++){
            
            if(s.charAt(i) == '(') 
                count++;
            else {
                count--;
                if(count<0) return false;
            }
        }

        return true;
    }
}