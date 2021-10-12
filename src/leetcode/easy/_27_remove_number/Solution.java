package leetcode.easy._27_remove_number;

import java.util.Arrays;

public class Solution {
	
	public int removeElement(int[] nums, int val) {
	   
		int count = 0;
		int removed = 0;
		for (int i = 0;i<nums.length;i++) {
			if (nums[i]!=val) {
				int temp = nums[i];
				nums[i] = nums[count];
				nums[count] = temp;
				count++;
			} else {
				removed ++;
			}
		}
		return nums.length - removed;
	}
	
	public void print (int[] array, int index) {
		for (int i = 0;i<index;i++) {
			System.out.print(" "+array[i]);
		}
	}
	
	public static void main(String...argumentat) {
		int[] test = {1,1};
		
		int ind = new Solution().removeElement(test, 1);
		
		new Solution().print(test, ind);
		
	}
}
