public class Solution {
       public string AddBinary(string a, string b)
        {
            if (a == null || a.Length == 0) return b;
            if (b == null || b.Length == 0) return a;

            char[] char_arr_a = a.ToCharArray();
            char[] char_arr_b = b.ToCharArray();
            int indexA = char_arr_a.Length - 1;
            int indexB = char_arr_b.Length - 1;

            bool carry = false;
            StringBuilder sb = new StringBuilder();

            while (indexA >=0 || indexB >=0 || carry)
            {
                int result = 0;
                if (indexA >= 0)
                {
                    result += char_arr_a[indexA] - '0';
                    indexA--;
                }

                if (indexB >= 0)
                {
                    result += char_arr_b[indexB] - '0';
                    indexB--;
                }

                if (carry)
                {
                    result += 1;
                }

                carry = result > 1;
                result = result % 2;

                sb.Insert(0, result);
            }

            return sb.ToString();
        }
}
