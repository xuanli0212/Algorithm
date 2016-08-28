import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> sticks = new ArrayList<Integer>();
        while (sc.hasNextInt()) {
            sticks.add(sc.nextInt());
        }
        Collections.sort(sticks, Collections.reverseOrder());
        while (num > 0) {
            System.out.println(num);
            int min = sticks.get(num - 1);
            //System.out.println(min);
            //注意这里，num不断地减小，要单独保存一个num。否则就无法遍历所有的数值。
            int size = num;
            for (int i = 0; i < size; i++) {
                int newValue = sticks.get(i) - min;
                //System.out.println(newValue);
                sticks.set(i, newValue);
                if (newValue == 0) {
                    num--;
                }
            }            
        }
        //System.out.println(num);
         
    }
    
}
