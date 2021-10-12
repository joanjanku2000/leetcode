package leetcode.easy._27_remove_number;

/**
 * Given an integer array nums and an integer val, 
 * remove all occurrences of val in nums in-place. 
 * The relative order of the elements may be changed.

Since it is impossible to change the length of the array in some languages,
 you must instead have the result be placed in the first part of the array nums.
  More formally, if there are k elements after removing the duplicates, 
  then the first k elements of nums should hold the final result. 
  It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this 
by modifying the input array in-place with O(1) extra memory.
 * @author Joan
 */
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
