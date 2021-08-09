package leet.atoi;
class Solution {
    public int myAtoi(String s) {
		
		StringBuilder integer = new StringBuilder();
		String str = s.trim();
		int i = 0;
		int sign = 1;
		while(i<str.length()) {
			if (i!=0) {
				if (!Character.isDigit(str.charAt(i)) && str.substring(i,i+1).compareTo(" ") != 0) break;
				if (str.substring(i,i+1).compareTo(" ") == 0) {
						break;
				}
				else {
					integer.append(str.substring(i,i+1));
					i++;
				}
			} else {
				if (str.charAt(i)=='-') {
					sign = -1;
				} else if (str.charAt(i)=='+') {
					sign = 1;
				} else if (Character.isDigit(str.charAt(i))) {
					integer.append(str.substring(0,1));
				} else {
					return 0;
				}
				i++;
			}
		}
		
		if (integer.toString().isEmpty()) {
			return 0;
		}
           Integer value = 0;
		if (integer.toString().length()>=10){
            try
            {
                 value = Integer.valueOf(integer.toString())*sign;
            } catch(NumberFormatException e){
               return sign>0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
		      
        }
		return Integer.valueOf(integer.toString()) * sign;
		
	}
}


















