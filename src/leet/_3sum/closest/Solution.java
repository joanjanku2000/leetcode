package leet._3sum.closest;

import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {-84,92,26,19,-7,9,42,-51,8,30,-100,-13,-38};
        System.out.println("Closest sum is " + new Solution().threeSumClosestLowerComplexity(nums, 78));
    }

    /**
     * High Complexity
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int[] distances = new int[nums.length * nums.length * nums.length];

        int[] sums = new int[nums.length * nums.length * nums.length];
        int sum = 0, count = 0, minIndex = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    distances[count] = Math.abs(target - sum);
                    sums[count] = sum;

                    if (distances[count] < distances[minIndex]) {
                        minIndex = count;
                    }
                    System.out.println(sum);
                    count++;


                }
            }
        }

        return sums[minIndex];
    }


    /**
     * Lower Complexity O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosestLowerComplexity(int[] nums, int target) {
        Arrays.sort(nums); // -4, -1, 1, 2

        for (int num : nums) {
        //    System.out.println(num);
        }
        int min = Math.abs(target - nums[0] - nums[1] - nums[2]);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = a + nums[l] + nums[r];
                int diff = Math.abs(target - sum);
                System.out.println( "a="+a + " nums[l]=" + nums[l] + " nums[r]=" + nums[r] + " sum " + sum);
                if (diff < min) {
                    min = diff;
                    closestSum = sum;

                } else if (diff == min){
                    min = Math.max(closestSum,sum) ==  closestSum ? min : diff;
                }
                if (sum > target)
                    r--;
                else l++;
            }
        }
        return closestSum;
    }
}
