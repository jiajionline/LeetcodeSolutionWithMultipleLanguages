using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetcodePracticeCsharpVersion
{
    class FriendCircles
    {
        public int FindCircleNum(int[,] M)
        {
            bool[] visited = new bool[M.GetLength(0)];
            int count = 0;
            for (int i = 0; i < M.GetLength(0); i++)
            {
                if (visited[i] == false)
                {
                    DepthFirstSearch(M, visited, i);
                    count++;
                }
            }
            return count;
        }
        

        private void DepthFirstSearch(int[,] M, bool[] visited, int i)
        {
            for(int j = 0; j < M.GetLength(1); j++)
            {
                if(M[i,j] == 1 && visited[j] == false)
                {
                        visited[j] = true;
                        DepthFirstSearch(M, visited, j);
                 }
            }
        }
    }
}
