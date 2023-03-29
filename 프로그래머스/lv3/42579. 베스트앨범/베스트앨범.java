import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        ArrayList<String> genre = new ArrayList<>();
        for(String key : map.keySet()) {
            genre.add(key);
        }
        //value값으로 내림차순
        genre.sort( (o1, o2) -> map.get(o2) - map.get(o1));
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < genre.size(); i++) {
            String genreS = genre.get(i);
            
            int max = 0;
            int firstI = -1;
            for(int j = 0; j < genres.length; j++) {
                if(max < plays[j] && genreS.equals(genres[j])) {
                    max = plays[j];
                    firstI = j;
                }
            }
            
            max = 0;
            int secondI = -1;
            for(int j = 0; j < genres.length; j++) {
                if(max < plays[j] && genreS.equals(genres[j]) && j != firstI) { 
                    max = plays[j];
                    secondI = j;
                }
            }
            
            result.add(firstI);
            if(secondI >= 0) result.add(secondI);
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}