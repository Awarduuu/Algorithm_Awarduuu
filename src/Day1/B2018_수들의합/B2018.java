package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int limit = n/2 + 1;
        int start = 1;
        int end = 1;
        int sum = 1;
        int cnt = 1;

        while(end <= n){
            if (sum == n){
                cnt++;
                end++;
                sum += end;
            }else if(sum < n) {
                end++;
                sum += end;
            }
            else{
                sum -= start;
                start++;
            }
        }


        System.out.println(cnt);
    }

}
