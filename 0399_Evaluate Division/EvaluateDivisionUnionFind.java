
class Solution {
    class Node {
      public String parent;
      public double ratio;
      public Node(String parent, double ratio) {
        this.parent = parent;
        this.ratio = ratio;
      }
    }
    
    class UnionFindSet {
      private Map<String, Node> parents = new HashMap<>();
      
      public Node find(String s) {
        if (!parents.containsKey(s)) return null;
        Node n = parents.get(s);
        if (!n.parent.equals(s)) {
          Node p = find(n.parent);
          n.parent = p.parent;
          n.ratio *= p.ratio;
        }
        return n;
      }
      
      public void union(String s, String p, double ratio) {
        boolean hasS = parents.containsKey(s);
        boolean hasP = parents.containsKey(p);
        if (!hasS && !hasP) {
          parents.put(s, new Node(p, ratio));
          parents.put(p, new Node(p, 1.0));
        } else if (!hasP) {
          parents.put(p, new Node(s, 1.0 / ratio));
        } else if (!hasS) {
          parents.put(s, new Node(p, ratio));
        } else {
          Node rS = find(s);
          Node rP = find(p);
          rS.parent = rP.parent;
          rS.ratio = ratio / rS.ratio * rP.ratio;
        }
      }
    }
    
     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
      UnionFindSet u = new UnionFindSet();
      
      for (int i = 0; i < equations.size(); ++i)
        u.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
      
      double[] ans = new double[queries.size()];
      
      for (int i = 0; i < queries.size(); ++i) {      
        Node rx = u.find(queries.get(i).get(0));
        Node ry = u.find(queries.get(i).get(1));
        if (rx == null || ry == null || !rx.parent.equals(ry.parent))
          ans[i] = -1.0;        
        else
          ans[i] = rx.ratio / ry.ratio;
      }
      
      return ans;
    }
  }