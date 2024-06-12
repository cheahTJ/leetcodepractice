class Solution {

    // This is brute force method but this will TLE
    // public int maxArea(int[] height) {
    //     int maxArea = 0;
    //     for (int i = 0; i < height.length; i++) {
    //         for (int p = i + 1; p < height.length; p++) {
    //             int currArea = Math.min(height[i], height[p]) * (p - i);
    //             if ((currArea) > maxArea) {
    //                 maxArea = currArea;
    //             }
    //         }
    //     }

    //     return maxArea;
    // }

    // Optimised solution with double pointer
    public int maxArea(int[] height) {
        int maxArea = 0;
        int p1 = 0;
        int p2 = height.length - 1;
        while (p1 < p2) {
            int h = Math.min(height[p1], height[p2]);
            int w = p2 - p1;
            int area = h * w;
            maxArea = Math.max(maxArea, area);
            if (height[p1] < height[p2]) {
                p1++;
            } else {
                p2--;
            }
        }

        return maxArea;
    }
    
    
    
}