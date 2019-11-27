class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        if(input == null) return ret;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                
                for(Integer p1 : left){
                    for(Integer p2 : right){
                        switch(input.charAt(i)){
                            case '+':
                                ret.add(p1 + p2);
                                break;
                            case '-':
                                ret.add(p1 - p2);
                                break;
                            case '*':
                                ret.add(p1 * p2);
                                break;
                        }
                    }
                }
            }
        }
        
        if(ret.size() == 0){
            ret.add(Integer.valueOf(input));
        }
        
        return ret;
    }
}