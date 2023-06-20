package 정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class testComparator implements Comparator <String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.charAt(0) - o2.charAt(0);
	}
	
}

public class SortTest {
	
	
	public static void main(String[] args) {
		
		// 1. Arrays.sort() 메소드 이용
		int [] arr = {4, 2, 3, 9, 1, 7};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		// 내림차순 정렬 -> Collections.reverseOrder()
		Integer [] arr2 = {4, 2, 3, 9, 1, 7};
		Arrays.sort(arr2, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr2));
		
		// 2. Collections.sort() 메소드 이용
		ArrayList <Integer> arr_list = new ArrayList<>(Arrays.asList(4, 2, 3, 9, 1, 7));
		System.out.println(arr_list);
		Collections.sort(arr_list);
		System.out.println(arr_list);
		
		// 내림차순
		Collections.sort(arr_list, Collections.reverseOrder());
		System.out.println(arr_list);
		
		// 3. Comparator 클래스 이용
		ArrayList <String> str_list = new ArrayList<>(Arrays.asList("java", "c", "python", "app", "linux"));
		System.out.println(str_list);
		
		Collections.sort(str_list, new testComparator()); // 비교를 위한 클래스 미리 정의
		System.out.println(str_list);
		Collections.sort(str_list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) { // 비교를 위한 클래스 즉석 정의 (일회용)
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}
			
		});
		System.out.println(str_list);
		
		// 4. Lamda 이용
		ArrayList <Integer> arr_list2 = new ArrayList<>(Arrays.asList(4, 2, 3, 9, 1, 7));
		Collections.sort(arr_list2, (a,b) -> a - b);
		System.out.println(arr_list2);
	}
}
