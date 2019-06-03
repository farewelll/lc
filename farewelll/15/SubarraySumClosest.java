package fifteen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumClosest {
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] data = new int[2];
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        if (nums.length == 1) {
            return new int[]{0,0};
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] sumWithIndex = new int[nums.length + 1];
        int sum = 0;
        map.put(0, -1);
        sumWithIndex[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                // 和为0 直接返回了，不用往下算了
                data[0] = map.get(sum) + 1;
                data[1] = i;
                return data;
            }
            map.put(sum, i);
            sumWithIndex[i + 1] = sum;
        }

        Arrays.sort(sumWithIndex);

        int minDiff = Integer.MAX_VALUE;
        int left = 0, right = 0;

        for (int i = 0; i < sumWithIndex.length - 1; i++) {
            if (minDiff > Math.abs(sumWithIndex[i] - sumWithIndex[i + 1])) {
                minDiff = Math.abs(sumWithIndex[i] - sumWithIndex[i + 1]);
                left = sumWithIndex[i];
                right = sumWithIndex[i + 1];
            }
        }
        // 判断两数索引位大小
        if (map.get(left) < map.get(right)) {
            data[0] = map.get(left) + 1;
            data[1] = map.get(right);
        } else {
            data[0] = map.get(right) + 1;
            data[1] = map.get(left);
        }
        return data;
    }
}
