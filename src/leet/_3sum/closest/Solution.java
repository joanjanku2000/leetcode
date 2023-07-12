package leet._3sum.closest;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println("Closest sum is " + new Solution().threeSumClosest(nums, 1));
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
}
