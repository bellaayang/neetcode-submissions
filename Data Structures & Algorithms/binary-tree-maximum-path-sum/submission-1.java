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
    public int maxPathSum(TreeNode root) {
         int[] res = new int[1];
        res[0] = root.val;
        dfs(root, res);
        return res[0];
        
    }

    private int dfs (TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max (dfs(node.left, res), 0);
        int rightMax = Math.max(dfs(node.right, res), 0);

        res[0] = Math.max(res[0], leftMax + rightMax + node.val);
        return Math.max(leftMax, rightMax) + node.val;
    }
}
