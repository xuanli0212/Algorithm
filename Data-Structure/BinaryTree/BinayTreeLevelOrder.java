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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> tree = new LinkedList<TreeNode>();
        tree.offer(root);
        
        while( !tree.isEmpty()) {
            ArrayList<Integer> layer = new ArrayList<Integer>();
            int size = tree.size();
            for (int i = 0; i < size; i++) {
                TreeNode first = tree.poll();
                layer.add(first.val);
                if (first.left != null) {
                    tree.offer(first.left);
                }
                if(first.right != null) {
                    tree.offer(first.right);
                }
            }
             result.add(layer);
        }
        return result; 
    }
    
}
