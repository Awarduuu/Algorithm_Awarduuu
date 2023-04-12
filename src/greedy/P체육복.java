package greedy;

import java.io.*;
import java.util.*;

public class P체육복 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int [] people = new int [n+2];

        for(int i : lost){
            people[i]--;
        }

        for(int i : reserve){
            people[i]++;
        }

        // [0,1,-1,1,-1,1,0]

        for(int i=1; i<n+1; i++){
            if(people[i] == -1){
                if(people[i-1] == 1){
                    people[i]++;
                    people[i-1]--;
                }else if(people[i+1] == 1){
                    people[i]++;
                    people[i+1]--;
                }else{
                    answer--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] lost = new int [k];
        int l = Integer.parseInt(st.nextToken());
        int [] reserve = new int [l];

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<k; i++) {
            lost[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<l; i++) {
            reserve[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n,lost,reserve));

    }
}
