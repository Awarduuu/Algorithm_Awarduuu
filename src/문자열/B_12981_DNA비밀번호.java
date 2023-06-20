package 문자열;
import java.util.*;
import java.io.*;
public class B_12981_DNA비밀번호 {

    static int s;
    static int p;
    static char [] arr;
    static int [] dna;
    static int start;

    public static boolean check(int [] dna, int [] idx){
        for(int i=0; i<4; i++){
            if(idx[i]<dna[i]) return false;
        }
        return true;
    }
    public static int solution(int s, int p, char [] arr, int [] dna){
        // index A : 0, C : 1, G : 2, T : 3

        int answer = 0;

        int [] idx = new int [4];

        start = 0;
        for(int i=0; i<s-p; i++){
            if(i == 0){
                for(int j=0; j<p; j++){
                    switch(arr[j]){
                        case 'A' : idx[0]++;
                        case 'C' : idx[1]++;
                        case 'G' : idx[2]++;
                        case 'T' : idx[3]++;
                    }
                }
            }else{
                int remove = i-1;
                switch(arr[remove]){
                    case 'A' : idx[0]--;
                    case 'C' : idx[1]--;
                    case 'G' : idx[2]--;
                    case 'T' : idx[3]--;
                }
                int add = i+p-1;
                switch (arr[add]){
                    case 'A' : idx[0]++;
                    case 'C' : idx[1]++;
                    case 'G' : idx[2]++;
                    case 'T' : idx[3]++;
                }
            }

            if(check(dna, idx)) answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        arr = new char[s];

        for(int i=0; i<s; i++){
            arr[i] = str.charAt(i);
        }

        dna = new int [4];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<4; i++) {
            dna[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(s, p, arr, dna));
    }




}
