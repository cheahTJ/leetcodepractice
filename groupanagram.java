import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        List<List<String>> output = new LinkedList<>();

        for (String x : strs) {
            char[] temp = x.toCharArray();
            Arrays.sort(temp);
            String newString = new String(temp);

            if (hm.containsKey(newString)) {
                List<String> temporary = hm.get(newString);
                temporary.add(x);
            } else {
                List<String> t = new LinkedList<>();
                t.add(x);
                hm.put(newString, t);
            }
        }

        for (String x : hm.keySet()) {
            List<String> iterator = new LinkedList<>();
            for (int i = 0; i < hm.get(x).size(); i++) {
                iterator.add(hm.get(x).get(i));
            }
            output.add(iterator);
        }
        return output;
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        //String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs = {""};
        //String[] strs = {"a"};
        System.out.println(s1.groupAnagrams(strs));
        

    }
}