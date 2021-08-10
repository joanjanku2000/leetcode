package leet.number.to.roman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	protected Map<Integer,String> key ;
	protected List<Integer> keys ;
	 public Solution() {
		 	key = new HashMap<>();
		 	key.put(1,"I");
	        key.put(5, "V");
	        key.put(10, "X");
	        key.put(50, "L");
	        key.put(100, "C");
	        key.put(500, "D");
	        key.put(1000, "M");
	        key.put(4, "IV");
	        key.put(9, "IX");
	        key.put(40, "XL");
	        key.put(90, "XC");
	        key.put(400, "CD");
	        key.put(900, "CM");
	        keys = new ArrayList<>();
	        keys.add(1);
	        keys.add(5);
	        keys.add(10);
	        keys.add(50);
	        keys.add(100);
	        keys.add(500);
	        keys.add(1000);
	        keys.add(4);
	        keys.add(9);
	        keys.add(40);
	        keys.add(90);
	        keys.add(400);
	        keys.add(900);
	 }
	 
    public  String intToRoman(int num) {
       StringBuilder res = new StringBuilder();
       int num_copy = num;
       while(num_copy >= 1) {
    	   int div = findDivisor(num_copy);
    	  
    	   int remaining = num_copy/div;
    	   for (int i = 0;i<remaining;i++) {
    		   res.append(key.get(div));
    	   }
    	   num_copy=num_copy%div;
       }
       return res.toString();
    }
    public int findDivisor(int num) {
    		Collections.sort(keys,Collections.reverseOrder());
    		for (int i = 0;i<keys.size();i++) {
    			if (num/keys.get(i)>0) {
    				return keys.get(i);
    			}
    		}
    		return 1;
    }
    
	public static void main(String[] args) {
		for (int i = 1;i<=3999;i++) {
			String res = new Solution().intToRoman(i);
			System.out.printf("%d in roman is %s\n",i,res);
		}
		

	}

}
