import java.util.Iterator;
import java.util.LinkedList;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        LinkedList<Character> llS = new LinkedList<>();
        LinkedList<Character> llT = new LinkedList<>();

        for (int i = 0; i < arrS.length; i++){
            if (arrS[i] != '#') {
                llS.add(arrS[i]);
            } else {
                if (!llS.isEmpty()) {
                    llS.removeLast();
                }
            }
        }

        for (int i = 0; i < arrT.length; i++){
            if (arrT[i] != '#') {
                llT.add(arrT[i]);
            } else {
                if (!llT.isEmpty()) {
                    llT.removeLast();
                }
            }
        }

        if (llS.size() != llT.size()) {return false;}
        Iterator<Character> iterator1 = llS.iterator();
        Iterator<Character> iterator2 = llT.iterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            if (!iterator1.next().equals(iterator2.next())) {
                return false;
            }
        }

        return true;
    }

    

    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.backspaceCompare("ab#c", "ad#c"));
        
    }
}