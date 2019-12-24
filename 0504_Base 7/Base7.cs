public class Solution {
    public string ConvertToBase7(int num)
    {
        StringBuilder sb = new StringBuilder();
        bool isNegative = num < 0;
        num = Math.Abs(num);
        do
        {
            var k = num % 7;
            num /= 7;
            sb.Insert(0, k);
        } while (num > 0);

        return isNegative ? "-" + sb.ToString() : sb.ToString();
    }
}