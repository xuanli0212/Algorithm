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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        ArrayList<Integer> leftList = preorderTraversal(root.left);
        ArrayList<Integer> rightList = preorderTraversal(root.right);
        //result.add(root.val);
        result.addAll(leftList);
        result.addAll(rightList);
        return result;
    }
}
