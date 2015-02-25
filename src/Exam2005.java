import java.util.stream.IntStream;

public class Exam2005 {

    /*
     * The following code is the answer for question 5 off of http://mathieu.legault.me/resources/javacourse/Exam2005.pdf
     */

    public static boolean isMagic(final int[][] a) {
        final int[][] a_transpose = new int[a[0].length][a.length]; // The transposed array for summination of columns

        final int shouldEqual = IntStream.of(a[0]).sum(); // The sum of the first row, which all sums should equal

        // Check the sum of all the rows in the 2d array
        for (final int[] element : a) {
            if (IntStream.of(element).sum() != shouldEqual) {// if the row doesn't equal the sum of the initial row then fail
                return false;
            }
        }

        // Ideally transpose would be another method which could be reused in other parts of code. But for simplicitiy's sake I added it directly into
        // this method
        // transpose the array, [i,j] index is now [j,i]
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                a_transpose[i][j] = a[j][i];
            }
        }

        // check the sum of all of the arrows in the transposed array
        for (final int[] element : a) {
            if (IntStream.of(element).sum() != shouldEqual) { // if the transposed column doesn't equal the sum then fail
                return false;
            }
        }
        return true;
    }

    public static void main(final String[] args) {
        // A magical array where the sum of all the rows (individually) and all of the columns (indivisually) add up to 15
        final int[][] magicalArray = new int[][] { { 2, 9, 4 }, { 7, 5, 3 },
                { 6, 1, 8 } };

        // test if the array is magical
        System.out.println(Exam2005.isMagic(magicalArray));
    }

}
