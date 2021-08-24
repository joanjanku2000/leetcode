package leet.length.of.last.word;

import java.util.Arrays;

public class Solution {
	 public int lengthOfLastWord(String s) {
	       String[] words = s.split(" ");
	        if (s.length()<=0) return 0;
	        
	      return words.length > 1 ? words[words.length-1].length() : words[0].length();
	       
	 }
	  
	public static void main (String...args) {
		System.out.println(new Solution().lengthOfLastWord("Hello worldd"));;
	}

}
