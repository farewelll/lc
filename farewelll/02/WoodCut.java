package two;

public class WoodCut {
    public int woodCut(int[] L, int k) {

        int l = 1;
        int length = 0;
        int cur = 0;
        for (int item : L) {
            cur = Math.max(cur, item);//取出数组中最大值。
        }

        while (l <= cur) {
            int mid = l + (cur - l) / 2;
            if (count(L, mid) >= k) {
                // 能取出来，依次加长小段长度。
                length = mid;
                l = mid + 1;
            } else {
                // 取不出来，减小取小段的参照物的长度。
                cur = mid - 1;
            }
        }

        return length;
    }

    private int count(int[] L, int len) {
        int sum = 0;
        for (int item : L) {
            // 判断能取出小段的数量。
            sum += item / len;
        }
        return sum;
    }
}
