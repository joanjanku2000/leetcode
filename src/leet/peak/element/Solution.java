package leet.peak.element;

public class Solution {

    public int findPeakElement(int[] nums) {
    	int before = 0;
    	if (nums.length == 2) {
    		if (nums[0]>nums[1]) return 0;
    		else return 1;
    	}
        for (int i = 1;i<nums.length-1;i++) {
        	if (nums[i]>nums[before] && nums[i]>nums[i+1] ) return i;
        	before++;
        }
     return 0;
 
    }
    
	public static void main(String[] args) {
		int[] nums = {1,2,1};
	
		System.out.println(new Solution().findPeakElement(nums));

	}

}
