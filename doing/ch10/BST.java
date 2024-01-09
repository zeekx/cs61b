package ch10;

public class BST<T extends Comparable<T>, V> {

    private Node<T, V> root;
    public BST(T key, V value) {
        this.root = new Node<T, V>(key, null, null, value);
    }

    public BST() {

    }

    public BST(Node<T, V> node) {
        this.root = node;
    }

    private static class Node<T extends Comparable<T>, V> {
        private T key;
        private V value;
        private Node<T, V> left;
        private Node<T, V> right;

        public Node(T key, Node<T, V> left, Node<T, V> right, V value) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Node(T key, V value) {
            this.key = key;
            this.value = value;
        }



        public Node<T, V> find(T key) {
            if (key == null) {
                return null;
            }
            int compared = key.compareTo(this.key);
            if (compared == 0) {
                return this;
            } else if (this.left != null && compared < 0) {
                return this.left.find(key);
            } else if (this.right != null) {
                return this.right.find(key);
            } else {
                return null;
            }
        }

        public static <T extends Comparable<T>, V> boolean check(Node<T, V> node) {
            if (node == null) {
                return true;
            }
            boolean validate = true;
            if (node.left != null ) {
                if (node.left.key.compareTo(node.key) > 0) {
                    return false;
                } else {
                    validate = check(node.left);
                }
            }

            if (node.right != null) {
                if (node.right.key.compareTo(node.key) < 0) {
                    return false;
                } else {
                    validate = validate && check(node.right);
                }
            }
            return validate;
        }

        public static <T extends Comparable<T>, V> Node<T, V> leftMost(Node<T, V> node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        public static <T extends Comparable<T>, V> Node<T, V> rightMost(Node<T, V> node) {
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }

        private static <T extends Comparable<T>, V> void deleteFromParent(Node<T, V> parent, Node<T, V> node, Node<T, V> newChild) {
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = newChild;
                } else {
                    parent.right = newChild;
                }
            }
        }
        public static <T extends Comparable<T>, V> Node<T, V> delete(Node<T, V> parent, Node<T, V> node, T key) {
            if (node == null) {
                return null;
            }
            int compared = key.compareTo(node.key);
            if (compared < 0) {
                node.left = delete(node, node.left, key);
                return node;
            } else if (compared > 0) {
                node.right = delete(node, node.right, key);
                return node;
            } else {
                if (node.left == null && node.right == null) {
                    deleteFromParent(parent, node, null);
                    return null;
                } else if (node.right == null) { // node.left != null
                    deleteFromParent(parent, node, node.left);
                    return node.left;
                } else if (node.left == null) { // node.right != null
                    deleteFromParent(parent, node, node.right);
                    return node.right;
                } else {
                    // node.left != null && node.right != null
                    Node<T, V> most = Node.leftMost(node.right);
                    Node<T, V> withoutMost = delete(node, node.right, most.key);
                    deleteFromParent(parent, node, most);
                    most.right = withoutMost;
                    most.left = node.left;

                    return most;
                }

            }
        }

        public static <T extends Comparable<T>, V> Node<T, V> insert(Node<T, V> node, T key, V value) {
            if (node == null) { // base condition
                return new Node<>(key, value);
            }
            int compared = key.compareTo(node.key);
            if (compared < 0) {
                node.left = insert(node.left, key, value);
            } else if (compared > 0) {
                node.right = insert(node.right, key, value);
            }
            return node;
        }

        public static <T extends Comparable<T>, V> Node<T, V> find(Node<T, V> node, T key) {
            if (node == null) {
                return null;
            }
            int compared = key.compareTo(node.key);
            if (compared < 0) {
                return find(node.left, key);
            } else if (compared > 0) {
                return find(node.right, key);
            } else {
                return node;
            }
        }

    }

    public BST<T, V> delete(T value) {
        this.root = Node.delete(null, root, value);
        return this;
    }
    public boolean isValidate() {
        return Node.check(this.root);
    }

    public BST<T, V> find(T key) {
        Node<T, V> node = Node.find(this.root, key);
        if (node != null) {
            return new BST<>(node);
        }
        return null;
    }

    public BST<T, V> insert(T key, V value) {
        this.root = Node.insert(this.root, key, value);
        return this;
    }

    public static void main(String[] args) {
        Node<String, String> alf = new Node<>("alf", "alf");
        Node<String, String> cat = new Node<>("cat", "cat");
        Node<String, String> bag = new Node<>("bag", alf, cat, "bag");


        Node<String, String> elf = new Node<>("elf", "elf");
        Node<String, String> glut = new Node<>("glut", "glut");
        Node<String, String> flat = new Node<>("flat", elf, glut, "flat");

        Node<String, String> dog = new Node<>("dog", bag, flat, "dog");

        BST<String, String> bst = new BST<>(dog);
        BST<String, String> g = bst.find("glut");
        System.out.println(g == null ? "null" : g.root.key);
        BST<String, String> XYZ = bst.insert("xyz", "xyz");
        BST<String, String> xyz = bst.find("xyz");
        System.out.println(xyz == null ? "null" : xyz.root.key);
    }
}