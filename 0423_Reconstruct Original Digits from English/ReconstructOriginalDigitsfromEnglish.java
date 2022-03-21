class Solution {
    public String originalDigits(String s) {
        char[] count = new char[26];
        for(char c : s.toCharArray())
            count[c-'a']++;
        
        // ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"]
        // e -> three, five, seven, eight, zero
        // g -> eight
        // f -> four, five
        // i -> five, six, eight, nine
        // h -> three, eight
        // o -> one, two, four, zero
        // n -> one, seven, nine
        // s -> six, seven, 
        // r -> three, four, zero
        // u -> four
        // t -> two, three, eight
        // w -> two
        // v -> five, seven
        // x -> six
        // z -> zero
        int[] digits = new int[10];
        // z,x,u,w,g only presented 1 digit
        digits[0] = count['z' - 'a'];
        digits[6] = count['x' - 'a'];
        digits[4] = count['u' - 'a'];
        digits[2] = count['w' - 'a'];
        digits[8] = count['g' - 'a'];
        // f, h, s, v presented 2 digits
        digits[5] = count['f' - 'a'] - digits[4];
        digits[3] = count['h' - 'a'] - digits[8];
        digits[7] = count['s' - 'a'] - digits[6];
        // skip v since already got the answer
        
        // n, r, t presented 3 digits
        // we can't determine n since we haven't got the answer of 1, 9
        
        // i, o, presented 4 digits
        digits[9] = count['i' - 'a'] - digits[5] - digits[6] - digits[8];
        digits[1] = count['o' - 'a'] - digits[2] - digits[4] - digits[0];
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++) {
            for(int j=0; j < digits[i]; j++) {
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}