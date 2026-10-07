1import java.util.*;
2
3class Solution {
4
5    public List<List<Integer>> palindromePairs(String[] words) {
6
7        List<List<Integer>> result = new ArrayList<>();
8
9        // Store word -> index
10        Map<String, Integer> map = new HashMap<>();
11
12        for (int i = 0; i < words.length; i++) {
13            map.put(words[i], i);
14        }
15
16        for (int i = 0; i < words.length; i++) {
17
18            String word = words[i];
19            int n = word.length();
20
21            for (int cut = 0; cut <= n; cut++) {
22
23                // Part 1 = word[0 ... cut-1]
24                // Part 2 = word[cut ... n-1]
25
26                // If Part 1 is palindrome,
27                // reverse(Part 2) can come before word
28                if (isPalindrome(word, 0, cut - 1)) {
29
30                    String suffix = word.substring(cut);
31                    String reversed = new StringBuilder(suffix)
32                            .reverse().toString();
33
34                    if (map.containsKey(reversed)) {
35                        int j = map.get(reversed);
36
37                        if (i != j) {
38                            result.add(Arrays.asList(j, i));
39                        }
40                    }
41                }
42
43                // If Part 2 is palindrome,
44                // reverse(Part 1) can come after word
45                // cut != n avoids duplicate when Part 2 is empty
46                if (cut != n && isPalindrome(word, cut, n - 1)) {
47
48                    String prefix = word.substring(0, cut);
49                    String reversed = new StringBuilder(prefix)
50                            .reverse().toString();
51
52                    if (map.containsKey(reversed)) {
53                        int j = map.get(reversed);
54
55                        if (i != j) {
56                            result.add(Arrays.asList(i, j));
57                        }
58                    }
59                }
60            }
61        }
62
63        return result;
64    }
65
66    private boolean isPalindrome(String s, int left, int right) {
67
68        while (left < right) {
69            if (s.charAt(left) != s.charAt(right)) {
70                return false;
71            }
72
73            left++;
74            right--;
75        }
76
77        return true;
78    }
79}