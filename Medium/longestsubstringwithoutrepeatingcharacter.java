import java.util.HashMap;

class Solution {
    // Brute force method
    // public int lengthOfLongestSubstring(String s) {
    //     char[] arrS = s.toCharArray();
    //     int maxCount = 0;
    //     ArrayList<Character> al = new ArrayList<>();

    //     for (int i = 0; i < arrS.length; i++) {
    //         int currCount = 0;
    //         al.add(arrS[i]);
    //         currCount++;
    //         for (int t = i + 1; t < arrS.length; t++) {
    //             if (!al.contains(arrS[t])) {
    //                 al.add(arrS[t]);
    //                 currCount++;
    //             } else {
    //                 break;
    //             }
    //         }
    //         maxCount = Math.max(maxCount, currCount);
            
            
    //         al.clear();
    //     }

    //     return maxCount;
    // }

    public int lengthOfLongestSubstring(String s) {
        char[] arrS = s.toCharArray();
        int maxCount = 0;
        HashMap<Character, Boolean> hm = new HashMap<>();

        if (arrS.length > 1) {
            int leftPointer = 0;
            int rightPointer = 0;

            while (leftPointer < arrS.length && rightPointer < arrS.length) {
                if (!hm.containsKey(arrS[rightPointer])) {
                    hm.put(arrS[rightPointer], true);
                    rightPointer++;
                    // This is okay because the above already increment the count of rightPointer
                    maxCount = Math.max(maxCount, (rightPointer - leftPointer));
                } else {
                    // This is so that it will remove until the point when the element that 
                    //is causing the duplicate will be removed while the rightpointer will be stationery while this is happening
                    hm.remove(arrS[leftPointer]);
                    leftPointer++;
                }
            }

            return maxCount;
        } else {
            return arrS.length;
        }

    }
}