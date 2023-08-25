import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> res = new LinkedList<>();

        for(String directory : path.split("/")) {
            if(directory.equals("") || directory.equals(".")) {
                continue;
            } else if(directory.equals("..")) {
                if(res.size() > 0) {
                    res.removeLast();
                }
            } else {
                res.addLast(directory);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String directory : res) {
            sb.append("/").append(directory);
        }
        return res.size() == 0 ? "/" : sb.toString();
    }
}
