public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(result, list, candidates, target, 0);
        return result;
        
    }
    private void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int position) {
        // if sum to target, list add to result.
        if (getSum(list) == target) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        // DFS
        //注意i是从position开始因为后面取得书只能大于此数。
        for (int i = position; i < candidates.length; i++) {
        //因为已经可以重复取数，所以如果有重复数就跳过
            if (i > 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            //如果已经超过了target，直接跳过
            if (getSum(list) > target) {
                continue;
            }
            //如果单个数就已经超过target，跳过
            if (candidates[i] > target) {
                continue;
            }

            list.add(candidates[i]);
            //这里注意是要i，因为可以重复取多个数。
            helper(result, list, candidates, target, i);
            list.remove(list.size() - 1);
        }
    }
    private int getSum(List<Integer> list) {
        int result = 0;
        for (Integer num : list) {
            result += num;
        }
        return result;
    }
}
