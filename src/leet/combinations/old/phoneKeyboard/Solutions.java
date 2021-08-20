package leet.combinations.old.phoneKeyboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solutions {
	private Map<Integer,List<Character>> dictionary ;
	
	{
		dictionary = new HashMap<>() ;
		char c = 'a';
		for (int i = 2;i<=9;i++) {
			List<Character> temp = new ArrayList<>();
			if (i==7 || i == 9) {
				temp.add(c++);
				temp.add(c++);
				temp.add(c++);
				temp.add(c++);
				
			} else {
				temp.add(c++);
				temp.add(c++);
				temp.add(c++);
			}		
			
			dictionary.put(i,temp);
		}
	}
	public Solutions() {
		System.out.println(dictionary.toString());
	}
//    public List<String> letterCombinations(String digits) {
//        
//    }
	public static void main (String...args) {
		Solutions sol = new Solutions();
	}
}
