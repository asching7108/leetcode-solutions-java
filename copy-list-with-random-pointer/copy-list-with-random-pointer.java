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
        if (head == null) {
            return null;
        }
        Node curr = head;
        // inserts a new node after every original node
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        curr = head;
        // updates the random pointers of new nodes
        while (curr != null) {
            Node newNode = curr.next;
            if (curr.random != null) {
                newNode.random = curr.random.next;
            }
            curr = newNode.next;
        }
        curr = head;
        Node newHead = head.next, curr2 = newHead;
        // separates original and new set of nodes
        while (curr != null) {
            curr.next = curr.next.next;
            curr = curr.next;
            if (curr != null) {
                curr2.next = curr2.next.next;
                curr2 = curr2.next;
            }
        }
        return newHead;
    }
}