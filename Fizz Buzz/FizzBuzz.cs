using System.Collections.Generic;

namespace LeetcodePracticeCsharpVersion
{
    class FizzBuzzProblem
    {
        public IList<string> FizzBuzz(int n)
        {
            var retList = new List<string>();
            for(int i = 1; i <= n; i++)
            {
                if(i % 3 == 0 && i % 5 == 0)
                {
                    retList.Add("FizzBuzz");
                }else if(i%3 == 0)
                {
                    retList.Add("Fizz");
                }else if(i % 5== 0)
                {
                    retList.Add("Buzz");
                }
                else
                {
                    retList.Add(i.ToString());
                }
            }
            return retList;
        }
    }
}
