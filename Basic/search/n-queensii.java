class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
     //注意这里使用了全局变量sum，从而能使recursion修改sum值。
    private static int sum;
    public int totalNQueens(int n) {
        //write your code here
        if (n == 0) {
            return 0;
        }
        int[] graph = new int[n];
        sum = 0;
        helper(graph, n, 0);
        return sum;
    }
    private void helper (int[] graph, int n, int row) {
        if (row == n) {
            sum++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!isValid(graph, row, i)) {
                continue;
            }
            graph[row] = i;
            helper(graph, n, row + 1);
        }
    }
    private boolean isValid(int[] graph, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (graph[i] == col) {
                return false;
            }
            if (Math.abs(graph[i] - col) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }
}

