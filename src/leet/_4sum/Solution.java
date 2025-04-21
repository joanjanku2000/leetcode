package leet._4sum;

import leet.util.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSumBetterComplexity(nums,-294967296));
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

    /**
     * Winner - Complexity O(N^3) better than O(N^4)
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSumBetterComplexity(int[] nums, int target) {

//        List<List<Integer>> quadriplets = new ArrayList<>();

        List<List<Integer>> quadriplets = new ArrayList<>();
        List<String> tracker = new ArrayList<>();
        Arrays.sort(nums);

       // ArrayUtils.print(nums);

    //    System.out.println();

        for (int i = 0; i < nums.length - 2; i++){
           int a = nums[i];

          for (int j = i+1; j < nums.length - 1; j++) {
              int b =  nums[j];

              int l = j+1;
              int r = nums.length - 1;

              while (l < r)  {
                  long sum = (long) a + b + nums[l] + nums[r];

//                  System.out.println(l);
                  System.out.println( "a = " + a + " b = " + b + " l = " + nums[l]  +  " r = " +nums[r] + " + sum" + sum);
                  if (target == sum && j != l && j != r) {
                      List<Integer> toAdd= Arrays.asList(a,b,nums[l],nums[r]);
                      String key = toAdd.stream().map(String::valueOf).collect(Collectors.joining());
                     if (!tracker.contains(key)) {
                         quadriplets.add(toAdd);
                         tracker.add(key);
                     }

                      l++;
                  }
                  if (sum > target) {
                      r--;
                  }
                  if (sum < target) {
                      l++;
                  }
              }
          }

        }

        return new ArrayList<>(quadriplets);
    }


}
