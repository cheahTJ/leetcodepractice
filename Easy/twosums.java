import java.util.ArrayList;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            for (int t = i + 1; t < nums.length; t++) {
                if (nums[t] == result) {
                    al.add(i);
                    al.add(t);
                    break;
                }
            }
        }
        int[] resultArray = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            resultArray[i] = al.get(i);
        }

        return resultArray;
    }
}