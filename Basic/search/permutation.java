class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        // get result
        Collections.sort(nums);
        int[] visited = new int[nums.size()];
        helper (list, result, nums, visited);
        return result;
    }
    private void helper (ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> nums, int[] visited) {
        // list size == nums size return
        if (list.size() == nums.size()) {
           result.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] == 1) {
                continue;
            }
            list.add (nums.get(i));
            visited[i] = 1;
            helper (list, result, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}
