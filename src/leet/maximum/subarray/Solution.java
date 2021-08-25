package leet.maximum.subarray;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

	public int maxSubArray(int[] nums) {
        Queue<Integer> queue = new LinkedList();
        Stack<Integer> stack = new Stack();
        int sum = 0;
        
        int i = 0;
        while(i>nums.length) {
        	sum+=nums[i];
        	queue.add(nums[i]);
        	stack.add(nums[i]);
        	i++;
        }
        
      return 0;
        
	}
	
	public static void main(String[] args) {
		
		
		 
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

	}

}
