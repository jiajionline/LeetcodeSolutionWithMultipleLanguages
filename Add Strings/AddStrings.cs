using System.Text;

namespace LeetcodePracticeCsharpVersion
{
    class AddStringsProblem
    {
        public string AddStrings(string num1, string num2)
        {
            if (string.IsNullOrWhiteSpace(num1)) return num2;
            if (string.IsNullOrWhiteSpace(num2)) return num1;
            int index1 = num1.Length - 1;
            int index2 = num2.Length - 1;

            int carry = 0;
            StringBuilder sb = new StringBuilder();

            while(index1 >=0 || index2 >= 0 || carry > 0)
            {
                int value = 0;
                value += carry;

                if(index1 >= 0)
                {
                    value += (num1[index1--] - '0');
                    
                }

                if(index2 >= 0)
                {
                    value += (num2[index2--] - '0');
                }

                carry = value / 10;
                value %= 10;

                sb.Append(value);
            }

            return Reverse(sb.ToString());
        }

        private string Reverse(string s)
        {
            var charArray = s.ToCharArray();
            int i = 0;
            while(i < charArray.Length / 2)
            {
                var temp = charArray[i];
                charArray[i] = charArray[charArray.Length - 1 - i];
                charArray[charArray.Length - 1 - i] = temp;
                i++;
            }

            return new string(charArray);
        }
    }
}
