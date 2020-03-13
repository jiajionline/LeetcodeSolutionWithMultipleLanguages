
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
        	int[] zeroArray = new int[0];
        	return zeroArray;
        }
        
        int[] tempArray = new int[digits.length];
        System.arraycopy(digits, 0, tempArray, 0, digits.length);
        int carry = 1;
        for(int i=digits.length - 1; i>=0 && carry > 0; i--){
        	int v = digits[i];
        	v += carry;
        	tempArray[i] = v % 10;
        	carry = v / 10;
        }
        
        if(carry == 0){
        	return tempArray;
        }else{
        	int[] ret = new int[tempArray.length+1];
        	ret[0] = carry;
        	for(int i=0;i<tempArray.length;i++){
        		ret[i+1] = tempArray[i];
        	}
        	
        	return ret;
        }
    }
}
