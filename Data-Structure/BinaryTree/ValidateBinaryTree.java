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
     * @return: True if the binary tree is BST, or false
     */
    class Holder {
        boolean is_bst;
        int max, min;
        Holder(int max, int min, boolean is_bst) {
            this.is_bst = is_bst;
            this.max = max;
            this.min = min;
        }
    }
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root != null && root.left == null && root.right == null) {
            return true;
        }
        Holder result = helper(root);
        return result.is_bst;
    }
        private Holder helper(TreeNode root) {
            if (root == null) {
                return new Holder(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
            }
            Holder left = helper(root.left);
            Holder right = helper(root.right);
            int minvalue = Math.min(root.val, left.min);
            int maxvalue = Math.max(root.val, right.max);
            
            if( !left.is_bst || !right.is_bst) {
                return new Holder(0, 0,false);
            }
            if ((root.left != null && root.val <= left.max) || (root.right !=null && root.val >= right.min)){
                return new Holder(0,0,false);
            }
            return new Holder(maxvalue, minvalue,true);
             
        }
 
    }
