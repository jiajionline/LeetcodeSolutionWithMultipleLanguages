class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)  return "0";
        
        StringBuilder sb = new StringBuilder();
        String sign = (numerator > 0) ^ (denominator > 0) ? "-" : "";
        sb.append(sign);

        long dividend = Math.abs((long)numerator);
        long divisor = Math.abs((long)denominator);

        sb.append(dividend / divisor);
        long remainder = dividend % divisor;
        if(remainder == 0) {
            return sb.toString();
        }

        sb.append(".");

        HashMap<Long, Integer> map = new HashMap<>();
        
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            } else {
                map.put(remainder, sb.length());
                remainder *= 10;
                sb.append(remainder / divisor);
                remainder %= divisor;
            }
        }
        return sb.toString();
    }
}