package binarysearch;

import java.util.*;

public class TimeSeriesBasedKeyValue {
    static class Value {
        String val;
        int timeStamp;

        Value(String val, int timeStamp) {
            this.val = val;
            this.timeStamp = timeStamp;
        }
    }

    Map<String, ArrayList<Value>> map;

    public TimeSeriesBasedKeyValue() {
        map = new HashMap<>();
    }

    public  void set(String key, String value, int timestamp) {

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Value>());
        }
        map.get(key).add(new Value(value, timestamp));
    }

    public  String get(String key, int timestamp) {
        String result = "";
        ArrayList<Value> list = map.get(key);
        if (list == null) {
            return result;
        }

        int l = 0, r = list.size() - 1, matchIdx = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (list.get(mid).timeStamp <= timestamp) {
                matchIdx = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (matchIdx != -1)
            return list.get(matchIdx).val;

        return "";
    }

    public static void main(String[] args) {
        TimeSeriesBasedKeyValue timeMap = new TimeSeriesBasedKeyValue();
        timeMap.set("alice", "happy", 1);  // store the key "alice" and value "happy" along with timestamp = 1.
        System.out.println(timeMap.get("alice", 1));           // return "happy"
        System.out.println(timeMap.get("alice", 2));           // return "happy", there is no value stored for timestamp 2, thus we return the value at timestamp 1.
        timeMap.set("alice", "sad", 5);    // store the key "alice" and value "sad" along with timestamp = 3.
        System.out.println(timeMap.get("alice", 3));
        System.out.println(timeMap.get("alice", 400));
    }
}
