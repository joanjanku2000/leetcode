package leet._3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	/**
	 * Does the job but breaks at 3000 elements, bad complexity
	 * TODO improve time complexity
	 * @author jjanku
	 * @param nums
	 * @return
	 */
	 public List<List<Integer>> threeSum(int[] nums) {
	     	
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 Arrays.sort(nums);
		 for (int i = 0;i<nums.length;i++) {
			 int value = -nums[i];
			 
			 int j = i + 1;
			 int k = nums.length - 1;
			 
			 while (j<k) {
				 int sum =  nums[j] + nums[k];
			
				 if (value == sum) {
					 List<Integer> temporary = new ArrayList<>();
					 temporary.add(nums[i]);
					 temporary.add(nums[j]);
					 temporary.add(nums[k]);
					 if ( !contains(result,temporary)) {
						 result.add(temporary);
					 }
				 }  
				 if (sum < value) j++;
				 else k--;
				if (j>nums.length || k<=0) break;
				 }
			 }
		    return result;
		 }
	       
	    
	    
	    
	    private boolean contains(List<List<Integer>> list1, List<Integer> list2) {
	    		    		for (List<Integer> list : list1) {
	    			Collections.sort(list);
	    			Collections.sort(list2);
	    			if (list.equals(list2)) return true;
	    		}
	    		 return false;
	    }
	    
	    public static void main(String[] args) {
	    	int[] arr = {};
	    	System.out.println(new Solution().threeSum(arr));
	    }
}
