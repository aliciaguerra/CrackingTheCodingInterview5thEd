/*1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.*/

/*At first glance, this problem seems easy, we just iterate through the matrix and every time we see a cell with
a value zero, set its row and column to zero. There's one problem with that solution though: when we come across other cells
in that row or column, we'll see the zeros and change their row and column to zero. Pretty soon, our entire matrix will
be set to zeros. 

One way around this is to keep a second matrix which flags the zero locations. We would then do a second pass through the
matrix to set the zeros. This would take O(MN) space. 

Do we really need O(MN) space? No. Since we're going to set the entire row and column to zero, we don't need to track that
it was exactly cell[2][4] (row 2, column 4). We only need to know that row 2 has a zero somewhere, and column 4 has a 
zero somewhere. We'll set the entire row and column to zero anyway, so why would we care to keep track of the exact location
of the zero?

The code implements this algorithm. We use two arrays to keep track of all the rows with zeros. We then nullify rows and 
columns based on the values in these arrays. */

public void setZeros(int[][] matrix) {
 boolean[] row = new boolean[matrix.length];
 boolean[] column = new boolean[matrix[0].length];
 
 //Store the row and column index with value 0
 for(int i=0; i<matrix.lenth; i++) {
  for(int j=0; j<matrix[0].length; j++) {
   if(matrix[i][j] == 0) {
   row[i] = true;
   column[j] = true;
     }
    }
  }
  
  //Nullify rows
  for(int i=0; i<row.length; i++) {
   if(row[i]) nullifyRow(matrix, i);
   }
   
  //Nullify columns
  for(int j=0; j<column.length; j++) {
   if(column[j]) nullifyColumn(matrix, j);
     }
  }
  
  public void nullifyRow(int[][] matrix, int row) {
   for(int j=0; j<matrix[0].length; ++i) {
     matrix[row][j] = 0;
       }
    }
    
  public void nullifyColumn(int[][] matrix, int col) {
   for(int i=0; i<matrix.length; i++) {
    matrix[i][col] = 0;
       }
    }
  
/**To make this somewhat more space efficient, we could use a bit vector instead of a boolean array. 
It will still be O(N). */

/*We can reduce the space to O(1) by using the first row as a replacement for the row array and the
first column as a replacement for the column array. This works as follows:
1. Check if the first row and the first column have any zeros, and set variables rowHasZero and columnHasZero
(We'll nullify the first row and first column later, if necessary).
2. Iterate through the rest of the matrix , setting matrix[i][0] and matrix[0][j] to zero wherever there's a
matrix [i][j].
3. Iterate through rest of the matrix, nullifying row i if there's a zero in matrix[i][0].
4. Iterate through the rest of the matrix, nullifying column j if there's a zero in matrix[0][j].
5. Nullify the first row and first column, if necessary.

*/
