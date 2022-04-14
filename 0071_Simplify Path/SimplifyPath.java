class Solution {
    public String simplifyPath(String path) {
        if(path.isBlank()) return "/";
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s : strs) {
            if(s.isEmpty() || s.equals(".")) continue;
            
            if(s.equals("..")) {
                if(stack.size() > 0) stack.pop();
            }else {
                stack.push(s);
            }
        }
        
        if(stack.size() == 0) return "/";
        
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0){
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        
        return sb.toString();
    }
}