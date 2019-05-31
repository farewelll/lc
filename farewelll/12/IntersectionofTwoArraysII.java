package twelve;

import java.util.Arrays;

public class IntersectionofTwoArraysII {
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        int[] arr1 = nums1;
        int[] arr2 = nums2;
        int[] data = new int[Math.min(nums1.length, nums2.length)];
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int indicator1 = 0;
        int indicator2 = 0;
        int indicator0 = 0;
        while (indicator1 < arr1.length && indicator2 < arr2.length) {
            if (arr1[indicator1] == arr2[indicator2]) {
                data[indicator0] = arr1[indicator1];
                indicator0++;
                indicator1++;
                indicator2++;
            } else if (arr1[indicator1] < arr2[indicator2]) {
                indicator1++;
            } else {
                indicator2++;
            }
        }
        int[] cleanData = new int[indicator0];
        for (int i = 0; i < indicator0; i++) {
            cleanData[i] = data[i];
        }
        return cleanData;
    }
}
