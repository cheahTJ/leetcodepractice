from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        length_nums = len(nums) - 1
        max_p = 0  

        for i in range(len(nums)):
            if i > max_p:
                return False
            
            max_p = max(max_p, i + nums[i])
            
            if max_p >= length_nums:
                return True

        return False


