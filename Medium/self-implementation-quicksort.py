from typing import List

class QuickSort:
    def own_quick_sort(self, nums: List[int]) -> List[int]:
        if len(nums) <= 1:
            return nums
        else:
            i = 0
            j = 0
            k = len(nums) - 1
            pivot = nums[k]
            while j < k:
                if nums[j] > pivot:
                    j += 1
                else:
                    nums[i], nums[j] = nums[j], nums[i]
                    i += 1
                    j += 1
            nums[i], nums[k] = nums[k], nums[i]
            left_sorted = self.own_quick_sort(nums[:i])
            right_sorted = self.own_quick_sort(nums[i+1:])
            return left_sorted + [nums[i]] + right_sorted

# Example usage:
sorter = QuickSort()
unsorted_nums = [3, 6, 8, 10, 1, 2, 1]
sorted_nums = sorter.own_quick_sort(unsorted_nums)
print(sorted_nums)  # Output: [1, 1, 2, 3, 6, 8, 10]
