import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        if (arr.length == 0) {
            return true;
        }
        
        for (char x : arr) {
            if (st.isEmpty()) {
                st.add(x);
            } else {
                char temp = st.pop();
                if (temp == '(') {
                    if (x != ')') {
                        st.add(temp);
                        st.add(x);
                    } 
                } else if (temp == '{') {
                    if (x != '}') {
                        st.add(temp);
                        st.add(x);
                    } 
                } else if (temp == '[') {
                    if (x != ']') {
                        st.add(temp);
                        st.add(x);
                    } 
                } else {
                    st.add(temp);
                    st.add(x);
                }
            }
        }

        if (!st.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}