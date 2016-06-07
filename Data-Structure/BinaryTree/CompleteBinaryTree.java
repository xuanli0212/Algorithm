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
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    class Holder {
        int depth;
        boolean is_full;
        boolean is_complete;
        Holder(int depth, boolean is_full, boolean is_complete) {
            this.depth = depth;
            this.is_full = is_full;
            this.is_complete = is_complete;
        }
    }
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true; 
        }
        Holder results = helper(root);
        return results.is_complete;
    }
    public Holder helper(TreeNode root) {
        if (root == null) {
            return new Holder(1, true, true);
        }
        Holder left = helper(root.left);
        Holder right = helper(root.right);

        if (!left.is_complete || !right.is_complete) {
            return new Holder(0, false, false);
        }
        if (left.depth == right.depth) {
            if (left.is_full) {
                return new Holder(left.depth + 1, right.is_full, true);
            } else {
                return new Holder(0, false, false);
            }
        }
        if (left.depth == right.depth + 1) {
            if (right.is_full) {
                return new Holder(left.depth + 1, false, true);
            } else {
                return new Holder(0, false, false);
            }
        }
        return new Holder(0, false, false);
    }
}
