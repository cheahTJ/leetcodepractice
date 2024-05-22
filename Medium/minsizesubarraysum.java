import java.util.ArrayList;


// This set of solution will find the LAST subarray that hits the target and NOT the smallest subarray

class Solution {
    public int minSubArrayLen(int target, int[] nums) {

            int minLength = Integer.MAX_VALUE;
            int leftPointer = 0;
            int currSum = 0;
    
            for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {
                currSum += nums[rightPointer];
    
                while (currSum >= target) {
                    minLength = Math.min(minLength, rightPointer - leftPointer + 1);
                    currSum -= nums[leftPointer];
                    leftPointer++;
                }
            }
    
            return minLength == Integer.MAX_VALUE ? 0 : minLength;
    
    
    }

    public static void main(String[] args) {
        
        int target = 15;
        int[] nums = {2,3,1,2,4,3};
        int[] nums2 = {5,1,3,5,10,7,4,9,2,8};
        int[] nums3 = {1,1,1,1,1,1,1,1};

        Solution s1 = new Solution();
        System.out.println(s1.minSubArrayLen(target, nums2));
        
    }
}

