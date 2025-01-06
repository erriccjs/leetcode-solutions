/**
 * @param {string} s
 * @return {boolean}
 * Problem Link: https://leetcode.com/problems/valid-palindrome/
 */
var isPalindrome = function (s) {
  const cleanString = cleanUpString(s);
  for (let i = 0; i < cleanString.length / 2; i++) {
    if (cleanString[i] !== cleanString[cleanString.length - 1 - i]) {
      return false;
    }
  }
  return true;
};

var cleanUpString = function (s) {
  return s.replace(/[^a-zA-Z0-9]/g, '').toLowerCase();
};
