class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (n == 0) {
            return result;
        }
        int[] graph = new int[n];
        helper(result, graph, 0, n);
        return result;
    }
    
    /**
     * helper function for DFS recursion.
     */
    private void helper (ArrayList<ArrayList<String>> result, int[] graph, int row, int n) {
       //注意这里是row==n而不是n-1,因为recursion是 row + 1了。
        if (row == n) {
            ArrayList<String> list = arrayToString(graph);
            result.add(list);
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(graph, row, i)) {
                continue;
            }
            graph[row] = i;
            //注意是row + 1，相当于填满一行，再往下一行。
            helper(result, graph, row + 1, n);
            graph[row] = 0;
        }    
    }
    
    //translate int[] graph to the required format
    private ArrayList<String> arrayToString(int[] graph) {
        int n = graph.length;
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < n; i++) {
           StringBuilder str = new StringBuilder(n);
           for (int j = 0; j < n; j++) {
               if (j == graph[i]) {
                   str.append("Q");
               } else {
                   str.append(".");
               }
           }
           result.add(str.toString());
        }
        return result;
    }
    /**
     * Test if current graph has no conflict queens
    */
    private boolean isValid(int[] graph, int rowNum, int colNum) {
        //注意这里是小于rowNum，就好像3，2，1相互比较，是比较两次。所以是返回比较。不需要==rowNum
        for (int i = 0; i < rowNum; i++) {
            //不能出现在同一列
            if (graph[i] == colNum) {
                return false;
            }
            //不能出现在对角线
            if (Math.abs(rowNum - i) == Math.abs(colNum - graph[i])) {
                return false;
            }
        }
        return true;
    }
};
