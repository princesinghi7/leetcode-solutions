class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        String t = "1" + s + "1";
        int n = t.length();

        List<Integer> runs = new ArrayList<>();
        List<Character> type = new ArrayList<>();

        int i = 0;
        while (i < n) {
            char ch = t.charAt(i);
            int j = i;
            while (j < n && t.charAt(j) == ch) j++;
            type.add(ch);
            runs.add(j - i);
            i = j;
        }

        int ans = ones;

        for (i = 1; i + 1 < runs.size(); i++) {
            if (type.get(i) == '1'
                    && type.get(i - 1) == '0'
                    && type.get(i + 1) == '0') {

                ans = Math.max(ans,
                        ones + runs.get(i - 1) + runs.get(i + 1));
            }
        }

        return ans;
    }
}