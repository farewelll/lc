package twentythree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                else {
                    return b[1] - a[1];
                }
            }
        });
        List<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < envelopes.length; i++) {
            if (data.size() == 0 || data.get(data.size() - 1) < envelopes[i][1]) {
                data.add(envelopes[i][1]);
            }
            else {
                int begin = 0;
                int end = data.size() - 1;
                while (begin <= end) {
                    int mid = begin + (end - begin) / 2;
                    if (data.get(mid) < envelopes[i][1]) {
                        begin = mid + 1;
                    }
                    else if (data.get(mid) > envelopes[i][1]) {
                        end = mid - 1;
                    }
                    else {
                        begin = mid;
                        break;
                    }
                }
                data.set(begin, envelopes[i][1]);
            }
        }

        return data.size();
    }
}
