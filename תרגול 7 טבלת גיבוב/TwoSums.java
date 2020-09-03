package S6;

import java.util.HashMap;

public class TwoSums {
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	        int[] ans = new int[2];
	        HashMap<Integer,Integer> map = new HashMap<>();
	        // Key -> A[i];
	        // Value -> i
	        for(int i=0; i<nums.length; i++) {
	        if(map.containsKey(target - nums[i])) {
	           ans[1] = i;
	           ans[0] = map.get(target - nums[i]);
	           }
	         else
	           map.put(nums[i],i);
	        }
	        return ans;
	    }
	}
}
