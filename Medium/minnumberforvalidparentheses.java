import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
    char first;
    int position;
    public Pair (char first, int position) {
        this.first = first;
        this.position = position;
    }
}

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Pair> stck = new Stack<>();
        List<Character> charList = new ArrayList<>();
         for (char c : s.toCharArray()) {
            charList.add(c);
        }

        if (charList.size() == 0) {
            return s;
        }

        for (int i = 0; i < charList.size(); i ++) {
            char elem = charList.get(i);
            if (elem == '(') {
                stck.add(new Pair(elem, i));
            } else if (elem == ')') {
                if (!stck.isEmpty()) {
                    Pair temp = stck.pop();
                    if (temp.first != '(') {
                        stck.add(temp);
                        stck.add(new Pair(elem, i));
                    }
                } else {
                    stck.add(new Pair(elem, i));
                }
            }
        }

        while(!stck.isEmpty()) {
            Pair p = stck.pop();
            charList.remove(p.position);
        }

        return charListToString(charList);


    }

    public static String charListToString(List<Character> charList) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : charList) {
            sb.append(ch);
        }
        return sb.toString();
    }
}