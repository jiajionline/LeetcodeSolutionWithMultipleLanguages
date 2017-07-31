namespace LeetcodePracticeCsharpVersion
{
    class UglyNumber
    {
        public bool IsUgly(int num)
        {
            if (num <= 0) return false;
            if (num == 1) return true;
            int[] sequence = new int [] { 2, 3, 5 };
            for(int i = 0; i < sequence.Length; i++)
            {
                int v = sequence[i];
                while(num % v == 0)
                {
                    num /= v;
                }
            }

            return num == 1;
        }
    }
}
