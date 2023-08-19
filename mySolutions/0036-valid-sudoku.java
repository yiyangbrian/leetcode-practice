import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> container = new HashSet<>();

        //investigate each line
        for(char[] line : board) {
            for(int i = 0; i < 9; i ++) {
                if(line[i] != '.' && container.contains(line[i])) {
                    return false;
                } else if(line[i] != '.') {
                    container.add(line[i]);
                }


                if(i == 8) {
                    container.clear();
                }
            }
        }



        //investigate each column
        for(int i = 0; i < 9; i ++) {
            for(int j = 0; j < 9; j ++) {
                char num = board[j][i];
                if(num != '.' && container.contains(num)) {
                    return false;
                } else if(num != '.') {
                    container.add(num);
                }



                if(j == 8) {
                    container.clear();
                }
            }
        }


        for(int x = 0; x < 9; x += 3) {
            for(int y = 0; y < 9; y += 3) {

                int iterator = 0;
                for(int i = x; i < x + 3; i ++) {
                    for(int j = y; j < y + 3; j ++) {
                        char num = board[j][i];
                        System.out.println(num);

                        if(num != '.' && container.contains(num)) {
                            return false;
                        } else if(num != '.') {
                            container.add(num);
                        }
                        iterator ++;

                        System.out.println(container);

                        if(iterator == 9) {
                            container.clear();
                        }
                    }
                }

            }
        }

        return true;

    }
}
