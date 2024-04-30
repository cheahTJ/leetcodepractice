import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


class Solution {
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int counter = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(i1, i2);
            }
            
        });

        for (int i = 0; i < nums.length; i++) {
    
            if (nums[i] == val) {
                counter ++;
                pq.add(i);
            } else {
                if (!pq.isEmpty()) {
                    int temp = pq.poll();
                    nums[temp] = nums[i];
                    pq.add(i);
                }
            } 
        }
        return nums.length - counter;
    }



    // public static void main(String[] args) {
    //     Solution s1 = new Solution();
    //     int[] a = {3,2,2,3};
    //     System.out.println(s1.removeElement(a,3));
    //     for (int i : a) {
    //         System.out.println("A is: " + i);
    //     }
    // }

}