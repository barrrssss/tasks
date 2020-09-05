public class AdvancedTreeNodeTask {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public int operationCount;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public boolean isSymmetric(TreeNode root){
            return isSymmetricInternal(root, root);
        }

        private boolean isSymmetricInternal (TreeNode tn1, TreeNode tn2){
            operationCount++;

            if (tn1 == null  && tn2 == null){
                return true;
            }

            if (tn1 == null  || tn2 == null){
                return false;
            }

            return (tn1.val == tn2.val)
                    && isSymmetricInternal(tn1.left, tn2.right)
                    && isSymmetricInternal(tn1.right, tn2.left);
        }

        public static void main(String[] args) {
            TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4),
                                                                        new TreeNode(3)),
                                                    new TreeNode(2, new TreeNode(3),
                                                                        new TreeNode(4)));
            System.out.println(treeNode.isSymmetric(treeNode));
            System.out.println(treeNode.operationCount);
        }
    }
}
