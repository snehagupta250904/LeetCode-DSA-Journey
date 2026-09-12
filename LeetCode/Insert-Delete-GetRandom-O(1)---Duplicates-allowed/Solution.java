1class RandomizedCollection {
2
3    private List<Integer> list;
4    private Map<Integer, Set<Integer>> map;
5    private Random random;
6
7    public RandomizedCollection() {
8        list = new ArrayList<>();
9        map = new HashMap<>();
10        random = new Random();
11    }
12
13    public boolean insert(int val) {
14
15        boolean notPresent = !map.containsKey(val);
16
17        // Add value at the end
18        list.add(val);
19
20        // Add its index to the set
21        map.computeIfAbsent(val, k -> new HashSet<>())
22           .add(list.size() - 1);
23
24        return notPresent;
25    }
26
27    public boolean remove(int val) {
28
29        // Value doesn't exist
30        if (!map.containsKey(val) || map.get(val).isEmpty()) {
31            return false;
32        }
33
34        // Get any index of val
35        Set<Integer> indices = map.get(val);
36        int removeIndex = indices.iterator().next();
37
38        // Last element in the list
39        int lastIndex = list.size() - 1;
40        int lastValue = list.get(lastIndex);
41
42        // Remove the selected index from val's set
43        indices.remove(removeIndex);
44
45        // If removing something other than the last element
46        if (removeIndex != lastIndex) {
47
48            // Put lastValue into removeIndex
49            list.set(removeIndex, lastValue);
50
51            // Update lastValue's indices
52            Set<Integer> lastValueIndices = map.get(lastValue);
53
54            lastValueIndices.remove(lastIndex);
55            lastValueIndices.add(removeIndex);
56        }
57
58        // Remove last element
59        list.remove(lastIndex);
60
61        // If no occurrences remain, remove key
62        if (indices.isEmpty()) {
63            map.remove(val);
64        }
65
66        return true;
67    }
68
69    public int getRandom() {
70
71        int index = random.nextInt(list.size());
72
73        return list.get(index);
74    }
75}