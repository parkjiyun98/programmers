import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static List<int[]>[] graph;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int V = sc.nextInt(); // 정점 수
        int E = sc.nextInt(); // 간선 수
        int start = sc.nextInt(); // 시작정점 번호

        graph = new ArrayList[V + 1];
        distance = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            int s = sc.nextInt(); // 시작정점
            int e = sc.nextInt(); // 도착정점
            int w = sc.nextInt(); //간선 가중치
            graph[s].add(new int[]{e, w});
        }

        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            System.out.println(distance[i] == INF ? "INF" : distance[i]);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0]; // 현재 정점
            int dist = cur[1]; // 현재까지 거리

            if (distance[now] < dist) continue;

            for (int[] next : graph[now]) {
                int cost = dist + next[1]; // 현재 거리 + 간선 가중치
                if (cost < distance[next[0]]) {
                    distance[next[0]] = cost;
                    pq.offer(new int[]{next[0], cost});
                }
            }
        }
    }
}
