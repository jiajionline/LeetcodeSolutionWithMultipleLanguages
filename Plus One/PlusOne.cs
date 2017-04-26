using System;
namespace LeetcodePracticeCsharpVersion
{
    class PlusOneProlem
    {
        public int[] PlusOne(int[] digits)
        {
            if (digits == null | digits.Length == 0) return new int[0];

            int[] tempArray = new int[digits.Length];
            Array.Copy(digits, tempArray, digits.Length);
            int carry = 1;
            for (var i = digits.Length - 1; i >= 0 && carry > 0; i--)
            {
                int v = digits[i];
                v += carry;
                tempArray[i] = v % 10;
                carry = v / 10;
            }
            
            if (carry == 0)
            {
                return tempArray;
            }
            else
            {
                int[] retArray = new int[tempArray.Length + 1];
                retArray[0] = carry;
                for(int i = 0; i < tempArray.Length; i++)
                {
                    retArray[i + 1] = tempArray[0];
                }

                return retArray;
            }
            
        }
    }
}
