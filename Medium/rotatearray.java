
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public void rotate(int[] nums, int k) {
        // Mapping from digit to its new position, assuming that there will be duplicated digit
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (!hm.containsKey(nums[i])) {
                List<Integer> temp = new LinkedList<>();
                int newNum = i + k;

                // Need to account for the part where the new position of the digit needs to be within the length boundary of the array
                if ((newNum) > (nums.length - 1)) {
                    while (newNum > (nums.length - 1)) {
                        newNum = newNum - nums.length;
                    }
                }
                temp.add(newNum); 
                hm.put(nums[i], temp);
            } else {
                List<Integer> temporary = hm.get(nums[i]);
                int newNumber = i + k;
                 if ((newNumber) > (nums.length - 1)) {
                    while (newNumber > (nums.length - 1)) {
                        newNumber = newNumber - nums.length;
                    }
                }
                
                temporary.add(newNumber);
                hm.put(nums[i],temporary);
            }
        }

        for (int i : hm.keySet()) {
            for (int p = 0; p < hm.get(i).size(); p++) {
                nums[hm.get(i).get(p)] = i;
            }
        }
    }
    

    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] nums = {1,2};
        s1.rotate(nums,3);
        for (int i : nums) {
            System.out.println("i: " + i );
        }
    }
}