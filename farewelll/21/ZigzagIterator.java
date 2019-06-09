package twentyone;

import java.util.List;

public class ZigzagIterator {
    private boolean flag = false;
    private List<Integer> v1;
    private List<Integer> v2;

    /*
     * @param v1: A 1d vector
     * @param v2: A 1d vector
     */
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        this.v1 = v1;
        this.v2 = v2;
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        if (v1.isEmpty()) {
            return v2.remove(0);
        } else if (v2.isEmpty()) {
            return v1.remove(0);
        } else {
            flag = !flag;
            if (flag) {
                return v1.remove(0);
            } else {
                return v2.remove(0);
            }
        }
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return v1.size() != 0 || v2.size() != 0;
    }}