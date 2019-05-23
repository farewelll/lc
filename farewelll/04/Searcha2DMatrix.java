package four;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int rowkai = 0, rowjie = row - 1;
        while (rowkai + 1 < rowjie) {
            int mid = rowkai + (rowjie - rowkai) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                rowkai = mid;
            } else {
                rowjie = mid;
            }
        }
        if (matrix[rowjie][0] <= target) {
            row = rowjie;
        } else if (matrix[rowkai][0] <= target) {
            row = rowkai;
        } else {
            return false;
        }

        // find the column index, the number equal to target
        int colkai = 0;
        int coljie = column - 1;
        while (colkai + 1 < coljie) {
            int mid = colkai + (coljie - colkai) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                colkai = mid;
            } else {
                coljie = mid;
            }
        }
        if (matrix[row][colkai] == target) {
            return true;
        } else if (matrix[row][coljie] == target) {
            return true;
        }
        return false;
    }
}

