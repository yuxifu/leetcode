/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-22
 */
/*
   Given a m x n matrix, if an element is 0, set its entire row and column to
   0. Do it in place.
   Follow up:
   Did you use extra space?
   A straight forward solution using O(mn) space is probably a bad idea.
   A simple improvement uses O(m + n) space, but still not the best solution.
   Could you devise a constant space solution?

   Solution: Use first row and column as auxiliary spaces instead of newly
   allocating ones.
 */

import java.util.*;

public class SetMatrixZeroes {

//time: O(m * n)
//space: O(1)
public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m <= 0) return;
        int n = matrix[0].length; //# columns

        boolean row_has_zero = false;
        boolean col_has_zero = false;

        for(int j=0; j<n; j++) {
                if(matrix[0][j]==0) {
                        row_has_zero = true;
                        break;
                }
        }
        for(int i=0; i<m; i++) {
                if(matrix[i][0]==0) {
                        col_has_zero = true;
                        break;
                }
        }

        for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                        if(matrix[i][j]==0) {
                                matrix[0][j] =0;
                                matrix[i][0] =0;
                        }
                }
        }
        for (int i = 1; i < m; i++)
                for (int j = 1; j < n; j++)
                        if (matrix[i][0] == 0 || matrix[0][j] == 0)
                                matrix[i][j] = 0;

        if (row_has_zero)
                for (int i = 0; i < n; i++)
                        matrix[0][i] = 0;
        if (col_has_zero)
                for (int i = 0; i < m; i++)
                        matrix[i][0]=0;

}

// debug
public static void main(String[] args) {
        SetMatrixZeroes s = new SetMatrixZeroes();
        int[][] array = new int[][] {{1,2,3},{4,5,6},{7,0,9}};
        s.setZeroes(array);
        System.out.println(Arrays.deepToString(array));
}

}
