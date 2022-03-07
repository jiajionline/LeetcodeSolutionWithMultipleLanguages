class Solution {
    public String simplifyPath(String path) {
        if(path.isBlank()) return "/";
        String[] splits = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for(String s : splits) {
            if(s.isEmpty() || s.equals(".")) 
                continue;
            else if(s.equals("..")) {
                if(stack.size() > 0) 
                    stack.pop();
            }else {
                stack.push(s);
            }
        }
        
        List<String> list = new ArrayList<String>(stack.size());
        while(stack.size() > 0) {
            list.add(0,stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<list.size();i++) {
            sb.append("/");
            sb.append(list.get(i));
        }
        
        return sb.length() > 0 ? sb.toString() : "/"; 
    }
}