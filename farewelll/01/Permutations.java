import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    //全排列，递归方法解决，目前时间复杂度是n的阶乘
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> data = new ArrayList<>();
        if (nums.length == 0){
            data.add(new ArrayList<>());
        }else {
            getArregument(nums, 0, data);
        }
        return data;
    }

    private static void getArregument(int[] nums, int index, List<List<Integer>> data) {

        for (int i = index; i < nums.length; i++) {
            if (index == nums.length - 1) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    list.add(nums[j]);
                }
                data.add(list);
            }
            swap(nums, i, index);
            getArregument(nums, index + 1, data);
            swap(nums, i, index);
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
