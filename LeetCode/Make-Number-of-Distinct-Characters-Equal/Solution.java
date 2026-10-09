1class Solution {
2    public boolean isItPossible(String word1, String word2) {
3        int[] cnt1 = new int[26];
4        int[] cnt2 = new int[26];
5        for (int i = 0; i < word1.length(); ++i) {
6            ++cnt1[word1.charAt(i) - 'a'];
7        }
8        for (int i = 0; i < word2.length(); ++i) {
9            ++cnt2[word2.charAt(i) - 'a'];
10        }
11        for (int i = 0; i < 26; ++i) {
12            for (int j = 0; j < 26; ++j) {
13                if (cnt1[i] > 0 && cnt2[j] > 0) {
14                    --cnt1[i];
15                    --cnt2[j];
16                    ++cnt1[j];
17                    ++cnt2[i];
18                    int d = 0;
19                    for (int k = 0; k < 26; ++k) {
20                        if (cnt1[k] > 0) {
21                            ++d;
22                        }
23                        if (cnt2[k] > 0) {
24                            --d;
25                        }
26                    }
27                    if (d == 0) {
28                        return true;
29                    }
30                    ++cnt1[i];
31                    ++cnt2[j];
32                    --cnt1[j];
33                    --cnt2[i];
34                }
35            }
36        }
37        return false;
38    }
39}