// Problem Link: https://leetcode.com/problems/valid-palindrome/
package Java.Easy;

class Solution {
    public boolean isPalindrome(String s) {
        // Clean up the string
        String cleanedString = cleanUpString(s);
        // Convert the cleaned string to a char array
        char[] charArray = cleanedString.toCharArray();

        // Check if the string is a palindrome
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private String cleanUpString(String input) {
        // If the input is null or empty, return an empty string
        if ((input == null) || (input == "")) {
            return "";
        }
        // Remove all non-alphanumeric characters and convert to lowercase
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
}