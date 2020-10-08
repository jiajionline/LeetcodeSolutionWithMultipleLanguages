public class Solution {
        public IList<IList<string>> SolveNQueens(int n)
        {
            var ans = new List<IList<string>>();
            var columnForRow = new int[n];

            PlaceQueue(ans, columnForRow, n, 0);
            
            return ans;
        }

        private void PlaceQueue(IList<IList<string>> ans, int[] columnForRow, int n, int row)
        {
            if(row == n)
            {
                Print(ans, columnForRow);
                return;
            }else
            {
                for(int i = 0; i < n; i++)
                {
                    columnForRow[row] = i;
                    if(Check(columnForRow, row))
                    {
                        PlaceQueue(ans, columnForRow, n, row + 1);
                    }
                }
            }
        }

        private bool Check(int[] columnForRow, int row)
        {
            for(int i = 0; i < row; i++)
            {
                int diff = Math.Abs(columnForRow[i] - columnForRow[row]);
                if (diff == 0 || row - i == diff) return false;
            }
            return true;
        }

        private void Print(IList<IList<string>> ret, int[] columnForRow)
        {
            IList<string> oneSolution = new List<string>();
            var sb = new StringBuilder();
            for (int i = 0; i < columnForRow.Length; i++)
            {
                sb.Clear();
                for (int j = 0; j < columnForRow.Length; j++)
                {
                    if (columnForRow[i] == j)
                    {
                        sb.Append("Q");
                    }
                    else
                    {
                        sb.Append(".");
                    }
                }

                oneSolution.Add(sb.ToString());
            }
            ret.Add(oneSolution);
        }
    }