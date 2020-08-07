/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public IList<int> subordinates;
}
*/

class Solution {
    public int GetImportance(IList<Employee> employees, int id) {
        int totalImportance = 0;
        var dict = new Dictionary<int, Employee>();
        foreach(var emp in employees){
            if(!dict.ContainsKey(emp.id)) dict.Add(emp.id, emp);
        }
        
        var queue = new Queue<int>();
        queue.Enqueue(id);
        
        while(queue.Count > 0){
            var emp = dict[queue.Dequeue()];
            totalImportance += emp.importance;
            if(emp.subordinates!=null){
                foreach(var sub in emp.subordinates){
                    queue.Enqueue(sub);
                }
            }
        }
        
        return totalImportance;
    }
}