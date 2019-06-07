package nineteen;

import java.util.Arrays;

public class MergeKSortedArrays {
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        int row = arrays.length;
        int col = arrays[0].length;

        int index = 0;
        int sum = 0;
        for (int i = 0 ; i < arrays.length ; i ++){
            sum = sum + arrays[i].length;
        }
        int []newArray = new int[sum];
        for (int i = 0; i < row ; i ++){
            for (int j = 0 ; j < arrays[i].length ; j ++){
                newArray[index] = arrays[i][j];
                index ++;
            }
        }
        Arrays.sort(newArray);
        return newArray;
    }
}
