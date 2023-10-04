/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) {
            return null;
        }

        Node pointer = head;


        // Inserting the new nodes to the original nodes.
        while (pointer != null) {

            Node newNode = new Node(pointer.val);

            newNode.next = pointer.next;
            pointer.next = newNode;
            pointer = newNode.next;
        }

        pointer = head;

        // Link new nodes with random pointers.
        while(pointer != null) {

            pointer.next.random = (pointer.random != null) ? pointer.random.next : null;
            pointer = pointer.next.next;
        }

        Node pointerOldList = head;
        Node pointerNewList = head.next;
        Node headNew = head.next;

        while(pointerOldList != null) {
            pointerOldList.next = pointerOldList.next.next;
            pointerNewList.next = (pointerNewList.next != null) ? pointerNewList.next.next : null;
            pointerOldList = pointerOldList.next;
            pointerNewList = pointerNewList.next;
        }

        return headNew;
    }
}
