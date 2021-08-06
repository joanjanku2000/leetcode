package leet.median.array;
/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, 
 * return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * Example 1:
	Input: nums1 = [1,3], nums2 = [2]
	Output: 2.00000
	Explanation: merged array = [1,2,3] and median is 2.
 * @author jjanku
 *
 */
/**
 * This is merge sort
 * @author jjanku
 *
 */
public class Solution {
	  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		  
		 int[] result = merge(nums1,nums2);
		 System.out.print("Merged arrays are ");
		 print(result);
		  if (result.length%2!=0) {
			  System.out.println("Ne ket branch");
			  return result[(result.length)/2];
		  } else {
			  System.out.println("Res is "+ result[result.length/2 -1 ]+result[(result.length/2)] );
			  return (result[result.length/2]-1)+result[(result.length/2)] != 0 ? 
					  (double) ((result[result.length/2 -1])+result[(result.length/2)])/2
					  : 0.0;
			
			 
		  }
		  
	  }
	  
	  public int[] merge(int[] nums1,int[] nums2) {
		  int n1 = nums1.length;
		  int n2 = nums2.length;
		  
		  int[] mergedArray = new int[n1+n2];
		  
		  int i = 0 , j = 0;
		  int k = 0;
		  while (i<n1 && j<n2) {
			  if (nums1[i]<nums2[j]) {
				  mergedArray[k++] = nums1[i++];
			  } else {
				  mergedArray[k++] = nums2[j++];
			  }
		  }
		  
		  while (i<n1) {
			  mergedArray[k++] = nums1[i++];
		  }
		  while (j<n2) {
			  mergedArray[k++] = nums2[j++];
		  }
		  return mergedArray;
	  }
	  public void print(int[] arr) {
		  System.out.print("\n[");
		  for (int i : arr) {
			  System.out.print(" "+ i);
		  } System.out.println(" ]");
	  }
	  
	 
	  public static void main(String[] args) {
		  int[] n1 = {1,2,4};
		  int[] n2 = {3,5,6};
		  Solution sol = new Solution();
		System.out.println("Median is "+sol.findMedianSortedArrays(n1,n2));
	  }
}
