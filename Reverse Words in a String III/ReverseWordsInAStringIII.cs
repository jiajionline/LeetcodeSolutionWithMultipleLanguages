namespace LeetcodePracticeCsharpVersion
{
    class ReverseWordsInAStringIII
    {
        public string ReverseWords(string s)
        {
            char[] charArray = s.ToCharArray();
            int left = 0;
            int right = 0;

            while(left <= right && right < s.Length)
            {
                if(charArray[left] == ' ' && charArray[right] == ' ')
                {
                    left++;
                    right++;
                }else
                {
                    while (right < s.Length && charArray[right] != ' ')
                    {
                        right++;
                    }

                    InnerReverse(charArray, left, right - 1);
                    left = right;
                }                
            }

            return new string(charArray);

        }

        private void InnerReverse(char[] charArray, int left, int right)
        {
            while(left < right){
                var temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }

        }
    }
}
