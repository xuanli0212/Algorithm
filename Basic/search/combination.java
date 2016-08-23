{
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if ( n == 0 || k == 0 || n < k ) {
		    return result;
		}
		helper(result, list, n, k , 1);
		return result;
		
    }
    private void helper (List<List<Integer>> result, List<Integer> list, int n, int k, int position) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            // 这一步注意要return，否则会导致一直不断地加list。
            return;
        }
        for (int i = position; i <= n; i++) {
            list.add(i);
            helper(result, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
