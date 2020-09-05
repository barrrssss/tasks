public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){};

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    TreeNode(int val){
        this.val = val;
    }


}

class TreeDepthFinder{
    public static MaxDepthCounter maxDepth = new MaxDepthCounter();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(new TreeNode(new TreeNode(),
                                                        new TreeNode( new TreeNode(),
                                                                        null)),
                                        new TreeNode());
        int result = maxTreeDepth(treeNode);
        System.out.println(result);
    }

    public static int maxTreeDepth(TreeNode root){
        exploreNode(root, 0);

        return maxDepth.getValue();
    }

    private static void exploreNode(TreeNode root, int currentDepth){
        currentDepth++;
        maxDepth.tryToSet(currentDepth);

        if (root.left != null){
            exploreNode(root.left, currentDepth);
        }

        if (root.right != null){
            exploreNode(root.right, currentDepth);
        }

    }

    static class MaxDepthCounter {
        private int value;

        public void tryToSet(int value){
            if (value > this.value){
                this.value = value;
            }
        }

        public int getValue() {
            return value;
        }
    }
}