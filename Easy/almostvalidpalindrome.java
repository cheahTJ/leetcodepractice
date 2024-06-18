import java.util.ArrayList;

class Solution {
    public boolean validPalindrome(String s) {
        String processedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] arr = processedString.toCharArray();
        boolean furtherProcess = false;
        int left = 0;
        int right = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                furtherProcess = true;
                left = i;
                right = arr.length - i - 1;
                break;
            }
        }
        
        if (furtherProcess) {
            String newString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            ArrayList<Character> arr1 = stringToArrayList(newString, left);
            ArrayList<Character> arr2 = stringToArrayList(newString, right);
            int count1 = 0;
            int count2 = 0;
            for (int t = left; t < arr1.size(); t++) {
                if (arr1.get(t) != arr1.get(arr1.size() - t - 1)) {
                    count1++;
                }
                if (arr2.get(t) != arr2.get(arr1.size() - t - 1)) {
                    count2++;
                }
                if (count1 > 0 && count2 > 0) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    public static ArrayList<Character> stringToArrayList(String str, int position) {
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (i != position) {
                charList.add(str.charAt(i));
            }
        }
        return charList;
    }
}


// This is for regular palindrome question
// class Solution {
//     public boolean isPalindrome(String s) {
//         String processedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
//         char[] arr = processedString.toCharArray();
//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i] != arr[arr.length - i - 1]) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }