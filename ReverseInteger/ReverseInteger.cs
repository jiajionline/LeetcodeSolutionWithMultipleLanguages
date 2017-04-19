using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetcodePracticeCsharpVersion
{
    class ReverseInteger
    {
        public int Reverse(int x)
        {
            long value = 0;
            bool negative = x < 0;
            long y = x;
            y = Math.Abs(y);

            while (y > 0)
            {
                value *= 10;
                value += y % 10;
                y /= 10;
            }

            if(value > int.MaxValue)
            {
                return 0;
            }

            int ret = (int)value;

            if (negative)
            {
                return 0 - ret;
            }
            else
            {
                return ret;
            }
        }
    }
}
