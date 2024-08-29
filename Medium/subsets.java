class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> al = new ArrayList<>();
        al.add(new ArrayList<>()); 

        for (int i = 0; i < nums.length; i++) {
            int currentSize = al.size();  
            
            for (int j = 0; j < currentSize; j++) {
                List<Integer> newSubset = new ArrayList<>(al.get(j));  
                newSubset.add(nums[i]);  
                al.add(newSubset);  
            }
        }

        return al;
    }
}
