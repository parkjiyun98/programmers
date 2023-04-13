import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        ArrayList<String> set1 = new ArrayList<>();
        ArrayList<String> set2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        
        for(int i = 0; i < str1.length()-1; i++){
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);
            
            if(first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z')
                set1.add(first + "" + second);
        }
        
        for(int i = 0; i < str2.length()-1; i++){
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);
            
            if(first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z')
                set2.add(first + "" + second);
        }
        
        Collections.sort(set1);
        Collections.sort(set2);
        
        for(String s : set1){
            if(set2.remove(s))
                intersection.add(s);
            union.add(s);
        }
        for(String s : set2){
            union.add(s);
        }
        
        double answer = 0;
        if(union.size() == 0)
            answer = 1;
        else
            answer = (double)intersection.size() / (double)union.size();
        
        return (int)(answer * 65536);
    }
}