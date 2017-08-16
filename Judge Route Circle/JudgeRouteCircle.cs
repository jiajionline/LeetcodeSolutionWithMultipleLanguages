using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetcodePracticeCsharpVersion
{
    class JudgeRouteCircle
    {
        public bool JudgeCircle(string moves)
        {
            if (string.IsNullOrWhiteSpace(moves)) return true;
            var upAndDownCount = 0;
            var  leftAndRightCount = 0;

            foreach(var c in moves)
            {
                switch (c)
                {
                    case 'U':
                        upAndDownCount++;
                        break;
                    case 'D':
                        upAndDownCount--;
                        break;
                    case 'L':
                        leftAndRightCount--;
                        break;
                    case 'R':
                        leftAndRightCount++;
                        break;
                    default:
                        return false;
                }

            }

            return upAndDownCount == 0 && leftAndRightCount == 0;
        }
    }
}
