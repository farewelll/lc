package fourteen;

public class MergeTwoSortedArrays {
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || B == null) {
            return null;
        }

        int[] result = new int[A.length + B.length];
        int a = 0;
        int b = 0;
        int current = 0;

        while (a < A.length && b < B.length) {
            if (A[a] < B[b]) {
                result[current++] = A[a++];
            } else {
                result[current++] = B[b++];
            }
        }

        while (a < A.length) {
            result[current++] = A[a++];
        }
        while (b < B.length) {
            result[current++] = B[b++];
        }

        return result;
    }
}
