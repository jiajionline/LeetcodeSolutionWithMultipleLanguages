import java.util.*;

public class KMP{
    public static List<Integer> build(String p){
        int m = p.length();
        List<Integer> nxt = new ArrayList<Integer>();
        nxt.add(0); nxt.add(0);

        for(int i=1, j = 0; i<m; i++){
            while(j > 0 && p.charAt(i) != p.charAt(j))
                j = nxt.get(j);
            if(p.charAt(i) == p.charAt(j))
                j++;
            nxt.add(j);
        }
        return nxt;
    }
    
    public static List<Integer> match(String s, String p){
    	List<Integer> nxt = build(p);
    	List<Integer> ans = new ArrayList<Integer>();
    	
    	int n = s.length();
    	int m = p.length();
    	
    	for(int i = 0, j =0;i<n;i++) {
    		while(j > 0 && s.charAt(i)!=p.charAt(j))
    			j = nxt.get(j);
    		if(s.charAt(i) == p.charAt(j))
    			j++;
    		if(j == m) {
    			ans.add(i - m + 1);
    			j = nxt.get(j);
    		}
    	}
    	
    	return ans;
    }
    
    public static void CheckEQ(List<Integer> actual, List<Integer> expected) {
    	if (!actual.equals(expected))
    		System.out.println("actual " + Arrays.toString(actual.toArray()) + " , expected " + Arrays.toString(expected.toArray()));
        else
            System.out.println("pass.");
    
    }
        
	public static void main(String[] args) {
		KMP.CheckEQ(KMP.build("ABCDABD"), new ArrayList<Integer>(List.of(0, 0, 0, 0, 0, 1, 2, 0)));
		KMP.CheckEQ(KMP.build("AB"), new ArrayList<Integer>(List.of(0, 0, 0)));
		KMP.CheckEQ(KMP.build("A"), new ArrayList<Integer>(List.of(0, 0)));
		KMP.CheckEQ(KMP.build("AA"), new ArrayList<Integer>(List.of(0, 0, 1)));
		KMP.CheckEQ(KMP.build("AAAA"), new ArrayList<Integer>(List.of(0, 0, 1, 2, 3)));
		KMP.CheckEQ(KMP.build("AABA"), new ArrayList<Integer>(List.of(0, 0, 1, 0, 1)));
		
		KMP.CheckEQ(KMP.match("ABC ABCDAB ABCDABCDABDE", "ABCDABD"),new ArrayList<Integer>(List.of(15)));
		KMP.CheckEQ(KMP.match("ABC ABCDAB ABCDABCDABDE", "AB"),new ArrayList<Integer>(List.of(0, 4, 8, 11, 15, 19)));
		KMP.CheckEQ(KMP.match("ABC ABCDAB ABCDABCDABDE", "B"), new ArrayList<Integer>(List.of(1, 5, 9, 12, 16, 20)));
		KMP.CheckEQ(KMP.match("AAAAA", "A"), new ArrayList<Integer>(List.of(0, 1, 2, 3, 4)));
		KMP.CheckEQ(KMP.match("AAAAA", "AA"), new ArrayList<Integer>(List.of(0, 1, 2, 3)));
		KMP.CheckEQ(KMP.match("AAAAA", "AAA"), new ArrayList<Integer>(List.of(0, 1, 2)));
		KMP.CheckEQ(KMP.match("ABC", "ABC"), new ArrayList<Integer>(List.of(0)));

	}
}
