/// learn more:  https://www.geeksforgeeks.org/topological-sorting/
public class Graph
{
    // count of vertices 
    private int V;
    private List<List<int>> adjacentList;

    public Graph(int v)
    {
        V = v;
        adjacentList = new List<List<int>>(V);
        for(int i = 0; i < V; i++)
        {
            adjacentList.Add(new List<int>());
        }
    }

    public void AddEdge(int v, int w)
    {
        adjacentList[v].Add(w);
    }

    public List<int> TopologicalSorting()
    {
        var list = new List<int>(V);
        var stack = new Stack<int>(V);
        var visited = new bool[V];

        for(int i = 0; i < V; i++)
        {
            TopologicalSorting(i, visited,adjacentList,  stack);
        }

        while (stack.Count > 0)
        {
            list.Add(stack.Pop());
        }

        return list;
    }

    private void TopologicalSorting(int v, bool[] visited, List<List<int>> adjacentList, Stack<int> stack)
    {
        if (visited[v]) return;

        visited[v] = true;
        foreach(var vertex in adjacentList[v])
        {
            TopologicalSorting(vertex, visited, adjacentList, stack);
        }

        stack.Push(v);

    }

    static void Main(string[] args)
    {

        Graph g = new Graph(6);
        g.AddEdge(5, 2);
        g.AddEdge(5, 0);
        g.AddEdge(4, 0);
        g.AddEdge(4, 1);
        g.AddEdge(2, 3);
        g.AddEdge(3, 1);

        Console.WriteLine("Following is a Topological sort of the given graph");

        var result = g.TopologicalSorting();
        foreach(var r in result)
        {
            Console.WriteLine(r);
        }
        Console.Read();

    }
}