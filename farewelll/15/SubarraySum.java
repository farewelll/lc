package fifteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubarraySum {
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> data = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return data;
        }

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                data.add(map.get(sum));
                data.add(i);
                return data;
            }
            map.put(sum, i + 1);
        }
        return data;
    }
}
