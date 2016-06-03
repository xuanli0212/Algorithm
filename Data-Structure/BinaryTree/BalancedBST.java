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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (isBalanced(root.left) && isBalanced(root.right)){
            int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
            return diff <= 1;
        } else {
            return false;
        }
       // write your code here
    }
    private int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
