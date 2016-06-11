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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder.length == 0 && inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private int findPosition (int[] arr, int start, int end, int target) {
        for (int i = start; i<= end; i ++) {
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    private TreeNode helper (int[] preorder,int prestart, int preend, int[] inorder, int instart, int inend) {
        if(instart>inend){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[prestart]);
        int Position = findPosition(inorder,instart,inend, preorder[prestart]);
        root.left = helper(preorder,prestart + 1, preend-Position+instart,inorder,instart, Position-1);
        root.right = helper(preorder, Position-instart + prestart + 1, preend,inorder,Position + 1, inend);
        return root;
    }
    
    
}
