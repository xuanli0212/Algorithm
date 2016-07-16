/* Method 1: HashMap */
public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) {
            return result;
        }
     
        HashMap<Integer,Integer> list = new HashMap<Integer,Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int goal = target - numbers[i];
            if (list.get(goal) != null) {
                result[1] = i + 1;
                result[0] = list.get(goal) + 1;
            }
            list.put(numbers[i],i);
        }
        return result;
    }
}
