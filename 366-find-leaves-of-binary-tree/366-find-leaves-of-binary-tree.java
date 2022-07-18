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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<Integer>[] leaves = new ArrayList[100];
        int height = dfs(leaves, root);
        return new ArrayList(Arrays.asList(leaves).subList(0, height));
    }
    
    private int dfs(List<Integer>[] leaves, TreeNode root) {
        int height = 0;
        if (root.left != null) {
            height = dfs(leaves, root.left);
        }
        if (root.right != null) {
            height = Math.max(height, dfs(leaves, root.right));
        }
        if (leaves[height] == null) {
            leaves[height] = new ArrayList(Arrays.asList(root.val));
        } else {
            leaves[height].add(root.val);
        }
        return height + 1;
    }
}