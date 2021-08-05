package leet.assessment;

import java.util.ArrayList;
import java.util.List;

public class Order {
	/**
	 * You are given two strings order and s. All the words of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.

 

Example 1:

Input: order = "cba", s = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
Example 2:

Input: order = "cbafg", s = "abcd"
Output: "cbad"
	 * @param order
	 * @param s
	 * @return
	 */

    public static String customSortString(String order, String s) {
     
    if (order.length()>1){
           
           
            List<List<Integer>> indexes = new ArrayList<List<Integer>>();
            		
            for (int i = 0;i<order.length();i++){
               indexes.add(indexesOf(order.charAt(i),s));
            }
            
            System.out.println(indexes);
            String res = s;
            String nOrder = "";
        	StringBuilder str = new StringBuilder();
            for (int i = 0;i<indexes.size();i++){          
                  for (Integer it : indexes.get(i)) {           	
                	str.append(order.charAt(i));
                    res = res.replace(s.substring(it,it+1), "");       	 
                  }
                  System.out.println("Res is "+res);
            }
            
            return str.append(res).toString();
    } else if (order.length()==1) {
    	StringBuilder stN = new StringBuilder();
    	StringBuilder st = new StringBuilder();
    	String res = s;
    	List<Integer> indexes = indexesOf(order.charAt(0),s);
    	for (Integer i : indexes) {
    		stN.append(s.charAt(i));
    	    res = res.replace(s.substring(i,i+1), "");
    	}
    	return stN.append(res).toString();
    } else {
    	return s;
    }
} 
    static List<Integer> indexesOf(char c, String s){
    	List<Integer> indexes = new ArrayList<Integer>();
    	for (int i = 0;i<s.length();i++) {
    		if (Character.compare(s.charAt(i), c)==0) {			
    			indexes.add(i);
    		} 
    	}
    	
    	return indexes;
    }
	public static void main(String[] args) {
		String order = "";
		String s = "treggggggggg";
		//System.out.println(indexesOf('e',s));
		System.out.println(Order.customSortString(order, s));

	}

}
