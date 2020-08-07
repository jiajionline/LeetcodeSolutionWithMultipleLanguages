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
        
        return GetImportance(dict[id], dict);
    }

    private int GetImportance(Employee employee, Dictionary<int, Employee> dict){
        if(employee == null) return 0;
        int importance = 0;
        if(employee.subordinates != null){
            foreach(var emp in employee.subordinates)
                importance += GetImportance(dict[emp], dict);
        }

        return importance + employee.importance; 
    }
}