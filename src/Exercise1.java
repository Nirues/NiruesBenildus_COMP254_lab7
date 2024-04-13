import java.util.Stack;

public class Exercise1 {

    public static <E> boolean treeSearch(Node<E> root, E target) {
        if (root == null) {
            return false;
        }

        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node<E> current = stack.pop();
            if (current.data.equals(target)) {
                return true;
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return false;
    }

    static class Node<E> {
        E data;
        Node<E> left, right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(2);
        root.left = new Node<>(4);
        root.right = new Node<>(6);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(10);


        System.out.println(treeSearch(root, 8));
        System.out.println(treeSearch(root, 12));
    }
}

