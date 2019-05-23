package four;

public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        // write your code here
        int hang = image.length - 1;
        int lie = image[0].length - 1;
        int hangxiao = hang;
        int hangda = 0;
        int liexiao = lie;
        int lieda = 0;
        for (int i = 0 ; i <= hang ; i ++){
            for (int j = 0 ; j <= lie ; j ++){
                if (image[i][j] == '1'){
                    if (i < hangxiao) hangxiao = i;
                    if (i > hangda) hangda = i;
                    if (j < liexiao) liexiao = j;
                    if (j > lieda) lieda = j;
                }
            }
        }
        return (hangda - hangxiao + 1)*(lieda - liexiao + 1);
    }
    public static void main(String[] args){

    }
}
