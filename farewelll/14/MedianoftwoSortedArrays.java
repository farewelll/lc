package fourteen;

public class MedianoftwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int n = A.length;
        int m = B.length;
        if ((m + n) % 2 == 1) {
            return getNum(A, 0, B, 0, (n + m) / 2);
        } else {
            return (getNum(A, 0, B, 0, (n + m) / 2)
                    + getNum(A, 0, B, 0, (n + m) / 2 - 1)) / 2;
        }
    }

    private double getNum(int[] A, int startA, int[] B, int startB, int k) {
        //find the element with index k in the merged array
        if (k == 0) {
            if (startA == A.length) {
                return B[startB];
            }
            if (startB == B.length) {
                return A[startA];
            }
            if (A[startA] > B[startB]) {
                return B[startB];
            } else {
                return A[startA];
            }
        }

        if (k == 1) {
            if (startA == A.length) {
                return B[startB + 1];
            }
            if (startB == B.length) {
                return A[startA + 1];
            }
            if (A[startA] > B[startB]) {
                return getNum(A, startA, B, startB + 1, 0);
            } else {
                return getNum(A, startA + 1, B, startB, 0);
            }
        }

        int mid = k / 2;
        if (startA + mid  >= A.length) {
            return getNum(A, startA, B, startB + mid, k - mid);
        }
        if (startB + mid  >= B.length) {
            return getNum(A, startA + mid, B, startB, k - mid);
        }
        if (A[startA + mid] > B[startB + mid]) {
            return getNum(A, startA, B, startB + mid, k - mid);
        } else {
            return getNum(A, startA + mid, B, startB, k - mid);
        }
    }
}
