class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        int index, move = length -1;
        
        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            index = i + 1;
            
            while(index < length && name.charAt(index) == 'A')
                index++;
            
            //순서대로 가는 것 vs 뒤로 가는 것
            move = Math.min(move, i * 2 + length - index);
            
            //처음부터 뒤로 가는 것
            move = Math.min(move, (length - index) * 2 + i);
        }
        return answer + move;
    }
}