using System.Text;

namespace LeetcodePracticeCsharpVersion
{
    class RepeatedSubstringPatternProblem
    {
        public bool RepeatedSubstringPattern(string s)
        {
            int currentIndex = s.Length / 2;
            while(currentIndex > 0)
            {
                if(s.Length % currentIndex == 0)
                {
                    var firstString = s.Substring(0, currentIndex);
                    StringBuilder sb = new StringBuilder();
                    int appendCount = s.Length / currentIndex ;
                    while(appendCount-- > 0)
                    {
                        sb.Append(firstString);
                    }

                    if (sb.ToString().Equals(s)) return true;
                }
                currentIndex--;
            }

            return false;
        }
    }
}
