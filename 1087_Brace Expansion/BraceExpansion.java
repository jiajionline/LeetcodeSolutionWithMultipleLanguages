class Solution {
    public String[] expand(String s) {
        List<String> ans = new ArrayList<String>();
        ans.add("");
        
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index < s.length()) {
            if(s.charAt(index) == '{') {
                if(sb.length() > 0) {
                    ans = combine(ans, sb.toString());
                    sb.setLength(0);
                }
                index++;
                while(s.charAt(index) != '}')  sb.append(s.charAt(index++));
                String curlyStr = sb.toString();
                String[] strs = curlyStr.split(",");
                ans = combine(ans, strs);
                sb.setLength(0);
                index++;
            }else{
                sb.append(s.charAt(index++));
            }
        }
        
        if(sb.length() > 0) {
            ans = combine(ans, sb.toString());
        }
        
        String[] res = new String[ans.size()];
        for(int i=0;i<ans.size();i++) res[i] = ans.get(i);
        Arrays.sort(res);
        return res;
    }
    
    private List<String> combine(List<String> list, String[] list2) {
        List<String> newList = new ArrayList<String>();
        for(String str : list) {
            for(String str2 : list2) {
                newList.add(str + str2);
            }
        }
        
        return newList;
    }
    
    private List<String> combine(List<String> list, String str) {
        String[] list2 = new String[1];
        list2[0] = str;
        return combine(list, list2);
    }
}