package solution;

/**
 * Given an integer array nums of length n and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 */
public class Main {

    public static void main(String[] args) {

    }

    public int threeSumClosest(int[] nums, int target) {

        int[] distances = new int[nums.length*nums.length*nums.length];
        int[] sums = new int[nums.length*nums.length*nums.length];
        int sum = 0 , count = 0;
        int minIndex = 0;

        for (int i = 0; i< nums.length - 2 ;i++) {
            for (int j = i + 1 ; j < nums.length - 1 ;j++) {
                for (int k = j + 1 ; k < nums.length ; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    distances[count] = Math.abs(target-sum);
                    sums[count] = sum;

                    if (distances[count] < distances[minIndex]) {
                        minIndex = count;
                    }

                    count++;


                }
            }
        }

        return sums[minIndex];
    }
}