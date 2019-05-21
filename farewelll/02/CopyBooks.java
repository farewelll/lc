package two;

public class CopyBooks {
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int bookNum = pages.length;
        if (bookNum == 0 || pages == null) {
            return 0;
        }

        if (k > bookNum) {
            k = bookNum;
        }
        int[] sum = new int[bookNum];
        sum[0] = pages[0];
        for (int i = 1; i < bookNum; ++i) {
            // 求总页数
            sum[i] = sum[i - 1] + pages[i];
        }
        int[][] f = new int[bookNum][k];
        for (int i = 0; i < bookNum; ++i)
            // 人数为1的时候，时间等于每本书页数和
            f[i][0] = sum[i];
        for (int j = 1; j < k; ++j) {
            int p = 0;
            f[0][j] = pages[0];
            for (int i = 1; i < j; ++i)
                f[i][j] = Math.max(f[i - 1][j], pages[i]);
            for (int i = j; i < bookNum; ++i) {
                while (p < i && f[p][j - 1] < sum[i] - sum[p])
                    ++p;
                f[i][j] = Math.max(f[p][j - 1], sum[i] - sum[p]);
                if (p > 0) {
                    --p;
                }
                f[i][j] = Math.min(f[i][j], Math.max(f[p][j - 1], sum[i] - sum[p]));
            }
        }
        return f[bookNum - 1][k - 1];
    }
    public static void main(String []args){
        int [] num = new int[4];
        num[0] = 2;
        num[1] = 4;
        num[2] = 5;
        num[3] = 8;
        System.out.println(num.length);
    }
}
