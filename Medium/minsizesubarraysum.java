import java.util.ArrayList;


// This set of solution will find the LAST subarray that hits the target and NOT the smallest subarray

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        ArrayList<Integer> subarray = new ArrayList<>();
        int currSum = 0;
        int pointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currSum + nums[i] < target) {
                currSum += nums[i];
                subarray.add(nums[i]);
            } else {
                currSum += nums[i];
                subarray.add(nums[i]);

                while (currSum - subarray.get(pointer) >= target) {
                    currSum -= subarray.get(pointer);
                    subarray.remove(pointer);
                }
                
                System.out.println("Curr sum is currently: " + currSum);
                System.out.println("Pointer is currently: " + pointer);

                
                for (int t : subarray) {
                    System.out.println("Content is: "  + t);
                }

                System.out.println("------------------------");
                pointer = 0;
            }
        }

        if (subarray.size() != 0 && currSum >= target) {
            return subarray.size();        
        } else {
            return 0;
        }
    
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

