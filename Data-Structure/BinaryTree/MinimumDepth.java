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
 /**Solution 1:
 *  no helper function, use if for condition.
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        int depth = 0;
        if (root == null){
          return depth; 
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.right == null && root.left != null) {
            depth = left + 1;
        } else if(root.left == null && root.right != null) {
            depth = right + 1;
        }else {
        depth = Math.min(left,right) + 1;
        }
        return depth;
    }
}

/** Solution 2:
* Use helper function, so that you can initialize the null case to MAX_VALUE. then it won't affect the Math.min comparision.
*/

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }
    public int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int left = getMin(root.left);
        int right = getMin(root.right);
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(left, right) + 1;
    }
}
