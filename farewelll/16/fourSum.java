package sixteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // write your code here
        List<List<Integer>> data = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return data;
        }

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int l = j + 1, r = n - 1; l < r; ++l) {
                    if (l > j + 1 && nums[l] == nums[l - 1]) {
                        continue;
                    }
                    while (r > l && nums[i] + nums[j] + nums[l] + nums[r] > target) {
                        r--;
                    }
                    if (l >= r) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[l]);
                        item.add(nums[r]);
                        data.add(item);
                    }
                }
            }
        }
        return data;
    }
}
