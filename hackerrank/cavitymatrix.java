import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][n];
        int row = 0;
        while (sc.hasNextLine()) {
            String oneLine = sc.nextLine();
            for (int i = 0; i < n; i++) {
                matrix[row][i] = oneLine.charAt(i) - '0';
            }
            row++;
        }       
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int maxAdj = Math.max(Math.max(matrix[i -1][j],matrix[i + 1][j]),Math.max(matrix[i][j - 1], matrix[i][j + 1]));
                if (maxAdj < matrix[i][j]) {
                    matrix[i][j] = 101;
                }
            }
        }
       for (int i = 0; i < n ; i++) {
           StringBuilder str = new StringBuilder();
            for (int j = 0; j < n ; j++) {
                if (matrix[i][j] == 101) {
                    str.append("X");
                    continue;
                }
                str.append(Integer.toString(matrix[i][j]));
            }
           System.out.println(str.toString());                         
       }
    }
                                                                        
}
