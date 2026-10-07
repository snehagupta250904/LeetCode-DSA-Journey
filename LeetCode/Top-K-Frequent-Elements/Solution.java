1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        Map<Integer, Long> frequency = Arrays.stream(nums).boxed().collect(
4            Collectors.groupingBy(Function.identity(), Collectors.counting()));
5        Queue<Map.Entry<Integer, Long>> queue = new PriorityQueue<>(Map.Entry.comparingByValue());
6        for (var entry : frequency.entrySet()) {
7            queue.offer(entry);
8            if (queue.size() > k) {
9                queue.poll();
10            }
11        }
12        return queue.stream().mapToInt(Map.Entry::getKey).toArray();
13    }
14}