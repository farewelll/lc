package three;

public class FindPeakElement {
    public int findPeak(int[] A) {
        // write your code here
        int min = 0, max = A.length - 1;
        int mid = min + (max - min) / 2;
        while (min + 2 <= max) {
            mid = min + (max - min) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] < A[mid + 1] && A[mid] > A[mid - 1]) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return A[min] > A[max] ? min : max;
    }
}
