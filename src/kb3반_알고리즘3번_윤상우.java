import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb3반_알고리즘3번_윤상우 {
	
	static int a;
	static int b;
	static int x;
	static int y;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int arr [][] = new int [19][19];
		
		a = 0;
		b = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				if(arr[i][j] == 1) {
					for(int k=0; k<5; k++) {
						if(arr[i+k][j] == 1) a++;
					}
					if(a < 5) a = 0;
					for(int k=0; k<5; k++) {
						if(arr[i+k][j+k] == 1) a++; 
					}
					if(a < 5) a = 0;
					for(int k=0; k<5; k++) {
						if(arr[i][j+k] == 1) a++; 
					}
					if(a < 5) a = 0;
					if(a==5) x= i+1; y= j+1; break;
				}
			}
		}
		
		for(int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				if(arr[i][j] == 1) {
					for(int k=0; k<5; k++) {
						if(arr[i+k][j] == 2) b++;
					}
					if(b < 5) b = 0;
					for(int k=0; k<5; k++) {
						if(arr[i+k][j+k] == 2) b++; 
					}
					if(b < 5) b = 0;
					for(int k=0; k<5; k++) {
						if(arr[i][j+k] == 2) b++; 
					}
					if(b < 5) b = 0;
					if(b==5) x= i+1; y= j+1; break;
				}
			}
		}
			
		if(a==5) {
			System.out.println(1);
			System.out.println(x + " " + y);
		} else if (b==5) {
			System.out.println(2);
			System.out.println(x + " " + y);
		} else {
			System.out.println(0);
		}
		
		
	}

}
