package Lab13_MyBST;

public class MyBST {

    BSTNode root;

    public int size() {
        return size(root);
    }
    private int size(BSTNode node) {
        if (node == null) return 0;
        return 1 + size(node.right) + size(node.left);
    }

    public void insert(Integer n) {
        if (root == null) {
            root = new BSTNode(n);
            return;
        }
        insert(n, root);
    }
    private void insert(Integer n, BSTNode node) {
        if (n < node.val) {
            if (node.left == null) {
                node.left = new BSTNode(n);
                return;
            }
            insert(n, node.left);
        } else {
            if (node.right == null) {
                node.right = new BSTNode(n);
                return;
            }
            insert(n, node.right);
        }
    }

    public Integer getMax() {
        if (root == null) return null;
        return getMax(root);
    }
    private Integer getMax(BSTNode node) {
        if (node.right == null) return node.val;
        return getMax(node.right);
    }

    public Integer getMin() {
        if (root == null) return null;
        return getMin(root);
    }
    private Integer getMin(BSTNode node) {
        if (node.left == null) return node.val;
        return getMin(node.left);
    }

    public void delete(Integer n) {
        root = delete(n, root);
    }
    private BSTNode delete(Integer n, BSTNode node) {
        if (node == null) return null;
        if (node.val.equals(n)) {
            if (node.right != null && node.left != null) {
                node.val = getSuccessor(node.right);
                return node;
            }
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            return null;
        }
        node.right = delete(n, node.right);
        node.left = delete(n, node.left);
        return node;
    }
    private Integer getSuccessor(BSTNode node) {
        if (node.left == null) {
            Integer min = node.val;
            delete(node.val, root);
            return min;
        }
        return getSuccessor(node.left);
    }

    public boolean contains(Integer n) {
        return contains(root, n);
    }
    private boolean contains(BSTNode node, Integer n) {
        if (node == null) return false;
        if (node.val.equals(n)) return true;
        return contains(node.left, n) || contains(node.right, n);
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }
    private void inOrder(BSTNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    public void print() {
        print(root, 1);
    }
    private void print(BSTNode node, int level) {
        if (node == null) return;
        print(node.right, level + 1);
        System.out.println(leftPadding(level) + node.val);
        print(node.left, level + 1);
    }
    private String leftPadding(int level) {
        char[] pad = new char[level * 4];
        for (int i = 0; i < level * 4; i++) {
            pad[i] = ' ';
        }
        return new String(pad);
    }

    private class BSTNode {
        Integer val;
        BSTNode left, right;

        public BSTNode(Integer val) {
            this.val = val;
            left = right = null;
        }

        @Override
        public String toString() {
            return "" + this.val;
        }
    }

}