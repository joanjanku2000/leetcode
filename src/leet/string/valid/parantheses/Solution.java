package leet.string.valid.parantheses;

import java.util.Stack;

public class Solution {
	
	Stack<Character> st = new Stack<>(); 
	Stack<Character> closing = new Stack<>();
	
	public boolean isValid(String s) {
		
		for (int i = 0;i<s.length();i++) {
			
			if (s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='[') {
				st.push(s.charAt(i));
			}
			if (s.charAt(i)=='}') {
				closing.add(s.charAt(i));
				if (!st.isEmpty()) {
					if (st.peek() == '{') {
						st.pop();
						closing.pop();
					}
				}	
			
			}
			if (s.charAt(i)==')') {
				closing.add(s.charAt(i));
				if (!st.isEmpty()) {
				if (st.peek()=='(') {
					st.pop();
					closing.pop();
				}
				}
			}
			if (s.charAt(i)==']') {
				closing.add(s.charAt(i));
				if (!st.isEmpty()) {
					if (st.peek()=='[') {
						st.pop();
						closing.pop();
					}
				}	
			}
					
		}
		return st.size()==0 && closing.size()==0;
	}
	
	public static void main(String[] args) {
		String str = "[]";
		System.out.println(new Solution().isValid(str));
	}
}
