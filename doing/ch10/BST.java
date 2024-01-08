package ch10;

public class BST<T extends Comparable<T>> {

    private Node<T> root;
    public BST(T value) {
        this.root = new Node<T>(value, null, null);
    }

    public BST() {

    }

    public BST(Node<T> node) {
        this.root = node;
    }

    private static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(T value) {
            this.value = value;
        }

        public Node<T> find(T key) {
            if (key == null) {
                return null;
            }
            int compared = key.compareTo(this.value);
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

        public static <T extends Comparable<T>> boolean check(Node<T> node) {
            if (node == null) {
                return true;
            }
            boolean validate = true;
            if (node.left != null ) {
                if (node.left.value.compareTo(node.value) > 0) {
                    return false;
                } else {
                    validate = check(node.left);
                }
            }

            if (node.right != null) {
                if (node.right.value.compareTo(node.value) < 0) {
                    return false;
                } else {
                    validate = validate && check(node.right);
                }
            }
            return validate;
        }

        public static <T extends Comparable<T>> Node<T> leftMost(Node<T> node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        public static <T extends Comparable<T>> Node<T> rightMost(Node<T> node) {
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }
        public static <T extends Comparable<T>> Node<T> delete(Node<T> parent, Node<T> node, T key) {
            if (node == null) {
                return null;
            }
            int compared = key.compareTo(node.value);
            if (compared == 0) {
                if (node.left == null && node.right == null) {
                    if (parent != null) {
                        if (parent.left == node) {
                            parent.left = null;
                        } else {
                            assert parent.right == node;
                            parent.right = null;
                        }
                    }
                    return null;
                } else if (node.right == null) { // node.left != null
                    if (parent != null) {
                        if (parent.left == node) {
                            parent.left = node.left;
                        } else {
                            parent.right = node.left;
                        }
                    }
                    return node.left;
                } else if (node.left == null) { // node.right != null
                    if (parent != null) {
                        if (parent.left == node) {
                            parent.left = node.right;
                        } else {
                            parent.right = node.right;
                        }
                    }
                    return node.right;
                } else {
                    // node.left != null && node.right != null
                    Node<T> most = Node.leftMost(node.right);
                    if (most == node.right) {
                        if (parent != null) {
                            if (parent.left == node) {
                                parent.left = most;
                            } else {
                                parent.right = most;
                            }
                        }
                        most.left = node.left;
                        most.right = null;
                    } else {
                        Node<T> withoutMost = delete(node, node.right, most.value);
                        if (parent != null) {
                            if (parent.left == node) {
                                parent.left = most;
                            } else {
                                parent.right = most;
                            }
                        }
                        most.right = withoutMost;
                        most.left = node.left;
                    }

                    return most;
                }

            } else if (compared < 0) {
                node.left = delete(node, node.left, key);
                return node;
            } else {
                node.right = delete(node, node.right, key);
                return node;
            }
        }

        public static <T extends Comparable<T>> Node<T> insert(Node<T> node, T key) {
            if (node == null) { // base condition
                return new Node<>(key);
            }
            int compared = key.compareTo(node.value);
            if (compared == 0) {
                return node;
            } else if (compared < 0) {
                node.left = insert(node.left, key);
                return node;
            } else {
                node.right= insert(node.right, key);
                return node;
            }
        }

        public static <T extends Comparable<T>> Node<T> find(Node<T> node, T key) {
            if (node == null) {
                return null;
            }
            int compared = key.compareTo(node.value);
            if (compared == 0) {
                return node;
            } else if (compared < 0) {
                return find(node.left, key);
            } else {
                return find(node.right, key);
            }
        }

    }

    public BST<T> delete(T value) {
        this.root = Node.delete(null, this.root, value);
        return this;
    }
    public boolean isValidate() {
        return Node.check(this.root);
    }

    public BST<T> find(T value) {
        Node<T> node = Node.find(this.root, value);
        if (node != null) {
            return new BST<>(node);
        }
        return null;
    }

    public BST<T> insert(T value) {
        this.root = Node.insert(this.root, value);
        return this;
    }

    public static void main(String[] args) {
        Node<String> alf = new Node<>("alf");
        Node<String> cat = new Node<>("cat");
        Node<String> bag = new Node<>("bag", alf, cat);


        Node<String> elf = new Node<>("elf");
        Node<String> glut = new Node<>("glut");
        Node<String> flat = new Node<>("flat", elf, glut);

        Node<String> dog = new Node<>("dog", bag, flat);

        BST<String> bst = new BST<>(dog);
        BST<String> g = bst.find("glut");
        System.out.println(g == null ? "null" : g.root.value);
        BST<String> XYZ = bst.insert("xyz");
        BST<String> xyz = bst.find("xyz");
        System.out.println(xyz == null ? "null" : xyz.root.value);
    }
}