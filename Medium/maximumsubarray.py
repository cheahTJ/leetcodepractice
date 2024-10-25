from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        prev_sum = 0
        largest = float('-inf')

        for i in nums:
            curr_sum = prev_sum + i
            if curr_sum < i:  
                curr_sum = i
            
            prev_sum = curr_sum 
            largest = max(largest, curr_sum)  

        return largest