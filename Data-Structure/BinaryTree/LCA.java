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
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        //TreeNode ancestor = new TreeNode();
        if (root == null ){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if(root == A || root == B){
            return root;
        }
        if(left != null && right != null){
            return root;
        } else if(left != null) {
            return left;
        } else if(right != null) {
            return right;
        } else {
            return null;
        }
        
    }
}

/** Second Solution if have parent pointer*/
/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here   
        ArrayList<ParentTreeNode> pathA = getPath(A);
        ArrayList<ParentTreeNode> pathB = getPath(B);
        for (int i = 0; i < pathA.size() ; i++ ){
            for (int j = 0; j < pathB.size(); j++){
                if(pathA.get(i).val == pathB.get(j).val){
                    return pathA.get(i);
                }
            }
        }
        return null;
    }
    // Get the path from root to current node.
    public ArrayList<ParentTreeNode> getPath(ParentTreeNode root){
        ArrayList<ParentTreeNode> path = new ArrayList<ParentTreeNode>();
        if (root == null ){  
            return path;
        }
        while(root != null ){
            path.add(root);
            root = root.parent;
        }
        return path;
    }
}
