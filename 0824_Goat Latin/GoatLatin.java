class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i','o','u','A','E','I','O','U'));
        String[] words = sentence.split(" ");
        for(int i=0;i<words.length;i++)
            convert(words[i], i+1, sb, vowelSet);
        
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    private void convert(String word, int index, StringBuilder sb, Set<Character> vowelSet) {
        if(vowelSet.contains(word.charAt(0))) {
            sb.append(word);
        }else{
            sb.append(word.substring(1) + word.charAt(0));
        }
        
        sb.append("ma");
        
        for(int i=1;i<=index;i++)
            sb.append("a");
        
        sb.append(" ");
    }
}