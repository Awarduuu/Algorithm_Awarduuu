package Day7.P_전력망;
import java.io.BufferedReader;
import java.util.*;
import java.io.*;
public class P_전력망 {
    static ArrayList<Integer> [] arr;
    static boolean [] isVisited;
    static int answer;

    static void solution(int node, int delete){
//        if(node == delete){
//            isVisited[node] = false;
//            return;
//        }
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(node);
        isVisited[node] = true;

        while(!que.isEmpty()){
            int nowNode = que.poll();

            for(int nextnode : arr[nowNode]){
                if(nextnode == delete) continue;
                if(isVisited[nextnode]) continue;
                que.offer(nextnode);
                isVisited[nextnode] = true;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];

        for(int i=0; i<=n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=1; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int son = Integer.parseInt(st.nextToken());
            arr[parent].add(son);
            arr[son].add(parent);
        }

        answer = 1000;
        for(int i = 1; i<=n; i++){
            isVisited = new boolean[n+1];
            int cnt = 0;

            solution(1,i);

            for(boolean check : isVisited){
                if(check) cnt++;
            }

            int temp = Math.abs((n - cnt) - cnt);

            if(temp < answer) answer = temp;
            System.out.println(i + ", " + answer);
        }



    }


}
