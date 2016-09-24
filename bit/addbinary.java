public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        if (a == null || b == null) return null;
         int num1 = stringToBit(a);
         int num2 = stringToBit(b);
         int result = add(num1, num2);
         return intToBit(result);
    }
    private int add(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }
    private String intToBit(int num) {
        StringBuilder result = new StringBuilder();
        if (num == 0) result.append("0");
        while (num > 0) {
            result.insert(0, num % 2);
            num = num/2;
        }
        return result.toString();
    }
    private int stringToBit(String str) {
        if (str == null) return 0;
        int size = str.length();
        int result = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (str.charAt(i) == '1') result = result + 1 * (int) Math.pow(2, size - 1 - i);
        }
        return result;
    }
}
