import java.util.HashMap;
import java.util.Stack;



class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> s = new Stack<>();
        HashMap<TreeNode, Integer> hm = new HashMap<>();

        if (root == null) {
            return false;
        }

        s.push(root);
        hm.put(root, root.val);

        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            int curr = hm.get(temp);
            if (temp.right == null && temp.left == null) {
                if (curr == targetSum) {
                    return true;
                }
            }

            if (temp.right != null) {
                s.push(temp.right);
                hm.put(temp.right, curr + temp.right.val);
            }

            if (temp.left != null) {
                s.push(temp.left);
                hm.put(temp.left, curr + temp.left.val);
            }
        }

        return false;
    }
}