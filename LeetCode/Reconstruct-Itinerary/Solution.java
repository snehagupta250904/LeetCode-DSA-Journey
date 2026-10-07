1import java.util.*;
2
3class Solution {
4    public List<String> findItinerary(List<List<String>> tickets) {
5
6        // Min-heap for lexical smallest destination
7        Map<String, PriorityQueue<String>> graph = new HashMap<>();
8
9        for (List<String> ticket : tickets) {
10            String from = ticket.get(0);
11            String to = ticket.get(1);
12
13            graph.putIfAbsent(from, new PriorityQueue<>());
14            graph.get(from).offer(to);
15        }
16
17        LinkedList<String> result = new LinkedList<>();
18
19        dfs("JFK", graph, result);
20
21        return result;
22    }
23
24    private void dfs(String airport,
25                     Map<String, PriorityQueue<String>> graph,
26                     LinkedList<String> result) {
27
28        PriorityQueue<String> destinations = graph.get(airport);
29
30        while (destinations != null && !destinations.isEmpty()) {
31            String next = destinations.poll();
32            dfs(next, graph, result);
33        }
34
35        // Add after using all outgoing tickets
36        result.addFirst(airport);
37    }
38}