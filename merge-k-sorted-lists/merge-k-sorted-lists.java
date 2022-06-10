/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode ln1, ListNode ln2) {
                return ln1.val - ln2.val;
            }
        };
        Queue<ListNode> pq = new PriorityQueue(cmp);
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode root = new ListNode(0), curr = root;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = new ListNode(node.val);
            curr = curr.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return root.next;
    }
}
