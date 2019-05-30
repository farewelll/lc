package eleven;

public class PermutationIndex {
    public long permutationIndex(int[] A) {
        // X = a[n - 1] * (n - 1)! + a[n - 2] * (n - 2)! + ... + a[0] * 0!,
        //其中, a[i]为整数，并且0 <= a[i] <= i, 0 <= i < n, 表示当前未出现的的元素
        //中排第几个。

        // coding
        // static const int FAC[] = int [];
        //int cantor(int *a, int n)
        //{
        //	assert(n < 10);
        //	int x = 0;
        //	for (int i = 0; i < n; ++i) {
        //		int smaller = 0;
        //		for (int j = i + 1; j < n; ++j) {
        //			if (a[j] < a[i])
        //				smaller++;
        //		}
        //		x += FAC[n - i - 1] * smaller;
        //	}
        //	return x;
        //}

        //decoding
        // int decantor(int *a, int n, int k)
        //{
        //	int *num = malloc(sizeof(int) * n );
        //	int len = n;
        //	for (int i = 0; i < n; ++i)
        //		num[i] = i + 1;
        //	int cur = 0;
        //	for (int i = n - 1; i > 0; --i) {
        //		int index = k / FAC[i];
        //		k %= FAC[i];
        //		a[cur++] = num[index];
        //		listRemove(num, &len, index);
        //	}
        //	a[cur] = num[0];
        //	free(num);
        //	return 0;
        //}
        long index = 0;
        long position = 2;
        long factor = 1;
        for (int p = A.length - 2; p >= 0; p--) {
            long da = 0;
            for (int q = p + 1; q < A.length; q++) {
                if (A[p] > A[q]) {
                    da++;
                }
            }
            index = index + factor * da;
            factor = factor * position;
            position++;
        }
        return index + 1;
    }
}
