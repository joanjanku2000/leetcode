package leet._4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,1,2,2};
        System.out.println(fourSum(nums,0));
    }
    // to remove duplicates
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> quadriplets = new ArrayList<>();


        for (int i = 0; i < nums.length - 3; i++){
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {

                  for (int z = k + 1; z < nums.length; z++){

                      if (nums[i] + nums[j] + nums[k] + nums[z] == target) {

                          boolean already = false;
                          for (List<Integer> quadriplet : quadriplets) {
                              if (quadriplet.get(0) == nums[i] && quadriplet.get(1) == nums[j] && quadriplet.get(2) == nums[k]  && quadriplet.get(3) == nums[z]) {
                                already = true;
                              }
                          }
                          if (!already)
                            quadriplets.add(Arrays.asList(nums[i],nums[j],nums[k],nums[z]));
                      }
                    }
                }

            }
        }

        return quadriplets;


    }
}
