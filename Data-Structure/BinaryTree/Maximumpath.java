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
    private class Holder{
        int smaxpath;
        int maxpath;
        Holder(int smaxpath,int maxpath){
            this.smaxpath = smaxpath;
            this.maxpath = maxpath;
        }
    }
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
       if (root == null){
           return 0; 
       }
       Holder result = helper(root);
       return result.maxpath;
       
    }
    public Holder helper(TreeNode root){
        if (root == null){
            return new Holder (Integer.MIN_VALUE,Integer.MIN_VALUE);
        }
        Holder left = helper (root.left);
        Holder right = helper(root.right);
        
        int smaxpath = Math.max(0, Math.max(left.smaxpath,right.smaxpath))+root.val;
        int maxpath = Math.max(left.maxpath,right.maxpath);
        maxpath = Math.max(maxpath, Math.max(left.smaxpath,0)+Math.max(right.smaxpath,0)+root.val);
        return new Holder(smaxpath,maxpath);
    }
}
