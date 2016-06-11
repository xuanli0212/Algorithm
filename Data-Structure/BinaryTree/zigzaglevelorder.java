/**一道非常有趣的题。
*用了两个stack来来回颠倒。
*要注意的就是这个zig zag，不仅是subtree的变换，其实在同一level的两个node也是要换顺序的。
*一开始使用仅仅subtree换顺序，发现无法实现。而后才将queue换成stack，从而可以使结果不断地倒入倒出
*/
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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> tmp;
        
        currentLevel.push(root);
        boolean normalorder = true;
        while (!currentLevel.isEmpty()){
            int size = currentLevel.size();
            ArrayList<Integer> currentList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode head = currentLevel.pop();
                currentList.add(head.val);
                if (head.left != null && normalorder){
                    nextLevel.push(head.left);
                }
                if(head.right !=null && normalorder) {
                    nextLevel.push(head.right);
                }
                 if(head.right !=null && !normalorder) {
                    nextLevel.push(head.right);
                }
                if (head.left != null && !normalorder ){
                    nextLevel.push(head.left);
                }
            }
            normalorder =!normalorder;
            result.add(currentList);
            tmp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = tmp;
        }
        return result;
    }
}
