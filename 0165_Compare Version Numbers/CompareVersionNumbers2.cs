public class Solution {
    public int CompareVersion(string version1, string version2)
    	{
        	var ver1 = version1.Split('.');
        	var ver2 = version2.Split('.');

        	int length = Math.Max(ver1.Length, ver2.Length);
        	for (int i = 0; i < length; i++)
        	{
            	var v1 = i < ver1.Length ? int.Parse(ver1[i]) : 0;
            	var v2 = i < ver2.Length ? int.Parse(ver2[i]) : 0;
            	int comp = v1.CompareTo(v2);
            	if (comp != 0)
            	{
                	return comp;
            	}
        	}

        	return 0;
    	}
}