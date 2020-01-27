/**
 * Using a hash map, insert new data while checking whether the target data 
 * is in the table.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i]))
                return new int[] {map.get(target-nums[i]), i};
            map.put(nums[i],i);
        }
        return null;
    }
}