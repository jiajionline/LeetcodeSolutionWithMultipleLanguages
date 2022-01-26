class Solution {
    public String convertToBase7(int num) {
        boolean isNegative = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();

        do{
            sb.insert(0, num % 7);
            num /= 7;
        }while(num > 0);
        return isNegative ? "-" + sb.toString() : sb.toString();
    }
}