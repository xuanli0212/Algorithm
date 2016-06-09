/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode succesor = null; 
        if (root == null ){
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        
        while ( root != null && root.val != p.val) {
            if (root.val > p.val){
                succesor = root;
                root = root.left;
            }else {
                root = root.right;
            }
        }
        if (root.right == null){
            return succesor;
        }
        root = root.right;
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
}
