public class MapSum {
    private Dictionary<string, int> originalKeyDict;
    private Dictionary<string, int> dict;
    /** Initialize your data structure here. */
    public MapSum () {
        originalKeyDict = new Dictionary<string, int> ();
        dict = new Dictionary<string, int> ();
    }

    public void Insert (string key, int val) {
        var offsetValue = 0;
        if (originalKeyDict.ContainsKey (key)) {
            offsetValue -= originalKeyDict[key];
            offsetValue += val;
            originalKeyDict[key] = val;
        } else {
            originalKeyDict.Add (key, val);
            offsetValue = val;
        }

        for (int i = 0; i < key.Length; i++) {
            var newKey = key.Substring (0, i + 1);
            if (!dict.ContainsKey (newKey))
                dict.Add (newKey, 0);
            dict[newKey] += offsetValue;
        }
    }

    public int Sum (string prefix) {
        if (dict.ContainsKey (prefix))
            return dict[prefix];
        else
            return 0;
    }
}