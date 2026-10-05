1class Solution {
2
3    class TrieNode {
4        TrieNode[] child = new TrieNode[26];
5        int index = -1;
6    }
7
8    TrieNode root = new TrieNode();
9    String[] words;
10
11    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
12
13        words = wordsContainer;
14
15        // Build Trie using reversed strings
16        for (int i = 0; i < words.length; i++) {
17            insert(words[i], i);
18        }
19
20        int[] ans = new int[wordsQuery.length];
21
22        for (int i = 0; i < wordsQuery.length; i++) {
23            ans[i] = search(wordsQuery[i]);
24        }
25
26        return ans;
27    }
28
29    private void insert(String word, int index) {
30
31        TrieNode node = root;
32
33        // Update root for empty suffix
34        update(node, index);
35
36        // Insert from right to left
37        for (int i = word.length() - 1; i >= 0; i--) {
38
39            int c = word.charAt(i) - 'a';
40
41            if (node.child[c] == null) {
42                node.child[c] = new TrieNode();
43            }
44
45            node = node.child[c];
46
47            update(node, index);
48        }
49    }
50
51    private void update(TrieNode node, int index) {
52
53        if (node.index == -1 ||
54            words[index].length() < words[node.index].length()) {
55
56            node.index = index;
57        }
58    }
59
60    private int search(String word) {
61
62        TrieNode node = root;
63
64        // Initially, answer for empty suffix
65        int answer = root.index;
66
67        // Search from right to left
68        for (int i = word.length() - 1; i >= 0; i--) {
69
70            int c = word.charAt(i) - 'a';
71
72            if (node.child[c] == null) {
73                break;
74            }
75
76            node = node.child[c];
77
78            answer = node.index;
79        }
80
81        return answer;
82    }
83}