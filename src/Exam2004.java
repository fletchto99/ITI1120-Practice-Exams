import java.util.Arrays;

public class Exam2004 {

    public static void main(final String[] args) {

        /*
         * The following code is the answer for question 5 off of http://mathieu.legault.me/resources/javacourse/CSI1100_F04_Exam.pdf
         */

        // A magical array where the sum of all the rows (individually) and all of the columns (indivisually) add up to 15
        final int[][] testArray = new int[][] { { 2, 9, 4 }, { 7, 5, 3 },
                { 6, 1, 8 } };

        // print out the sub array in a list of values, not yet properly formatted (quick and dirty answer)
        Arrays.stream(Exam2004.subMatrix(testArray, 1, 1))
                .flatMapToInt(x -> Arrays.stream(x))
                .forEach(System.out::println);

        /*
         * Should give 5,3,1,8 If it was formatted properly it would look something like {5,3} {1,8} which would be the smaller 2d array (submatrix)
         * of testArray
         */

    }

    public static int[][] subMatrix(final int[][] m, final int row,
            final int col) {

        final int[][] submatrix = new int[m.length - row][m[0].length - col];// create an array with the lengths of rows and columns of the submatrix

        // start at the indicated row and increase the index
        for (int i = row; i < m.length; i++) {
            // start at the indicated column and increase the index
            for (int j = col; j < m[i].length; j++) {
                submatrix[i - row][j - col] = m[i][j];
            }
        }
        return submatrix;
    }

}
