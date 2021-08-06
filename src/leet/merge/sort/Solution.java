package leet.merge.sort;

public class Solution {
/**
 * @author jjanku + gfg
 * @param array
 * @param left
 * @param middle
 * @param right
 */
	 void merge(int[] array,int left,int middle,int right) {
		 
		 int n1 = middle-left+1;
		 int n2 = right - middle;
		 int[] leftArray = new int[n1];
		 int[] rightArray = new int[n2];
		
	        for (int i = 0; i < n1; ++i)
	            leftArray[i] = array[left + i];
	        for (int j = 0; j < n2; ++j)
	            rightArray[j] = array[middle + 1 + j];
		 
		 System.out.println("Left array : ");
		 new leet.median.array.Solution().print(leftArray);
		 System.out.println("Right array : ");
		 new leet.median.array.Solution().print(rightArray);
		 
		 int i = 0,j=0;
		 int k = left;
		 
		 while (i<n1 && j < n2) {
			 if (leftArray[i] <= rightArray[j]) {
				 array[k++] = leftArray[i++];
			 } else {
				 array[k++] = rightArray[j++];
			 }
		 }
		 System.out.printf
		 ("\n L length %d , i = %d  R length %d , j = %d",n1,i,n2,j);
		 System.out.println("\n k is "+k + " length of array is "+ (right-left+1));
		 while (i<n1) {
			 array[k++] = leftArray[i++];
		 }
		 while(j<n2) {
			 array[k++] = rightArray[j++];
		 }
		
	 }
	 /**
	  * @author gfg
	  * @param arr
	  * @param l
	  * @param r
	  */
	 void sort(int arr[], int l, int r)
	    {
	        if (l < r) {
	            // Find the middle point
	            int m =l+(r-l)/2;
	 
	            // Sort first and second halves
	            sort(arr, l, m);
	            sort(arr, m + 1, r);
	            System.out.println(" Entering array ");
	   		 	print(arr,l,r);
	            // Merge the sorted halves
	            merge(arr, l, m, r);
	        }
	    }
	 public void print(int[] arr, int l,int r) {
		 System.out.println("[ ");
		 for (int i=l;i<r;i++) {
			 System.out.println(" "+arr[i]);
		 }
		 System.out.println(" ]");
	 }
	public static void main(String[] args) {
		int[] arr = {6,2,5,4,3,1};
		new Solution().sort(arr,0,arr.length-1);
		new leet.median.array.Solution().print(arr);
	}
}
