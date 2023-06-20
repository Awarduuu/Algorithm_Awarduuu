package 정렬;

public class Sort {

    public void mergeSort(int [] arr, int start, int end){
        if(start>=end) return;

        // 분할
        int center = (start + end)/2;
        mergeSort(arr, start, center);
        mergeSort(arr, center+1, end);


        // 정복
        int [] temp = new int [arr.length];

        int idx = 0;
        int left_p = start;
        int right_p = center+1;

        while(left_p <= right_p){
            if(arr[left_p] < arr[right_p]) temp[idx++] = arr[left_p++];
            else if(arr[left_p] > arr[right_p]) temp[idx++] = arr[right_p++];
            else if(left_p > center) temp[idx++] = arr[right_p++];
            else temp[idx++] = arr[left_p++];
        }

        for(int i=0; i<arr.length; i++){
            arr[i] = temp[i];
        }
    }
}
