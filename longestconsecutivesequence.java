import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        // Need to account for when the array is empty, the longest seq should be 0
        int longestSeq = 0;
        int temp = 0;
        HashSet<Integer> hs = new HashSet<>();
        

        for (int i = 0; i < nums.length; i ++) {
            hs.add(nums[i]);
        }

        for (int p = 0; p < nums.length; p++) {
            int currentHighest = 0;
            // Start of any sequnce
            if (!hs.contains(nums[p] - 1)) {
                temp = nums[p];
                while (hs.contains(temp)) {
                    currentHighest ++;
                    temp++;
                }
                longestSeq = Math.max(longestSeq, currentHighest);
            }   
        }

        return longestSeq;
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] a = {0,3,7,2,5,8,4,6,0,1}; 
        System.out.println( s1.longestConsecutive(a));
    }
}