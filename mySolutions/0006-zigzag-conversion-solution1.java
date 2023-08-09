class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        //sections, starting from 1
        int section = s.length() / (2 * numRows - 2) + 1;

        int numColumns = (numRows - 1) * section;

        char[][] matrix = new char[numRows][numColumns];


        //fill the matrix with Zigzag chars
        for(int n = 0; n < s.length(); n ++) {
            int currentSec = n / (2 * numRows - 2);
            int posInSec = n % (2 * numRows - 2);

            if(posInSec >= 0 && posInSec <= numRows - 1) {
                int row = posInSec;
                int column = currentSec * (numRows - 1);
                matrix[row][column] = s.charAt(n);
            } else {
                int row = (numRows - 1) - (posInSec - (numRows - 1));
                int column = (currentSec + 1) * (numRows - 1) - row;
                matrix[row][column] = s.charAt(n);
            }
        }

        //iterate matrix get the output
        String output = "";

        for(int y = 0; y < numRows; y ++) {
            for(int x = 0; x < numColumns; x ++) {
                if(matrix[y][x] != 0) {
                    output += matrix[y][x];
                }
            }
        }

        return output;
    }
}
