package leet.longest.common.prefix;

public class Solution {
	 
	public String longestCommonPrefix(String[] strs) {
		if (strs.length<=0) return "";
		if (strs.length==1) return strs[0];
		
		int i = 0 , j = strs[0].length() - 1;
	
		String maximum = "";
		for (;j>=0;j--) {
			System.out.println(" j is "+j);
			System.out.println("Checking "+strs[0].substring(0,j+1));
			if (isCommonPrefix(strs[i].substring(i,j+1),strs)) {		
				if (maximum.length()<strs[i].substring(i,j+1).length()) {
					maximum = strs[i].substring(i,j+1);			
				}
			}
		}
		return maximum;
	}
	 public boolean isCommonPrefix(String s, String[] strs) {
		 for (int i = 0;i<strs.length;i++) {
			 if (!strs[i].startsWith(s)){
				 return false;
			 }
		 }
		 return true;
	 }
	public static void main(String[] args) { 
		String[] strs = {"flowr","flower","flower","flower"};
		System.out.println("The longest common prefix is " + new Solution().longestCommonPrefix(strs));
	}

}
