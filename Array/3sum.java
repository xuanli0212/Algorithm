public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        //a + b = -c. target at -c.
        ArrayList<ArrayList<Integer>> resultSet = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return resultSet;
        }
        Arrays.sort(numbers);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            } else {
                int target = 0 - numbers[i];
                HashSet<Integer> map = new HashSet<Integer>();
                for (int j = i + 1; j < numbers.length; j++) {
                    int targetNumber = target - numbers[j];
                    if (!map.contains(numbers[j])) {
                        map.add(targetNumber);
                    } else {
                        if (result.size() ==3 && result.get(0) == numbers[i] && result.get(2) == numbers[j] && result.get(1) == targetNumber) {
                            continue;
                        }
                        result = new ArrayList<Integer>();
                        result.add(numbers[i]);
                        result.add(targetNumber);
                        result.add(numbers[j]);
                        resultSet.add(result);
                        
                    }
                }
            }
        }
        
        return resultSet;
    }
}
