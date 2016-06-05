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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     * Divid and Conquer to solve this problem
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> path = new ArrayList<String>();
        if (root == null) {
            return path;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        if (root.left == null && root.right == null) {
            left.add(String.valueOf(root.val));
            //right.add(String.valueOf(root.val));
        }
        if (root.left != null) {
            for (int i = 0; i < left.size(); i++){
                String temp = left.get(i);
                left.set(i, String.valueOf(root.val) + "->" + temp);
            }
        }
        if (root.right != null) {
            for (int i = 0; i < right.size(); i++) {
                String temp = right.get(i);
                right.set(i, String.valueOf(root.val) + "->" + temp);
            }
        }
        path.addAll(left);
        path.addAll(right);
        return path;
    }
}
