class Solution {
    public String minWindow(String s, String t) {
    if(s==null||s.isEmpty()||t==null||t.isEmpty()) return "";

    String ans="";
    int l=0, r=0, count=0, minLength=s.length() + 1;
    int[] mapT=new int[256];
    int[] mapS=new int[256];

    for(int c=0; c < t.length(); c++) mapT[t.charAt(c)]++;

    while(r<s.length()){
        if(count<t.length()){
            if(mapT[s.charAt(r)]>0){
                mapS[s.charAt(r)]++;
                if(mapS[s.charAt(r)]<=mapT[s.charAt(r)]){
                    count++;
                }
            }
            r++;
        }
        while(count==t.length()){
            if(r-l<minLength){
                minLength=r-l; 
                ans=s.substring(l,r);
            }
            
            if(mapT[s.charAt(l)]>0){
                mapS[s.charAt(l)]--;
                if(mapS[s.charAt(l)]<mapT[s.charAt(l)]) count--;
            }
            
            l++;
        }
    }
    return ans;
}
}