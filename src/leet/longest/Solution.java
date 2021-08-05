package leet.longest;

import java.util.Stack;

/**
Given a string s, find the length of the longest substring without repeating characters.
 
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:
Input: s = ""
Output: 0 */
public class Solution {
	

	public int lengthOfLongestSubstring(String s) {
			 
		        Stack<String> st = new Stack<String>();
		        StringBuilder strB = new StringBuilder();
		        int i = 0;
	        if (s.equals(" ") || s.length()==1) return 1;
		        while(i<s.length()) {
		        	if (!strB.toString().contains(s.substring(i,i+1))) {
		        		System.out.printf("%s doesnt contain %s ",strB.toString(),s.substring(i,i+1));
		        			strB.append(s.substring(i, i+1));
		        			i+=1;
		        			if (i>=s.length()-1 ) {
		        				if (!st.isEmpty()) {
		    	        			if (st.peek().length()<strB.toString().length()) {
		    	        					st.pop();
		    	        					st.push(strB.toString());
		    	        			}
		        			}  else {
		        				st.push(strB.toString());
		        			}
		        	}
		        	}else {
		        		System.out.println(strB.toString());
		        		if (!st.isEmpty()) {
		        			if (st.peek().length()<strB.toString().length()) {
		        					st.pop();
		        					st.push(strB.toString());
		        			}
		        		} else {
		        			st.push(strB.toString());
		        		}
		        		
		        		strB.replace(0, strB.length(), "");
		        		System.out.println("Now strb is emtpty "+strB.toString());
		        		i--;
		        	}
		        }
		        return !st.isEmpty() ? st.peek().length() : 0;
		  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
