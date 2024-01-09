import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length,new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(i2, i1);
            }
        });

        int output = 0;
        ArrayList<Integer> AL = new ArrayList<>();

        for (int i : nums) {
            pq.add(i);
        }

        while (k != 0) {    
            output = pq.poll();
            AL.add(output);
            k--;
        }

        for (int i : AL) {
            pq.add(i);
        }

        return output;
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(s1.findKthLargest(nums, 4));
    }
}