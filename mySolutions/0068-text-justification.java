import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();

        //to builder the string for each line, set sb back to empty each time after
        StringBuilder sb = new StringBuilder();

        //iterate on String[] words, i means the ith words in the array
        int i = 0;

        //accumulate when number of words in each line increment by 1
        int numWords = 0;


        while (i < words.length) {

            //determine if to add a word to a line, or to justify the line
            if (sb.length() == 0) {
                sb.append(words[i]);
                i++;
                numWords++;
            } else if (sb.length() + 1 + words[i].length() <= maxWidth) {
                sb.append(" ").append(words[i]);
                i++;
                numWords++;
            } else {

                int extraSpaces = maxWidth - sb.length();

                //determine if the line contains more than one words
                if(numWords > 1) {
                    int spaceToAdd = extraSpaces / (numWords - 1);
                    int remainder = extraSpaces % (numWords - 1);
                    int j = 0;
                    while (extraSpaces > 0) {
                        if(sb.charAt(j) == ' ') {
                            sb.insert(j, " ".repeat(spaceToAdd));
                            extraSpaces -= spaceToAdd;
                            j += spaceToAdd;

                            if(remainder > 0) {
                                sb.insert(j, " ");
                                remainder --;
                                extraSpaces --;
                                j += 1;
                            }
                        }

                        j ++;

                    }

                } else if(numWords == 1){
                    sb.append(" ".repeat(extraSpaces));
                }

                numWords = 0;

                list.add(sb.toString());
                sb.setLength(0);
            }
        }

        //the last line remains to justify(add trailing spaces)
        if (sb.length() > 0) {
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            list.add(sb.toString());
        }

        return list;
    }
}
