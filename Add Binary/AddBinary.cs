using System;
using System.Text;

namespace LeetcodePracticeCsharpVersion
{
    class AddBinaryQuestion
    {
        public string AddBinary(string a, string b)
        {
            if (string.IsNullOrWhiteSpace(a)) return b;
            if (string.IsNullOrWhiteSpace(b)) return a;

            StringBuilder sb = new StringBuilder();

            int index1 = a.Length - 1;
            int index2 = b.Length - 1;
            bool carry = false;
            while(index1 >= 0 || index2 >= 0 || carry)
            {
                int k = 0;
                if(index1 >= 0)
                {
                    k += (a[index1--] - '0');
                }

                if(index2 >= 0)
                {
                    k += (b[index2--] - '0');
                }

                if (carry)
                {
                    k += 1;
                    carry = false;
                }

                if(k == 0)
                {
                    sb.Append('0');
                }else if(k == 1)
                {
                    sb.Append('1');
                }else if(k == 2)
                {
                    sb.Append('0');
                    carry = true;
                }
            }

            char[] arr = sb.ToString().ToCharArray();
            Array.Reverse(arr);
            return new string(arr);
        }
    }
}
