public class Solution{
        public string DecodeString(string s)
        {
            var buffer = new StringBuilder() ;
            var countStack = new Stack<int>();
            var resourceStack = new Stack<string>();

            int index = 0;

            while (index < s.Length)
            {
                if (char.IsDigit(s[index]))
                {
                    int count = 0;
                    while (char.IsDigit(s[index]))
                    {
                        count = count * 10 + (s[index++] - '0');
                    }
                    countStack.Push(count);

                }
                else if (s[index] == '[')
                {
                    resourceStack.Push(buffer.ToString());
                    buffer.Clear();
                    index++;
                }
                else if (s[index] == ']')
                {
                    var sb = new StringBuilder(resourceStack.Pop());
                    var count = countStack.Pop();
                    for (int i = 0; i < count; i++)
                    {
                        sb.Append(buffer);
                    }

                    buffer.Clear();
                    buffer.Append(sb);
                    index++;
                }
                else
                {
                    buffer.Append(s[index++]);
                }
            }

            return buffer.ToString();
        }
    }