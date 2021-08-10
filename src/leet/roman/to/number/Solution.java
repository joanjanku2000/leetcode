package leet.roman.to.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	protected Map<String,Integer> key ;
	protected List<Integer> keys ;
	 public Solution() {
		 	key = new HashMap<>();
		 	key.put("I",1);
	        key.put("V",5);
	        key.put("X",10);
	        key.put("L",50);
	        key.put("C",100);
	        key.put("D",500);
	        key.put("M",1000);
	        key.put("IV",4);
	        key.put("IX",9);
	        key.put("XL",40);
	        key.put("XC",90);
	        key.put("CD",400);
	        key.put("CM",900);
	      
	 }
	 
    public  int romanToInt(String s) {
    	int sum = 0;
       for (int i = 0;i<s.length();) {   	  
    	   if (i!=s.length()-1) {
    		   if ((s.charAt(i)=='I' && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X'))
        			   || (s.charAt(i)=='X' && (s.charAt(i+1)=='C' || s.charAt(i+1)=='L'))
        			   || (s.charAt(i)=='C' && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M'))) {
        		   sum+=key.get(s.substring(i,i+2)); 
        		   i+=2;
        	   } else {
        		   sum+=key.get(s.substring(i,i+1));
        		   i++;
        	   }
    	   } else {
    		   sum+=key.get(s.substring(i,i+1));
    		   i++;
    	   }
       }
       return sum;
    }

    
	public static void main(String[] args) {
			String romanNumber = "XIX";
			int res = new Solution().romanToInt(romanNumber);
			System.out.printf("%s in roman is %d\n",romanNumber,res);
		
		

	}

}

