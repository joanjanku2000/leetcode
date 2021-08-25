package leet.strStr;

public class Solution {
	
	public int strStr(String haystack, String needle) {
		 char[] hstack = haystack.toCharArray();
		 char[] needl = needle.toCharArray();
		 
		 if (!haystack.contains(needle)) return 0;
		 
		 boolean continueIteration = true;
		 int i = 0;
		 
		 for (;i<hstack.length && continueIteration;) {
			  continueIteration = false;
			  int k = i;
			  System.out.println("-----------------");
			 for (int j = 0;j<needl.length;j++) {
				 
				 if (k>hstack.length) continue;
				 
				 if (hstack[k]!=needl[j]) {
					 System.out.println(String.format("haystack[%d] != needle[%d] -> %c != %c", k,j,hstack[k],needl[j]));
					 continueIteration=true;
					 break;
				 }
				 
				 k++;
			}
			 i++;
		 }
	     return i <= haystack.length() ? i-1 : 0;
	 }
	
	public static void main(String[] args) {
		
		System.out.println(
				"Needle in a haystack "+new Solution()
				.strStr("haystackkl","l")
				);

	}

}
