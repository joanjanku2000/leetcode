package leetcode.easy._28_search_insert_position;

/**
 * Doesn't give accurate prediction for values lower than the first one
 * @author Joan
 */
public class Solution { 
	/**
	 * Given a sorted array of distinct integers and a target value, 
	 * return the index if the target is found. If not, return the index 
	 * where it would be if it were inserted in order.
	 * You must write an algorithm with O(log n) runtime complexity.
	 * @param args
	 */
	
	/**
	 * Binary Search
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int position =-1;
        int minDifference = Integer.MAX_VALUE;
        
        while (left <= right) {
        	
        	int middle = (left+right)/2;
        	
        	if (nums[middle] == target) {
        		return middle;
        	} else if (target < nums[middle]) {
        		right = middle - 1;
        	} else {
        		left = middle +1;
        	}        	
        	int difference = Math.abs(target - nums[middle]);
        	
    		if (difference < minDifference) {
    			if (target > nums[middle])
    				minDifference = difference;
    			position = middle;
    		}
        }
        return position +1;
    }
	
	public void print (int[] array, int index) {
		for (int i = 0;i<index;i++) {
			System.out.print(" "+array[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] test = {-1,1,2,5,7,8};		
		int ind = new Solution().searchInsert(test,0 );	
		System.out.println(ind);	
	}

}
