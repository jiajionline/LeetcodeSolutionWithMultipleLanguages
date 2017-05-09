import java.util.*;
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
    	List<String> retList = new LinkedList<String>();
    	
    	for(int i=1;i<=n;i++){
    		if(i % 3 == 0 && i % 5 == 0){
    			retList.add("FizzBuzz");
    		}else if(i % 3 ==0){
    			retList.add("Fizz");
    		}else if(i % 5 == 0){
    			retList.add("Buzz");
    		}else{
    			retList.add(String.valueOf(i));
    		}
    	}
    	
    	return retList;
    }
}
