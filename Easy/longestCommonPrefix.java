class Solution {
    public String longestCommonPrefix(String[] strs) {
        String oldPrefix = "";
        String newPrefix = "";
        if (strs.length == 0) {
            System.out.println(oldPrefix);
            return oldPrefix; 
        }
        
        if (strs.length == 1) {
            oldPrefix = strs[0];
            System.out.println(oldPrefix);
            return oldPrefix; 
        }
        
        // Usign the first comparison between the first and second word and use that to propogate down to çheck for the lognest prefix
        
        return oldPrefix;
    }

}

class longestCommonPrefix {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        String[] input = {"flower","flow","flight"};        ;
        s1.longestCommonPrefix(input);

    }
}