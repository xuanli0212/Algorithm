class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums ==  null || nums.isEmpty()) {
            return result;
        }
        Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.size()];
        helper(result, list, visited, nums);
        return result;
    }
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] visited, ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] == 1 || (i != 0 && nums.get(i - 1) == nums.get(i) && visited[i - 1] == 0)) {
                continue;
            }
            list.add(nums.get(i));
            visited[i] = 1;
            helper(result, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
        if (list.size() == nums.size()){
            result.add(new ArrayList<Integer>(list));
            //注意要return
            return；
            
        }
    }
}
