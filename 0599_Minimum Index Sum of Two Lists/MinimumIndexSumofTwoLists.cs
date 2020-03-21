
class Solution
{
    public string[] FindRestaurant(string[] list1, string[] list2)
    {
        var list = new LinkedList<Tuple<string,int>>();

        var dict = new Dictionary<string, int>();
        for(int i=0;i<list1.Length;i++)
        {
            if (!dict.ContainsKey(list1[i]))
            {
                dict.Add(list1[i], i);
            }
        }

        for(int i = 0; i < list2.Length; i++)
        {
            if (dict.ContainsKey(list2[i]))
            {
                int totalIndex = dict[list2[i]] + i;
                
                
                if(list.Count == 0)
                {
                    list.AddLast(new Tuple<string, int>(list2[i], totalIndex));
                }
                else
                {   
                    var existed = list.First;
                    if(existed.Value.Item2 == totalIndex)
                    {
                        list.AddLast(new Tuple<string, int>(list2[i], totalIndex));
                        
                    }else if(existed.Value.Item2 > totalIndex)
                    {
                        list.Clear();
                        list.AddLast(new Tuple<string, int>(list2[i], totalIndex));
                    }
                }
            }
        }

        string[] ret = new string[list.Count];

        for(int i = 0; i < ret.Length; i++)
        {
            ret[i] = list.First.Value.Item1;
            list.RemoveFirst();
        }

        return ret;
    }
}

