package leet._3sum.closest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	Map<Integer,Integer> sums = new HashMap<>();
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
//		System.out.println("Array is ");
//		for (int i = 0 ;i<nums.length;i++) {
//			System.out.print(" "+nums[i]);
//		/}
//		System.out.println();
		int minDif = Integer.MAX_VALUE;
        int sum = 0;
        if (target>0)
        for (int i = 0;i<nums.length;i++) {
        	
        	int k = i+1;
        	int j = nums.length - 1;
        	while(k<j) {
        		sum=nums[k]+nums[j]+nums[i];        		
        		if (Math.abs(sum-target)<=minDif ) {
        			minDif = Math.abs(sum-target);
        			sums.put(minDif, sum);
        			k++;
        		} else {
        			j--;
        		}
        	}
        }
        else {
        	//System.out.println("hyn");
        	minDif = Integer.MAX_VALUE;
            for (int i = 0;i<nums.length;i++) {
            	
            	int k = i+1;
            	int j = nums.length - 1;
            	while(k<j) {
            		sum=nums[k]+nums[j]+nums[i];    
            		
            		if (Math.abs(sum-target)<=minDif ) {
            			minDif = sum-target;
            		//	System.out.printf("i = %d , k = %d , j = %d Min Diff is %d, Sum = %d\n",i,k,j,minDif,sum);
            			sums.put(minDif,sum);
            			if(nums[k+1]<nums[k])
            				k++;
            			else
            			j--;
            			
            		} else {
            			if(nums[k+1]<nums[k])
            				k++;
            			else
            			j--;
            		}
            	}
            }
        }
    //    System.out.println("Min diff is " + minDif );
        return sums.get(minDif);
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,-1,-1,3};
		System.out.println("Closest sum is "+new Solution().threeSumClosest(nums,-1));
	}
}
