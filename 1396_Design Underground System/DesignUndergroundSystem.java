class UndergroundSystem {
    
    // the key is startStation, the value is a map collection of endStation from this startStation
    private Map<String, Map<String, StationStat>> map;
    // the key is the card id, the value is the check in startStationName and it's time,
    // we cache and evict the data untill checkout happens on that person.
    private Map<Integer, Pair<String, Integer>> checkInLogs;
    public UndergroundSystem() {
        map = new HashMap<>();
        checkInLogs = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInLogs.put(id, new Pair<String, Integer>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInLog = checkInLogs.get(id);
        checkInLogs.remove(id);
        String startStation = checkInLog.getKey();
        int startTime = checkInLog.getValue();
        
        if(!map.containsKey(startStation)) map.put(startStation, new HashMap<String, StationStat>());
        Map<String, StationStat> innerMap = map.get(startStation);
        
        StationStat stat = null;
        if(innerMap.containsKey(stationName)) {
            stat = innerMap.get(stationName);
        }else {
            stat = new StationStat();
            stat.startStation = startStation;
            stat.endStation = stationName;
            innerMap.put(stationName, stat);
        }
        
        stat.count++;
        stat.totalTime += (t - startTime);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        if(map.containsKey(startStation)) {
            Map<String, StationStat> innerMap = map.get(startStation);
            if(innerMap.containsKey(endStation)) {
                StationStat stat = innerMap.get(endStation);
                if(stat.count == 0) return 0.0;
                return (double)stat.totalTime / (double)stat.count;
            }
            
            return 0.0;
        }
        
        return 0.0;
    }
}

class StationStat {
    String startStation;
    String endStation;
    int count;
    int totalTime;
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */