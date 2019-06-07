package nineteen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            if (!set.contains(num[i])) {
                set.add(num[i]);
                queue.offer(num[i]);
            }
        }

        int max = 1;
        int cur = 1;
        int start = queue.poll();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == start + 1) {
                start = curr;
                cur++;
            } else {
                cur = 1;
                start = curr;
            }
            max = Math.max(max, cur);
        }

        return max;
    }
}
