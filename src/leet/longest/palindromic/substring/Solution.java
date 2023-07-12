package leet.longest.palindromic.substring;
/**
 * Given a string s, 
 * return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 
 * @author jjanku august 2021 - complexity ~ O(n^2)
 *
 */
public class Solution {
	
	static char[] characters = new char[256];
	public String longestPalindromicSubstring(String s) {
		if (s.isEmpty()) return "";
		String lps = s.substring(0,1);
		StringBuilder st = new StringBuilder();
		String max = lps;
		for (int i =0;i<s.length();i++) {
			if (characters[s.charAt(i)]==0) {
				characters[s.charAt(i)]++;
			} else {
				
				int j = 0; 
				boolean keepGoing  = true;
				for (j = 0;j<i && keepGoing;j++) {
					System.out.println("Passing the value "+s.substring(j,i+1));
					if (isPalindromic(s.substring(j,i+1))) {
						System.out.println("Found the palendromic string "+s.substring(j,i+1));
						if(max.length()<s.substring(j,i+1).length()) {
							max = s.substring(j,i+1);
						} else {
							keepGoing = false;
						}
					}
				}
			}
		}
		return max;
	}
	
	boolean isPalindromic(String s) {
		int j = s.length()-1;
		for (int i = 0;i<s.length() && i!=j;i++) {
			if(s.charAt(i)!=s.charAt(j-i)) {
				return false;
			} else {
				//System.out.printf(" %c = %c",strings[i],c[j-i]);
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		String check = "abcdzdcab";
		System.out.println(new Solution().longestPalindromicSubstring(check));
	}

}
