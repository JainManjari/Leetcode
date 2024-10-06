import java.util.LinkedHashSet;

class NumMatrix {

    int matrix[][];
    int preCompute[][];

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        int pract[][] = new int[m+1][n+1];


        for (int i = 0; i < m; i++) {
            int prefix = 0;
            for (int j = 0; j < n; j++) {
                prefix+=matrix[i][j];
                pract[i+1][j+1] = prefix + pract[i][j+1];
            }
        }

        this.preCompute = new int[m+1][n+1];
        this.preCompute = pract;

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preCompute[row2+1][col1+1-1]-preCompute[row2+1][col2+1]-(preCompute[row1+1-1][col2+1]-preCompute[row1+1-1][col1+1-1]);
    }
}

public class TwoDRangeSum {
    public static void main(String[] args) {
        int matrix[][] ={{1,1,1,1,1,1,1},{1,1,1,1,1,1,1},{3,0,1,4,2,1,1},{5,6,3,2,1,1,1},{1,2,0,1,5,1,1},{4,1,0,1,7,1,1},{1,0,3,0,5,1,1}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        numMatrix.sumRegion(2,2,4,4);
        String s = "";
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for(Integer i:linkedHashSet) {

        }

    }
}
