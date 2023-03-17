import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J1828_냉장고_윤상우 {
	static int n;
	static int [][] temp;
	static int cnt;
	static boolean [] isValid;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		temp = new int[n][2];
		isValid = new boolean[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			temp[i][0] = Integer.parseInt(st.nextToken());
			temp[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(temp, (o1, o2) -> o1[0] - o2[0]);
		
		
	}

}
