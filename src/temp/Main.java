package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean [] isVisited;
    static int [] selection;
    static int answer;
    static char [][] arr;
    static int [] d = {-1,1,-5,5};



    static boolean isNear(int [] array){
        int n = 0;
        boolean [] visited = new boolean [25];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(array[0]);
        isVisited[array[0]] = true;

        if(!que.isEmpty()){
            int now = que.poll();

            for(int i=0; i<4; i++) {
                int next = now + d[i];
                if (visited[next]) continue;
                if (next < 0 || next >= 25) continue;
                for (int j = 0; j < array.length; j++) {
                    if (next == array[j]) {
                        que.add(next);
                        isVisited[next] = true;
                        n++;
                    }
                }
            }
        }

        if(n==7) return true;
        return false;
    }

    static void combination(int n, int r){
        if(r==7){
            int s = 0;

            if(isNear(selection)){
                for(int i : selection){
                    int x = i/5;
                    int y = i%5;
                    if(arr[x][y] == 'S') s++;
                }
                if(s > 3) answer++;
            }

            return;
        }

        for(int i=n; i<25; i++){
            if(isVisited[i]) continue;
            isVisited[i] = true;
            selection[n] = i;
            combination(i+1,r+1);
            isVisited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0; j<5; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        isVisited = new boolean [25];
        selection = new int [7];
        answer = 0;

        combination(0,0);

        System.out.println(answer);
    }
}
