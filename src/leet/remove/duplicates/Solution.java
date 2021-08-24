package leet.remove.duplicates;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
    public int removeDuplicates(int[] nums) {
    	Stack<Integer> st = new Stack<>();
    	int i = 0;
    	for (;i<nums.length-1;i++) {
    		if (nums[i+1]==nums[i] ) {
    			st.push(nums[i]);
    			nums[i+1] = Integer.MAX_VALUE;
    		} else {
    			if (!st.isEmpty()) {
    				if (st.peek() == nums[i+1]) {
    					nums[i+1] = Integer.MAX_VALUE;
    				} else {
    					st.pop();
    				}
    				
    			}
    		}
    	}
    	Arrays.sort(nums);
    	int n = (int) Arrays.stream(nums).filter(in -> in != Integer.MAX_VALUE).count();
    	//Arrays.stream(nums).forEach(System.out::println);
    	return n;
    }
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,3,4};
		System.out.println(new Solution().removeDuplicates(nums));
	}

}
