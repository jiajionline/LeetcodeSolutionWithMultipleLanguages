public class Solution {
   public IList<double> AverageOfLevels(TreeNode root)
    	{
        	var dict = new Dictionary<int, Pair>();
        	Traverse(root, 1, dict);

        	var ret = new List<double>();
        	for(int i = 1; i <= dict.Count; i++)
        	{
            	var entry = dict[i];
            	ret.Add(entry.Sum / entry.Count);
        	}

        	return ret;
    	}

    	private void Traverse(TreeNode node, int level, Dictionary<int, Pair> dict)
    	{
        	if (node == null) return;
        	var v = node.val;
        	if (!dict.ContainsKey(level)) dict.Add(level, new Pair());
        	dict[level].Sum += node.val;
        	dict[level].Count += 1;
        	Traverse(node.left, level + 1, dict);
        	Traverse(node.right, level + 1, dict);
    	}
	}

	class Pair
	{
    	public double Sum { get; set; }
    	public int Count { get; set; }
	}
