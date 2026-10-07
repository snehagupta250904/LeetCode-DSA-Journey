1import java.util.*;
2
3class SummaryRanges {
4
5    TreeMap<Integer, Integer> map;
6
7    public SummaryRanges() {
8        map = new TreeMap<>();
9    }
10
11    public void addNum(int value) {
12
13        // Already present
14        if (map.containsKey(value)) {
15            return;
16        }
17
18        // Interval just before value
19        Integer left = map.floorKey(value);
20
21        // Interval just after value
22        Integer right = map.ceilingKey(value);
23
24        // Connect with left interval
25        if (left != null && map.get(left) + 1 >= value) {
26
27            // Also connect with right interval
28            if (right != null && right == value + 1) {
29                map.put(left, map.get(right));
30                map.remove(right);
31            } else {
32                map.put(left, Math.max(map.get(left), value));
33            }
34
35        }
36        // Connect with right interval
37        else if (right != null && right == value + 1) {
38
39            int end = map.get(right);
40            map.remove(right);
41            map.put(value, end);
42
43        }
44        // Create new interval
45        else {
46            map.put(value, value);
47        }
48    }
49
50    public int[][] getIntervals() {
51
52        int[][] result = new int[map.size()][2];
53
54        int i = 0;
55
56        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
57            result[i][0] = entry.getKey();
58            result[i][1] = entry.getValue();
59            i++;
60        }
61
62        return result;
63    }
64}