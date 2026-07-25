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


        //bsearch + linear probe.
        int l = 0;
        int r = i;
        while (l <= r) {
            int mid = (l + r) / 2;
            int median = list.get(mid).time;
            if (median > timestamp) {
                r = mid - 1;
            } else if (median < timestamp) {
                l = mid + 1;
            } else {
                break;
            }
        }

        while (r >= 0) {
            Triple entry = null;
            if ((entry = list.get(r)).key.equals(key) && entry.time <= timestamp) {
                return entry.val;
            }
            r--;
        }

        return ""; 





        // linear probe.

        // while (i >= 0) {
        //     Triple entry = null;
        //     if ((entry = list.get(i)).key.equals(key) && entry.time <= timestamp) {
        //         return entry.val;
        //     }
        //     i--;
        // }
        // return "";
        
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
