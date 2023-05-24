import java.util.*;
class Solution {
    static HashMap<String, String> map = new HashMap<>();
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        map.put("C#", "c");
        map.put("D#", "d");
        map.put("F#", "f");
        map.put("G#", "g");
        map.put("A#", "a");
        
        m = change(m);
        
        int max = 0;
        for(int i = 0; i < musicinfos.length; i++){
            String[] temp = musicinfos[i].split(",");
            int time = calcTime(temp[0], temp[1]);
            String music = change(temp[3]);
            
            while(music.length() < time)
                music += music;
            
            music = music.substring(0, time);
            
            if(music.contains(m)){
                if(max < time){
                    max = time;
                    answer = temp[2];
                }
            }
            
        }
        
        return answer;
    }
    
    public String change(String s){
        for(String str : map.keySet())
            s = s.replace(str, map.get(str));
        
        return s;
    }
    
    public int calcTime(String s1, String s2){
        String[] time1 = s1.split(":");
        String[] time2 = s2.split(":");
        
        int h1 = Integer.parseInt(time1[0])*60;
        int h2 = Integer.parseInt(time2[0])*60;
        
        int m1 = Integer.parseInt(time1[1]);
        int m2 = Integer.parseInt(time2[1]);
        
        return (h2+m2)-(h1+m1);
    }
}