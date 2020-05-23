// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

// Examples:

// s = "leetcode"
// return 0.

// s = "loveleetcode",
// return 2.
// Note: You may assume the string contain only lowercase letters.

class Node {
    int index, count;
    public Node(int index, int count) {
        this.count = count;
        this.index = index;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Node> hm = new HashMap<Character, Node>();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i ++) {
            if (hm.containsKey(s.charAt(i)))
                hm.get(s.charAt(i)).count++;
            else
                hm.put(s.charAt(i), new Node(i, 1));
        }
        for (Character key : hm.keySet()) {
            if (hm.get(key).count == 1 && hm.get(key).index < result)
                result = hm.get(key).index;
        }
        if (result != Integer.MAX_VALUE)
            return result;
        return -1;
    }
}
