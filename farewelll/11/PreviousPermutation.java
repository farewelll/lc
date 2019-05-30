package eleven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreviousPermutation {
    public List<Integer> previousPermuation(List<Integer> nums) {
        List<Integer> data = new ArrayList<Integer>();
        if (nums == null || nums.isEmpty()) return data;
        boolean flag = false;
        data.add(nums.get(nums.size() - 1));
        for (int i = nums.size() - 2; i >= 0; i--) {
            if (!flag && (nums.get(i) > nums.get(i + 1))) {
                flag = true;
                int temp = 0;
                for (int j = 0; j < data.size(); j++) {
                    if (data.get(j) < nums.get(i)) {
                        temp = data.get(j);
                        data.set(j, nums.get(i));
                        break;
                    }
                }
                Collections.reverse(data);
                data.add(temp);
            } else {
                data.add(nums.get(i));
            }
        }
        if (flag) {
            Collections.reverse(data);
        }
        return data;
    }
}
