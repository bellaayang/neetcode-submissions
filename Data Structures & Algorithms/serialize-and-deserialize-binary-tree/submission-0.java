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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        seralizeDFS(root, res);
        return String.join(",", res);
        
    }

     private void seralizeDFS (TreeNode node, List<String> res) {
        if (node == null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(node.val));
        seralizeDFS(node.left, res);
        seralizeDFS(node.right, res);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = {0};

        return deserializeDFS(vals, i);
        
    }

    private TreeNode deserializeDFS (String[] vals, int[] i) {
        if (vals[i[0]].equals("N")) {
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = deserializeDFS(vals, i);
        node.right = deserializeDFS(vals, i);

        return node;
    }
}
