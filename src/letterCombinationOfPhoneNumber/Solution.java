package letterCombinationOfPhoneNumber;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class Solution {

    private static Map<Integer,List<String>> trackPad = new HashMap<>();

    static {
        trackPad.put(2, Arrays.asList("a","b","c"));
        trackPad.put(3, Arrays.asList("d","e","f"));
        trackPad.put(4, Arrays.asList("g","h","i"));
        trackPad.put(5, Arrays.asList("j","k","l"));
        trackPad.put(6, Arrays.asList("m","n","o"));
        trackPad.put(7, Arrays.asList("p","q","r","s"));
        trackPad.put(8, Arrays.asList("t","u","v"));
        trackPad.put(9, Arrays.asList("w","x","y","z"));
    }
    public static List<String> letterCombinations(String digits) {
        List<List<String>> digitz = new ArrayList<>();
        for (int i = 0 ; i < digits.length() ; i++ ){
            digitz.add(trackPad.get(Integer.parseInt(String.valueOf(digits.charAt(i)))));
        }
        List<String> result = new ArrayList<>();
        generatePermutations(digitz,0,result , "");
        return result.size() > 1 ? result : Collections.emptyList();
    }

   static void generatePermutations(List<List<String>> characters, int depth ,List<String> result, String current){
        if (depth == characters.size()){
            result.add(current);
            return;
        }

        for (int i = 0 ; i< characters.get(depth).size() ; i++){
            generatePermutations(characters,depth + 1 ,result , current + characters.get(depth).get(i));
        }
    }
}
