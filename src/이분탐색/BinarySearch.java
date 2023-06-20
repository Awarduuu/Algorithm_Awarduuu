package 이분탐색;

public class BinarySearch {

    public int binarySearch(int [] arr, int target){
        int mid;
        int left = 0;
        int right = arr.length-1;

        while(left<=right){
            mid = (left + right)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }

}
