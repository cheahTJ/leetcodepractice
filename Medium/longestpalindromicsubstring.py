class Solution:
    def longestPalindrome(self, s: str) -> str:
        pair = []
        curr_longest = 0

        if len(s) <= 1:
            return s

        for index, elem in enumerate(s):
            left = index
            right = index + 1
            # Dealing with odd-length palindrome
            while left >= 0 and right < len(s) and s[left] == s[right]:
                if right - left + 1 > curr_longest:
                    pair = [left, right]
                    curr_longest = right - left + 1
                left -= 1
                right += 1

            left = index - 1
            right = index + 1
            # Dealing with even-length palindrome
            while left >= 0 and right < len(s) and s[left] == s[right]:
                if right - left + 1 > curr_longest:
                    pair = [left, right]
                    curr_longest = right - left + 1
                left -= 1
                right += 1

        return s[pair[0]: pair[1] + 1] if pair else s[0]
