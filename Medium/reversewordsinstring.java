
public String reverseWords(String s) {
    s = s.trim();
    int n = s.length();

    int right = n - 1, left;
    StringBuilder result = new StringBuilder();
    while (right >= 0) {
        while (right >= 0 && s.charAt(right) == ' ') {
            right --;
        }

        left = right;
        while (left >= 0 && s.charAt(left) != ' ') {
            left --;
        }

        result.append(s.substring(left + 1, right + 1)).append(" ");
        right = left;
        
    }

    return result.toString().trim();
}
