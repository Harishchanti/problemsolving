package datastructure_design;

import java.util.*;

public class UserEventTrackingSystem {

    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        eventManager.recordEvent("userId-1", 100, "click", null);
        eventManager.recordEvent("userId-1", 300, "click", null);
        eventManager.recordEvent("userId-1", 300, "click", null);
        eventManager.recordEvent("userId-1", 250, "click", null);
        eventManager.recordEvent("userId-1", 230, "click", null);
        eventManager.recordEvent("userId-1", 500, "click", null);

        eventManager.recordEvent("userId-1", 100, "pay", null);
        eventManager.recordEvent("userId-1", 300, "view", null);
        eventManager.recordEvent("userId-1", 300, "download", null);
        eventManager.recordEvent("userId-1", 250, "view", null);
        eventManager.recordEvent("userId-1", 230, "download", null);
        eventManager.recordEvent("userId-1", 500, "download", null);

        eventManager.recordEvent("userId-2", 100, "pay", null);
        eventManager.recordEvent("userId-2", 300, "pay", null);
        eventManager.recordEvent("userId-2", 300, "pay", null);
        eventManager.recordEvent("userId-2", 250, "pay", null);
        eventManager.recordEvent("userId-2", 230, "pay", null);
        eventManager.recordEvent("userId-2", 500, "pay", null);

        //   100,230,250,300,300,500
        System.out.println(
                eventManager.getCount("userId-1", "click", 120, 300));//  s: 1 and e: 5 => 5 - 1 =4
        System.out.println(eventManager.getCount("userId-2", 120, 230));//
        System.out.println(eventManager.getCount("userId-1", 120, 230));

    }
}

class EventManager {

    Map<String, Map<String, List<Integer>>> masterData = new HashMap<>();

    public void recordEvent(String userId, int timeStamp, String eventType,
            Map<String, String> metaData) {

        masterData.computeIfAbsent(userId, u -> new HashMap<>());
        masterData.get(userId)
                .computeIfAbsent(eventType, e -> new ArrayList<>())
                .add(timeStamp);

        Collections.sort(masterData.get(userId).get(eventType));// n long n

    }

    public int getCount(String userId, String eventType, int startTime,
            int endTime) {

        if (!masterData.containsKey(userId) || !masterData.get(userId)
                .containsKey(eventType))
            return 0;

        List<Integer> recordList = masterData.get(userId).get(eventType);
        int startIdx = findLowerMatch(recordList, startTime);
        int endIdx = findUpperMatch(recordList, endTime);

        System.out.println(
                "EventType : " + eventType + " startIdx : " + startIdx + " endIdx : " + endIdx);
        return endIdx - startIdx;

    }

    private int findUpperMatch(List<Integer> recordList, int endTime) {
        // 100,230,250,300,300,500
        int l = 0, r = recordList.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (recordList.get(mid) > endTime) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int findLowerMatch(List<Integer> recordList, int startTime) {
        // 100,230,250,300,300,500

        int l = 0, r = recordList.size();
        while (l < r) {

            int mid = l + (r - l) / 2;

            if (recordList.get(mid) >= startTime) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }
        return l;
    }

    public int getCount(String userId, int startTime, int endTime) {

        if (!masterData.containsKey(userId))
            return 0;
        int totalCount = 0;
        for (Map.Entry<String, List<Integer>> entry : masterData.get(userId)
                .entrySet()) {

            totalCount += getCount(userId, entry.getKey(), startTime, endTime);
        }
        return totalCount;
    }
}
