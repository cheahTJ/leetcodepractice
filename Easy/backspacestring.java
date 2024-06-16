import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class Solution {

    // This runtime is O(N) but space is O(N) also VS the optimised version below
    // public boolean backspaceCompare(String s, String t) {
    //     char[] arrS = s.toCharArray();
    //     char[] arrT = t.toCharArray();
    //     LinkedList<Character> llS = new LinkedList<>();
    //     LinkedList<Character> llT = new LinkedList<>();

    //     for (int i = 0; i < arrS.length; i++){
    //         if (arrS[i] != '#') {
    //             llS.add(arrS[i]);
    //         } else {
    //             if (!llS.isEmpty()) {
    //                 llS.removeLast();
    //             }
    //         }
    //     }

    //     for (int i = 0; i < arrT.length; i++){
    //         if (arrT[i] != '#') {
    //             llT.add(arrT[i]);
    //         } else {
    //             if (!llT.isEmpty()) {
    //                 llT.removeLast();
    //             }
    //         }
    //     }

    //     if (llS.size() != llT.size()) {return false;}
    //     Iterator<Character> iterator1 = llS.iterator();
    //     Iterator<Character> iterator2 = llT.iterator();

    //     while (iterator1.hasNext() && iterator2.hasNext()) {
    //         if (!iterator1.next().equals(iterator2.next())) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }
    
    // Optimised solution using 2 pointers - O(N) time, O(1) space
    public boolean backspaceCompare(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        int pointerS = arrS.length - 1;
        int pointerT = arrT.length - 1;
        // this is so that both arrays need to be processed
        while((pointerS >= 0) || (pointerT >= 0)) {
            int counterS = 0;
            int counterT = 0;
    
            while(pointerS >= 0 && (arrS[pointerS] == '#' || counterS > 0)) {
                if (arrS[pointerS] == '#') {
                    counterS++;
                } else {
                    counterS--;
                }
                pointerS--;
            }
            

            while (pointerT >= 0 && (arrT[pointerT] == '#' || counterT > 0)) {
                if (arrT[pointerT] == '#') {
                    counterT++;
                } else {
                    counterT--;
                }
                pointerT--;
            }

            if ((pointerS >= 0) != (pointerT >= 0)) {
                return false;
            }
            
            if (pointerT >= 0 && pointerS >= 0 && arrS[pointerS] != arrT[pointerT]) {
                return false;
            }
            
            pointerS--;
            pointerT--;

        }

        return true;
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.backspaceCompare("ab#c", "ad#c"));
        
    }
}