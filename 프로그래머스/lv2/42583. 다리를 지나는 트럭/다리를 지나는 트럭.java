import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int sum = 0; //다리 건너는 트럭들 합
        
        for(int w : truck_weights){
            while(true){
                //큐가 비어있다면 다음 트럭 넣기
                if(q.isEmpty()){
                    q.offer(w);
                    sum += w;
                    answer++;
                    break;
                }
                
                else if(q.size() == bridge_length)
                    sum -= q.poll();
                
                //큐가 비어있지 않을 때
                else{
                    //다음 트럭 무게가 최대 무게 초과
                    if(sum + w > weight){
                        q.offer(0);
                        answer++;
                    }
                    else{
                        q.offer(w);
                        sum += w;
                        answer++;
                        break;
                    }
                }
            }
        }
        
        // 걸린 시간 + 마지막 트럭의 통과시간(다리의 길이)
        return answer + bridge_length;
    }
}