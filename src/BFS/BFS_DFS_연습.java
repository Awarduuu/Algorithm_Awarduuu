package BFS;
import java.util.*;
public class BFS_DFS_연습 {

    static List<Integer> [] arr;
    static boolean [] isVisited;

    static void dfs(int node){
        // 종료 조건
        isVisited[node] = true;

        for(int nextNode : arr[node]){
            if(isVisited[nextNode]) continue;
            dfs(nextNode);
            // 체크 해제 (백트래킹) isVisited[nextNode] = false;
        }

    }

    static void bfs(int node){
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(node);
        isVisited[node] = true;

        while(!que.isEmpty()){
            int nowNode = que.poll();

            for(int nextNode : arr[node]){
                if(isVisited[nextNode]) continue;
                que.offer(nextNode);
                isVisited[nextNode] = true;
            }
        }
    }

}
