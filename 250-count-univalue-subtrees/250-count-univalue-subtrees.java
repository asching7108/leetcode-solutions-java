/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root != null) {
            isUnival(root);
        }
        return count;
    }
    private boolean isUnival(TreeNode root) {
        boolean unival = true;
        if (root.left != null) {
            unival = isUnival(root.left) && root.val == root.left.val && unival;
        }
        if (root.right != null) {
            unival = isUnival(root.right) && root.val == root.right.val && unival;
        }
        if (unival) {
            count++;
        }
        return unival;
    }
}