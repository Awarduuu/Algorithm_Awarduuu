package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class MG새마을 {

    static int n;
    static String [] bans;
    static List<String> temp;
    static boolean [] visited;

    static void combination(int start, int r, int R){
        if(r==R){
            String t="";
            for(int i=0; i<n; i++){
                if(visited[i]){
                    t += i+1+" ";
                }
            }
            temp.add(t);
            return;
        }

        for(int i=start; i<n; i++){
            if(visited[i])continue;
            visited[i]=true;
            combination(i,r+1,R);
            visited[i]=false;
        }
    }

    public static void main(String[] args) {
        n = 5;
        bans = new String[]{"2 3 5", "2 4 5"};
        visited = new boolean[n];
        temp = new ArrayList<>();


        for(int i=1; i<=n; i++){
            combination(0,0,i);
        }

        for(String ban : bans){
            String [] array = ban.split(" ");
            int len_ban= array.length;
            for(int i=0; i<temp.size(); i++){
                int temp_l=0;
                for(int j=0; j<len_ban; j++){
                    if(temp.get(i).contains(array[j])){
                        temp_l++;
                    }
                }

                if(temp_l==len_ban) {
                    temp.remove(i);
                }
            }
        }

        int answer = temp.size();

        System.out.println(answer);

    }
}
