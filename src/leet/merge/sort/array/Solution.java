package leet.merge.sort.array;

public class Solution {
	
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0,j = 0;
        int[] finalArr = new int[m+n];
        int k = 0;
        while(i < m && j<n) {
        	if (nums1[i]<nums2[j]) {
        		finalArr[k] = nums1[i++];
        	} else {
        		finalArr[k] = nums2[j++];
        	}
        	k++;
        }
        while(i<m) {
        	finalArr[k++] = nums1[i++];
        }
        while(j<n) {
        	finalArr[k++] = nums2[j++];
        }
        
        for (i = 0;i<(m+n);i++) {
        	nums1[i] = finalArr[i];
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
