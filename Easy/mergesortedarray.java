class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int end = m + n - 1;

        while (pointer1 >= 0 && pointer2 >= 0) {
            if (nums2[pointer2] >= nums1[pointer1]) {
                nums1[end] = nums2[pointer2];
                end --;
                pointer2--;
            } else {
                nums1[end] = nums1[pointer1];
                end --;
                pointer1--;
            }
        } 

        // if all the elements in the m size of num1 have been exhausted, need to fill with remaining elements from num2
        while (pointer2 >= 0) {
            nums1[end] = nums2[pointer2];
            end--;
            pointer2--;
        }
    }


    // public static void main(String[] args) {
    //     Solution s1 = new Solution();
    //     int[] a = {1,2,3,0,0,0};
    //     int[] b = {2,5,6};
    //     s1.merge(a, 3, b, 3);        
    //     for (int i : a) {
    //         System.out.println(i);
    //     }
    // }

}





