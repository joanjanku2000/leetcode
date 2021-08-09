package leet.containerWithMostWater;

public class Solution {
	
    public static int maxArea(int[] height) {
        int max = 1;
        if (height.length <= 1) return 0;
        if (height.length == 2) return (int) Math.min(height[0], height[1]);
        
        int i = 0 , j = height.length - 1;
        for (;j>0;j--) {
        	for (i=0;i<j;i++) {
        		int multiplier = (j-i);
        		System.out.println("Multiplier is "+multiplier);
        		if (multiplier*Math.min(height[i], height[j])>max) {
            		max = (j-i)*Math.min(height[i], height[j]);
            	}
        	}
        }
        return max;
    }
    public void print(int[] arr) {
		  System.out.print("\n[");
		  for (int i : arr) {
			  System.out.print(" "+ i);
		  } System.out.println(" ]");
	  }
	public static void main(String[] args) {
		int[] heights = {3,2,1,2};
		System.out.println("The largest area is "+maxArea(heights));
	}

}
