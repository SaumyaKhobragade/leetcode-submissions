import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class DeepestLevelLCA {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static ArrayList<TreeNode> findLowestLevel(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<TreeNode> arr = new ArrayList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            arr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                arr.add(curr);

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return arr;
    }

    public static TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null || root == n1 || root == n2) {
            return root;
        }

        TreeNode leftLCA = findLCA(root.left, n1, n2);
        TreeNode rightLCA = findLCA(root.right, n1, n2);

        if (rightLCA == null) {
            return leftLCA;
        }

        if (leftLCA == null) {
            return rightLCA;
        }

        return root;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ArrayList<TreeNode> list = findLowestLevel(root);
        return findLCA(root, list.get(0), list.get(list.size() - 1));
    }
}