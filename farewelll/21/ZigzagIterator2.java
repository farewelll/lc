package twentyone;

import java.util.List;

public class ZigzagIterator2 {
    private final List<List<Integer>> data;
    private int index = 0;

    /*
     * @param vecs: a list of 1d vectors
     */
    public ZigzagIterator2(List<List<Integer>> vecs) {
        // do intialization if necessary
        this.data = vecs;
        for (int i = 0; i < data.size(); i++) {
            List<Integer> list = data.get(i);
            if (list == null || list.isEmpty()) {
                data.remove(i);
                i--;
            }
        }
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        if (index >= data.size()) {
            index = 0;
        }
        List<Integer> list = data.get(index);
        int value = list.remove(0);
        if (list.isEmpty()) {
            data.remove(index);
        } else {
            index++;
        }
        return value;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return !data.isEmpty();
    }
}