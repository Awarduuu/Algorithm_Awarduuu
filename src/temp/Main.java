package temp;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static int R;
    static int [] selection;
    static boolean [][] isVisited;
    static int [][] array;
    static int monster;
    static int [] person;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int n;
    static int m;
    static int range;

//    static void permutation(int r){
//        if(r==R){
//            for(int i: selection){
//                System.out.print(array[i] + " ");
//            }
//            System.out.println();
//            return;
//        }
//
//        for(int i=0; i<array.length; i++){
//            if(isVisited[i]) continue;
//            selection[r] = i;
//            isVisited[i] = true;
//            permutation(r+1);
//            isVisited[i] = false;
//        }
//    }
//
//    static void combination(int s, int r){
//        if(r==R){
//            for(int i: selection){
//                System.out.print(array[i] + " ");
//            }
//            System.out.println();
//            return;
//        }
//
//        for(int i=s; i<array.length; i++){
//            selection[r] = i;
//            combination(i+1, r+1);
//        }
//    }

    static boolean isValid(int x, int y){
        if(x<0 || x>=n || y<0 || y>=m) return false;
        return true;
    }

    static void dfs(int start[]){
        for(int i=0; i<4; i++){
            int next_x = start[0] + dx[i];
            int next_y = start[1] + dy[i];
            int next_range = start[2] + 1;
            if(!isValid(next_x,next_y)) {
                range = Math.min(range, next_range);
                continue;
            }
            if(isVisited[next_x][next_y]) continue;
            if(array[next_x][next_y] == 0) continue;
            isVisited[next_x][next_y] = true;
            dfs(new int[]{next_x, next_y, next_range});
            isVisited[next_x][next_y] = false;
        }
    }
    static void bfs(int start[]){
        Queue<int []> que = new ArrayDeque<>();
        que.add(start);
        isVisited[start[0]][start[1]] = true;
        monster += array[start[0]][start[1]];
        person[0] = 1;

        while(!que.isEmpty()){
            int [] now = que.poll();
            int now_x = now[0];
            int now_y = now[1];
            int now_range = now[2];



            for(int i=0; i<4; i++){
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                int next_range = now_range + 1;
                if(!isValid(next_x,next_y)) continue;
                if(isVisited[next_x][next_y]) continue;
                if(array[next_x][next_y] == 0) continue;

                que.offer(new int []{next_x,next_y, next_range});
                isVisited[next_x][next_y] = true;
                if(next_range < range){
                    person[next_range] += 1;
                    monster += array[next_x][next_y];
                }
            }
        }
    }
    public static void main(String[] args) {
        array = new int [][]{{1,2,3,4,5},{6,0,0,0,7},{8,2,3,0,9},{10,3,4,5,15},{11,12,13,14,16}};

        n = array.length;
        m = array[0].length;

        isVisited = new boolean[n][m];
        monster = 0;

        range = Integer.MAX_VALUE;

        dfs(new int[]{2,2,0});

        person = new int [range];

        bfs(new int[]{2,2,0});

        Arrays.sort(person);

        System.out.println(monster);

        System.out.println(person[range-1]);
    }
}
