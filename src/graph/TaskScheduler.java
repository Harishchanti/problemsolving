package graph;

import java.util.*;

public class TaskScheduler {
    static class Work {
        String type;
        String name;

        Work(String type, String name) {
            this.type = type;
            this.name = name;
        }

    }

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        //
        /*

        A system contains Tasks and Task Groups.Your goal is to determine the order in which Tasks are executed starting from a given entry point.


Definitions
Task
A Task is a unit of work identified by a unique name.
Example:
T1
T2


Task Group
A Task Group contains one or more Tasks or other Task Groups.
Children are executed from left to right in the given order.
Example:
G1 -> [T1, T2]
G2 -> [T3, G1]


Task Dependency
A Task may depend on other Tasks.
A Task can execute only after all its dependencies are executed.
Example:
T1 depends on T4, T6
means:
T4 and T6 must execute before T1



Execution Rules
1. A Task is executed only after all its dependencies are executed.
2. A Task Group executes its children in the given order (left to right).
3. A Task is executed at most once.
4. If a Task is already executed, it is not executed again.
5. Dependencies exist only between Tasks (not Groups).
6. There are no cyclic dependencies.

Note:
* Task and Group names are unique.
* No cyclic dependencies exist.


Example 1
Input
6 2 2
TASK T1
TASK T2
TASK T3
TASK T4
TASK T5
TASK T6
GROUP G1 2 TASK T1 TASK T2
GROUP G2 2 TASK T3 GROUP G1
DEPENDENCY T1 2 T4 T6
DEPENDENCY T3 2 T4 T5

START GROUP G2
START TASK  T1

Output
T4 T5 T3 T6 T1 T2

G2 : T3 , T1, T2


T1 : T4 , T6

out: T4, T6, T1





        */
        Work t1 = new Work("TASK", "T1");
        Work t2 = new Work("TASK", "T2");
        Work t3 = new Work("TASK", "T3");
        Work t4 = new Work("TASK", "T4");
        Work t5 = new Work("TASK", "T5");
        Work t6 = new Work("TASK", "T6");

        Work g1 = new Work("GROUP", "G1");
        Work g2 = new Work("GROUP", "G2");

        Map<String, List<Work>> taksDepMap = new HashMap<>();
        taksDepMap.put(t1.name, Arrays.asList(t4, t6));
        taksDepMap.put(t3.name, Arrays.asList(t4, t5));

        taksDepMap.put(t2.name, new ArrayList<>());
        taksDepMap.put(t4.name, new ArrayList<>());
        taksDepMap.put(t5.name, new ArrayList<>());
        taksDepMap.put(t6.name, new ArrayList<>());

        Map<String, List<Work>> groupMap = new HashMap<>();
        groupMap.put(g1.name, Arrays.asList(t1, t2));
        groupMap.put(g2.name, Arrays.asList(t3, g1));

        Work workStart = g1;

        List<String> taskList = new ArrayList<>();
        buildTaskList(workStart.name, workStart.type, groupMap, taksDepMap,
                taskList);
        System.out.println(taskList);

        Map<String, List<String>> adjMap = buildAdjMap(taskList, taksDepMap);
        System.out.println(adjMap);

        //List<String> result = topolgicalSort(adjMap);
        List<String> result = new ArrayList<>();
        for(String s : taskList) {
            DFSImpl(adjMap,s,result);
        }
        System.out.println(result);

    }

    private static void DFSImpl(Map<String, List<String>> adjMap,String name,List<String> result) {

        for(String d : adjMap.get(name)) {
            if(!result.contains(d)) {
                DFSImpl(adjMap, d, result);
            }
        }
        if(!result.contains(name)) {
            result.add(name);
        }
    }

    static List<String> topolgicalSort(Map<String, List<String>> adj) {

        // List<String> result
        List<String> result = new ArrayList<>();
        Map<String, Integer> indegreeMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for (Map.Entry<String, List<String>> d : adj.entrySet()) {
            indegreeMap.put(d.getKey(), d.getValue().size());
            if (d.getValue().isEmpty()) {
                queue.add(d.getKey());
            }
        }

        List<String> l = new ArrayList<>(queue);
        System.out.println(l);

        while (!queue.isEmpty()) {

            String name = queue.poll();
            result.add(name);

            for (String s : adj.get(name)) {

                int count = indegreeMap.get(s) - 1;
                indegreeMap.put(s, count);

                if (count == 0) {
                    queue.add(s);
                }
            }
        }

        return result;

    }

    static Map<String, List<String>> buildAdjMap(List<String> taskList,
            Map<String, List<Work>> taksDepMap) {
        Map<String, List<String>> adjMap = new HashMap<>();

        /*for(Map.Entry<String,List<Work>> t : taksDepMap.entrySet()) {

            List<String> list = new ArrayList<String>();

            if(taskList.contains(t.getKey())) {

                if(taksDepMap.containsKey(t)) {
                    for(Work s : taksDepMap.get(t)) {
                        list.add(s.name);
                    }
                }
            }

            adjMap.put(t.getKey(),list);
        }

        return adjMap;*/

        for (String t : taskList) {
            List<String> list = new ArrayList<>();

            if (taksDepMap.containsKey(t)) {
                for (Work s : taksDepMap.get(t)) {
                    list.add(s.name);
                }
            }
            adjMap.put(t, list);
        }

        for (Map.Entry<String, List<Work>> t : taksDepMap.entrySet()) {
            List<String> list = new ArrayList<String>();

            if (!adjMap.containsKey(t.getKey())) {

                if (t.getValue() != null) {
                    for (Work a : t.getValue()) {
                        list.add(a.name);
                    }
                }
                adjMap.put(t.getKey(), list);

               /* for (Work w : t.getValue()) {
                    list.add(w.name);
                    adjMap.put(t.getKey(), list);
                }*/
            }
        }

        return adjMap;

    }

    static void buildTaskList(String name, String type,
            Map<String, List<Work>> groupMap,
            Map<String, List<Work>> taksDepMap, List<String> taskList) {
        //List<String>  taksList = new ArrayList<>();

        if (type.equals("GROUP")) {

            for (Work w : groupMap.get(name)) {

                if (w.type.equals("GROUP")) {
                    buildTaskList(w.name, w.type, groupMap, taksDepMap,
                            taskList);
                } else {
                    taskList.add(w.name);
                }
            }
        } else {

            for (Work w : taksDepMap.get(name)) {
                taskList.add(w.name);
            }
        }

    }
}
