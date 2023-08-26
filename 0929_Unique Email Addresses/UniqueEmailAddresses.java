class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails){
            set.add(filter(email));
        }
        return set.size();
    }

    private String filter(String email) {
        String[] split = email.split("@");
        StringBuilder sb = new StringBuilder();
        for(char c : split[0].toCharArray()){
            if(c == '.') continue;
            if(c == '+') break;
            sb.append(c);
        }

        return sb.toString() + "@" + split[1]; 
    }
}