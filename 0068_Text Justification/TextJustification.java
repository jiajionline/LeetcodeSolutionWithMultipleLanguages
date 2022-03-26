class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList();
        // the count of words
        int n = words.length;
        int index = 0;
        // scan each word
        while(index < n) {
            // initialize totalChars by the first word
            int totalChars = words[index].length();
            int last = index + 1;
            // find the last word which overflow the line
            while(last < n) {
                if(totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += (1 + words[last].length());
                last++;
            }
            
            // last become the first word in the next line
            // the gaps mean how many gaps between words , for example : "This    is    an" has 2.
            int gaps = last - index - 1;
            StringBuilder sb = new StringBuilder();
            
            //first case, if there is no gap (only one long word in the line) or this is the last line
            if(gaps == 0 || last == n) {
                for(int i=index; i < last;i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }
                
                sb.deleteCharAt(sb.length()-1);
                while(sb.length() < maxWidth)
                    sb.append(' ');
            }else {
                // how many apcaces per gap
                int spaces = (maxWidth - totalChars) / gaps;
                // some gaps will have more space
                int rest = (maxWidth - totalChars) % gaps;
                // handle from index to the last second in this line (last word need to be handled differentially )
                for(int i=index; i < last - 1; i++) {
                    sb.append(words[i]);
                    // since totalChars counted by the word + ' ' so that we need to add a ' ' firstly. The spaces don't count this space.
                    sb.append(' ');
                    for(int j=0;j<spaces;j++) sb.append(' ');
                    // if rest > 0, for this gap, need to add one more space
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