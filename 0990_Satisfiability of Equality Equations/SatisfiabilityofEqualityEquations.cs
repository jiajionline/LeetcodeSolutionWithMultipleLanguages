public class Solution
{
    private readonly int[] parents = new int[26];
    public bool EquationsPossible(string[] equations)
    {

        for (int i = 0; i < 26; i++)
            parents[i] = i;

        foreach (var eq in equations)
        {
            if (eq[1] == '=')
                parents[Find(eq[0]-'a')] = Find(eq[3]-'a');
        }

        foreach (var equation in equations)
        {
            if (equation[1] == '!' && Find(equation[0]-'a') == Find(equation[3] - 'a')) return false;
        }

        return true;
    }

    private int Find(int x)
    {
        if (x != parents[x]) parents[x] = Find(parents[x]);
        return parents[x];
    }
}