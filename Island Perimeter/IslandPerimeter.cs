using System;

namespace LeetcodePracticeCsharpVersion
{
    public class IslandPerimeterQuestion
    {
        public int IslandPerimeter(int[,] grid)
        {
            int perimeter = 0;
            for(int i = 0; i < grid.GetLength(0); i++)
            {
                for(int j = 0;j<grid.GetLength(1); j++)
                {
                    if(grid[i,j] == 1)
                    {
                        perimeter += 4;
                        if(i-1 >=0 && grid[i-1,j] == 1)
                        {
                            perimeter--;
                        }

                        if(j-1>=0 && grid[i,j-1] == 1)
                        {
                            perimeter--;
                        }

                        if(i+1 <grid.GetLength(0) && grid[i+1,j] == 1){
                            perimeter--;
                        }

                        if(j+1 < grid.GetLength(1) && grid[i,j+1] == 1)
                        {
                            perimeter--;
                        }
                    }
                }
            }

            return perimeter;
        }
    }
}
