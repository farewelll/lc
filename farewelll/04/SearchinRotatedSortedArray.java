package four;

public class SearchinRotatedSortedArray {
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0){
            return -1;
        }
        int min = 0 ;
        int max = A.length - 1 ;
        while(min + 1 < max){
            int mid = min + (max - min)/2;
            if (A[mid] == target){
                return mid;
            }
            if (A[min] < A[mid]){
                if (A[min] <= target && target <= A [mid]){
                    max = mid ;
                } else{
                    min = mid ;
                }
            } else {
                if (A[mid] <= target && target <= A[max]){
                    min = mid ;
                } else {
                    max = mid;
                }
            }
        }
        if (A [min] == target){
            return min;
        }
        if (A[max] == target){
            return max;
        }
        return -1;
    }
}
