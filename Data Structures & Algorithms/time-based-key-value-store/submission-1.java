class TimeMap {
    List<Triple> list = new ArrayList<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        // Stack is not feasible since you need to be able to process
        // all elements repeatedly, this requires popping off the stack.\
        // FIFO not great, similar problem. => List.
        // TODO: miht have to check if duplicate timestamps.
        list.add(new Triple(key, value, timestamp));

        
    }
    
    public String get(String key, int timestamp) {
        int i = list.size() - 1;
        while (i >= 0) {
            Triple entry = null;
            if ((entry = list.get(i)).key.equals(key) && entry.time <= timestamp) {
                return entry.val;
            }
            i--;
        }
        return "";
        
    }

}

public class Triple {
    public String key;
    public String val;
    public int time;
    public Triple(String key, String val, int timestamp) {
        this.key = key;
        this.val = val;
        this.time = timestamp;
    }

}
