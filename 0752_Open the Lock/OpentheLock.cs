public class Solution
    {
        public int OpenLock(string[] deadends, string target)
        {
            var start = "0000";
            if(start == target) return 0;
            
            var deadendSet = new HashSet<string>();
            foreach (var deadend in deadends) deadendSet.Add(deadend);
            if (deadendSet.Contains(start)) return -1;
            
            var visited = new HashSet<string>();
            visited.Add(start);
            
            var queue = new Queue<string>();
            queue.Enqueue(start);

            var steps = 0;
            while (queue.Count > 0)
            {
                steps++;
                var s = queue.Count;
                while (s-- > 0)
                {
                    var currLock = queue.Dequeue();

                    for (int i = 0; i < 4; i++)
                    {
                        for (int j = -1; j <= 1; j+=2)
                        {
                            var char_arr = currLock.ToCharArray();
                            char_arr[i] = (char)(((char_arr[i] - '0') + j + 10) % 10 + '0');

                            var nextLock = new string(char_arr);

                            if (nextLock == target) return steps;
                            
                            if (deadendSet.Contains(nextLock) || visited.Contains(nextLock)) continue;
                            
                            queue.Enqueue(nextLock);
                            visited.Add(nextLock);
                            
                        }  
                    }
                }
            }

            return -1;
        }

    }