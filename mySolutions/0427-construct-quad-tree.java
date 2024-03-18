/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    // grid[row][col] represents the most topleft grid in the current submatrix
    private Node recurse(int[][] grid, int row, int col, int length) {
        if(length == 0) {
            return null;
        }
        if(length == 1) {
            boolean val = grid[row][col] == 1 ? true : false;
            return new Node(val, true);
        }
        Node topLeft = recurse(grid, row, col, length / 2);
        Node topRight = recurse(grid, row, col + length / 2, length / 2);
        Node bottomLeft = recurse(grid, row + length / 2, col, length / 2);
        Node bottomRight = recurse(grid, row + length / 2, col + length / 2, length / 2);

        if(((topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) ||
                (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val)) &&
                (topLeft.topLeft == null && topRight.topLeft == null && bottomLeft.topLeft == null && bottomLeft.topLeft == null))  {
            return new Node(topLeft.val, true);
        } else {
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    public Node construct(int[][] grid) {
        return recurse(grid, 0, 0, grid.length);
    }
}
