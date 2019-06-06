package eighteen;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    Integer cur;

    Deque<Iterator<NestedInteger>> dq = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        dq.push(nestedList.iterator());
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        if (!hasNext()){
            return null;
        }
        Integer ans = cur;
        cur = null;
        return ans;
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while (cur == null && !dq.isEmpty()){
            Iterator<NestedInteger> it = dq.peek();
            if (!it.hasNext()){
                dq.pop();
                continue;
            }
            NestedInteger ni = it.next();
            if (ni.isInteger()){
                cur = ni.getInteger();
                break;
            } else {
                dq.push(ni.getList().iterator());
            }
        }
        return cur != null;
    }

    @Override
    public void remove() {}
}
