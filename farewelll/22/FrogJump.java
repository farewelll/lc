package twentytwo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FrogJump {
    public boolean canCross(int[] stones) {
        // write your code here
        if (stones == null || stones.length == 0){
            return false;
        }
        if (stones.length<= 2){
            return true;
        }
        int len = stones.length;
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i ++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(1);
        for (int i = 0; i < len - 1; i ++) {
            for (int step : map.get(stones[i])) {
                int to = step + stones[i];
                if (to == stones[len - 1]) {
                    return true;
                }
                HashSet<Integer> tmp = map.get(to);
                if (tmp != null) {
                    tmp.add(step);
                    if (step > 1) {
                        tmp.add(step - 1);
                    }
                    tmp.add(step + 1);
                }
            }
        }
        return false;
    }
}
