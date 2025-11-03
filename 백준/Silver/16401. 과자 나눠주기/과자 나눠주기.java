import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 친구 수
        int M = sc.nextInt(); // 과자 개수
        int[] snack = new int[M];
        int maxLength = 0;
        
        for(int i = 0; i < M; i++){
            snack[i] = sc.nextInt();
            if(snack[i] > maxLength) maxLength = snack[i];
        }
        
        int left = 1;
        int right = maxLength;
        int answer = 0;
        
        while (left <= right){
            int mid = (left+right) / 2;
            int count = 0;
            
            for(int i = 0; i < M; i++){
                count += snack[i] / mid;
            }
            
            if(count >= N){
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
}