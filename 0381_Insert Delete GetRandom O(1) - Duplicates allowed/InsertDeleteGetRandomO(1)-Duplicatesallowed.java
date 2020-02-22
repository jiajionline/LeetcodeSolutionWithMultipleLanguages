class RandomizedCollection {
    class Entry {
      public int value;
      public int index;
      public Entry(int val, int idx) {
        value = val;
        index = idx;
      }
    }
    
    private Map<Integer, List<Integer>> m;
    private List<Entry> vals;
    private Random rand;
   
    /** Initialize your data structure here. */
    public RandomizedCollection() {
      m = new HashMap<>();
      vals = new ArrayList<>();
      rand = new Random();
    }
   
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {    
      List<Integer> l = m.getOrDefault(val, new ArrayList<Integer>());
      l.add(vals.size());
      m.put(val, l);
      vals.add(new Entry(val, l.size() - 1));
      return l.size() == 1;
    }
   
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {    
      if (!m.containsKey(val)) return false;
      List<Integer> l = m.get(val);
      int index_to_evict = l.get(l.size() - 1);
      Entry last_entry = vals.get(vals.size() - 1);
   
      // Update index
      m.get(last_entry.value).set(last_entry.index, index_to_evict);
   
      // Swap vals
      vals.set(index_to_evict, last_entry);    
   
      // Cleanup
      vals.remove(vals.size() - 1);
      l.remove(l.size() - 1);
      if (l.size() == 0) m.remove(val);
   
      return true;
    }
   
    /** Get a random element from the collection. */
    public int getRandom() {    
      return vals.get(rand.nextInt(vals.size())).value;
    }
  }