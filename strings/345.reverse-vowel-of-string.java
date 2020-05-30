// Write a function that takes a string as input and reverse only the vowels of a string.

// Example 1:

// Input: "hello"
// Output: "holle"
// Example 2:

// Input: "leetcode"
// Output: "leotcede"

class Solution {
    
    public String reverseVowels(String s) {
        char[] tempStr = s.toCharArray();
        int left = 0, right = s.length()-1;
        
        while (left < right) {
            if (isVowel(tempStr[left]) && isVowel(tempStr[right])) {
                swap(tempStr, left, right);
                left ++;
                right --;
            }
            else if (isVowel(tempStr[left]))
                right --;
            else
                left ++;   
        }
        return new String(tempStr);
    }
    
    private boolean isVowel(char key) {
        return key == 'a' || key == 'e' || key == 'i' || key == 'o' || key == 'u' ||                key == 'A' || key == 'E' || key == 'I' || key == 'O' || key == 'U';
    }
    
    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
