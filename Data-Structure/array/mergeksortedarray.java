public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (arrays == null ) {
            return result;
        }
        Comparator<Node> NodeComparator = new Comparator<Node>(){
           public int compare(Node a, Node b) {
               return a.val - b.val;
           }
        }; 
        Queue<Node> heap = new PriorityQueue<Node>(arrays.length, NodeComparator);
       
       // add the first col of values into heap
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                heap.add(new Node(i, 0, arrays[i][0]));
            }
        }
        // Pop up the top node from head and add the following one into heap
        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            result.add(cur.val);
            if (cur.col + 1 < arrays[cur.row].length) {
                heap.add(new Node(cur.row, cur.col + 1, arrays[cur.row][cur.col + 1]));
            }
        }
      return result;  
    }
   
}
class Node {
    public int row;
    public int col;
    public int val;
    Node(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
