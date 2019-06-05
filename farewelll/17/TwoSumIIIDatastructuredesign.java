package seventeen;

import java.util.HashMap;

public class TwoSumIIIDatastructuredesign {
    private HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void add(int number) {
        if (data.containsKey(number)) {
            data.put(number, data.get(number) + 1);
        } else {
            data.put(number, 1);
        }
    }

    public boolean find(int value) {
        for (Integer i : data.keySet()) {
            int target = value - i;
            if (data.containsKey(target)) {
                if (i == target && data.get(target) < 2) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}
