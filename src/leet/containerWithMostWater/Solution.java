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
    public static int maxArea2nd(int[] height) {
        if (height.length <= 1) return 0;
        if (height.length == 2) return (int) Math.min(height[0], height[1]);
        
        int i = 0 , j = height.length - 1;
        int max = calculate(i,j,height[i],height[j]);
        int val = 0;
        while(i<j) {        	
//        	if (height[i]<height[j])
//        	while(i<j && height[i]<height[i+1]) {
//        		val = calculate(i,j,height[i],height[j]);
//            	if (val>max) max = val;
//        		i++;
//        	}
//        	else
//        	while (j>i && height[j]<height[j-1]) {
//        		val = calculate(i,j,height[i],height[j]);
//        		if (val>max) max = val;
//        		j--;
//        	}        	
        	val = calculate(i,j,height[i],height[j]);
    		if (val>max) max = val;
    		
        	if (height[i]<height[j]) {
        		i++;
        	} else {
        		j--;
        	}
        }
        return max;
    }
    private static int calculate(int i, int j, int k, int l) {
    	System.out.printf("Multypling %d-%d*min(%d,%d)\n",j,i,k,l);
    	return (j-i)*Math.min(k, l);
	}
	public static void main(String[] args) {		
		int[] heights = {6,4,3,1,4,6,99,62,1,2,6};
		System.out.println("The largest area is "+maxArea2nd(heights));
	}

}
