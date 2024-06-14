class Solution {
    public int trap(int[] height) {
    // One pointer brute force solution
    //      int maxLeft = height[0];
    //      int maxRight = 0;
    //      int totalWater = 0;
 
    //      for (int i : height) {
    //          if (i > maxRight) {
    //              maxRight = i;
    //          }
    //      }
 
    //      for (int i = 0; i < height.length; i++) {
    //          System.out.println("Total water is: " + totalWater);
    //          if (height[i] == maxRight) {
    //              // Find new maxRight but have to reset first
    //              maxRight = 0;
    //              for (int j = i + 1; j < height.length; j ++) {
    //                  if (height[j] > maxRight) {
    //                      maxRight = height[j];
    //                  }
    //              }
    //              int curr = Math.min(maxRight, maxLeft) - height[i];
    //              if (curr > 0) {
    //                  totalWater += curr;
    //              }
    //              if(height[i] > maxLeft) {
    //                  maxLeft = height[i];
    //              }
                 
    //          } else {
    //              int currWater = Math.min(maxRight, maxLeft) - height[i];
    //              if (currWater > 0) {
    //                  totalWater += currWater;
    //              }
 
    //              if(height[i] > maxLeft) {
    //                  maxLeft = height[i];
    //              }
    //          }
    //      }
    //      return totalWater;
    //  }

        // Optimised solution with 2 pointers
        int leftP = 0;
        int rightP = height.length - 1;
        int leftWater = 0;
        int rightWater = 0;
        int totalWater = 0;

        while (rightP > leftP) {
            if (height[leftP] < height[rightP]) {
                if (height[leftP] < leftWater) {
                    totalWater += (leftWater - height[leftP]);
                } else {
                    leftWater = height[leftP];
                }
                leftP++;
            } else {
                if (height[rightP] < rightWater) {
                    totalWater += (rightWater - height[rightP]);
                } else {
                    rightWater = height[rightP];
                }
                rightP--;
            }
        }
        return totalWater;
    }
        
    

 }