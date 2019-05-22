package three;

public class FindKClosestElements {
    public int[] kClosestNumbers(int[] A, int target, int k) {
        int[] result = new int[k];

        if (A == null || A.length == 0) {
            return A;
        }
        if (k > A.length) {
            return A;
        }

        int index = firstIndex(A, target);

        int min = index - 1;
        int max = index;
        for (int i = 0; i < k; i++) {
            if (min < 0) {
                result[i] = A[max++];
            } else if (max >= A.length) {
                result[i] = A[min--];
            } else {
                if (target - A[min] <= A[max] - target) {
                    result[i] = A[min--];
                } else {
                    result[i] = A[max++];
                }
            }
        }
        return result;
    }

    private int firstIndex(int[] A, int target) {
        int min = 0, max = A.length - 1;
        while (min + 1 < max) {
            int mid = min + (max - min) / 2;
            if (A[mid] < target) {
                min = mid;
            } else if (A[mid] > target) {
                max = mid;
            } else {
                max = mid;
            }
        }

        if (A[min] >= target) {
            return min;
        }
        if (A[max] >= target) {
            return max;
        }
        return A.length;
    }
}
