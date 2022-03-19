class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList();
        int n = words.length;
        int index = 0;
        while(index < n) {
            int totalChars = words[index].length();
            int last = index + 1;
            while(last < n) {
                if(totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += (1 + words[last].length());
                last++;
            }
            
            // last become the first word in the next line
            int gaps = last - index - 1;
            StringBuilder sb = new StringBuilder();
            
            //first case
            if(gaps == 0 || last == n) {
                for(int i=index; i < last;i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }
                
                sb.deleteCharAt(sb.length()-1);
                while(sb.length() < maxWidth)
                    sb.append(' ');
            }else {
                int spaces = (maxWidth - totalChars) / gaps;
                int rest = (maxWidth - totalChars) % gaps;
                for(int i=index; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                    for(int j=0;j<spaces;j++) sb.append(' ');
                    if(rest > 0) {
                        sb.append(' ');
                        rest--;
                    }
                }
                sb.append(words[last-1]);
            }
            
            index = last;
            ans.add(sb.toString());
        }
        
        return ans;
    }
}