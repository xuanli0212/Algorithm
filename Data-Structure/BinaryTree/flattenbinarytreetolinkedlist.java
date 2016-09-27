/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) return;
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        helper(root, result);
        TreeNode cur = root;
        for (int i = 1; i < result.size() ; i++) {
            cur.right = result.get(i);
            cur.left = null;
            cur = cur.right;
        }
    }
    private void helper(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        helper(root.left, list);
        helper(root.right, list);
    }
}

//Method2
