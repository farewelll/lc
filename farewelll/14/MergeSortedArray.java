package fourteen;

public class MergeSortedArray {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int a = m - 1 ;
        int b = n - 1 ;
        int current = a + b + 1;
        while(a >=0 && b >= 0){
            // 从屁股后面往前依次插值，省着移位了
            if (A[a] > B[b]){
                A[current] = A[a];
                a --;
                current --;
            } else {
                A[current] = B[b];
                b --;
                current --;
            }
        }
        while(a >= 0){
            A[current] = A[a];
            a --;
            current --;
        }while(b >= 0){
            A[current] = B[b];
            b --;
            current --;
        }
    }
}
