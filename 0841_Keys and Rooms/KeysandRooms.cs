public class Solution {
    public bool CanVisitAllRooms(IList<IList<int>> rooms) {
        if(rooms == null) return false;
        var visited = new HashSet<int>();

        Visit(rooms, 0, visited);

        return visited.Count == rooms.Count;
    }

    private void Visit(IList<IList<int>> rooms, int key, HashSet<int> visited)
    {
        if(visited.Contains(key)) return;
        visited.Add(key);
        foreach(var newkey in rooms[key])
        {
            Visit(rooms, newkey, visited);
        }
    }
}