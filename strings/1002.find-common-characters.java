// Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

// You may return the answer in any order.

// Example 1:

// Input: ["bella","label","roller"]
// Output: ["e","l","l"]
// Example 2:

// Input: ["cool","lock","cook"]
// Output: ["c","o"]

class Solution {
    public List<String> commonChars(String[] A) {
        int[] common = new int[26];
        Arrays.fill(common, Integer.MAX_VALUE);
        
        for (String word : A) {
            int[] count = new int[26];
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a'] ++;
            }
            for (int i = 0; i < 26; i ++) {
                common[i] = Math.min(common[i], count[i]);
            }
        }
        
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; i ++) {
            if (common[i] != Integer.MAX_VALUE && common[i] > 0) {
                for (int j = 0; j < common[i]; j ++)
                    ans.add(Character.toString((char)(i + 'a')));
            }
        }
        return ans;
    }
}
