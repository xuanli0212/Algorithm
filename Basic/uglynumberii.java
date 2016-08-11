class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
       List<Integer> result = new ArrayList<Integer>();
       result.add(1);
       int r2 = 0, r3 = 0, r5 = 0;
       for (int i = 1; i < n; i++) {
           int m2 = result.get(r2) * 2;
           int m3 = result.get(r3) * 3;
           int m5 = result.get(r5) * 5;
           int cur = Math.min(m2, Math.min(m3, m5));
           if (cur == m2) r2++;
           if (cur == m3) r3++;
           if (cur == m5) r5++;
           result.add(cur);
       }
       return result.get(n - 1);
    }
};
