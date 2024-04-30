import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int removeDuplicates(int[] nums) {
    
        int duplicatecounter = 0;
        // Intiialise to the first element of the array first
        int prevElement = nums[0];
        int counter = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(i1, i2);
            }
            
        });

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == prevElement) {
                duplicatecounter++;
                if (duplicatecounter > 2) {
                    pq.add(i);
                } else {
                    if (!pq.isEmpty()) {
                        int t = pq.poll();
                        nums[t] = nums[i];
                        pq.add(i);
                    }
                    counter++;
                }

            
            } else {
                duplicatecounter = 0;
                duplicatecounter++;
                if (!pq.isEmpty()) {
                    int temp = pq.poll();
                    pq.add(i);
                    prevElement = nums[i];
                    nums[temp] = nums[i];
                    counter++;
                } else {
                    prevElement = nums[i];
                    counter++;
                }
            }
        }

        return counter;
    }

    // public static void main(String[] args) {
    //     Solution s1 = new Solution();
    //     int[] a = {0,0,1,1,1,1,2,3,3};
    //     System.out.println(s1.removeDuplicates(a));
    //     for (int i : a) {
    //         System.out.println("My content is: " + i);
    //     }

    // }
}