import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class AVLTree<K, V> implements IAVLTree<K, V> {
    public class Node {
        private K key;
        private ArrayList<V> valuesList;
        private Node left, right;
        private int height;

        public Node(K key, ArrayList<V> valuesList) {
            this.key = key;
            this.valuesList = valuesList;
            this.height = 0;
        }

        public Node(V value) {
        }

        public void addToNode(V value) {
            valuesList.add(value);
        }

        public K getKey() {
            return key;
        }

        public ArrayList<V> getValues() {
            return valuesList;
        }

        public Node getChildNodeFromSide(String side) {
            switch (side) {
                default:
                    return null;
                case "left":
                    return left;
                case "right":
                    return right;
            }
        }
    }

    private Node rootNode;
    private Comparator<K> comparator;

    //Unused
    public AVLTree() {
    }

    public AVLTree(Comparator<K> comparator) {
        this.comparator = comparator;
        this.rootNode = null;
    }

    @Override
    public V add(K key, V value) {
        Node n = rootNode = add(key, value, rootNode);

        if (n != null) {
            return value;
        } else {
            return null;
        }
    }

    private Node add(K key, V value, Node node) {
        ArrayList<V> values = new ArrayList<V>();
        values.add(value);

        if (node == null) {
            node = new Node(key, values);
        } else if (comparator.compare(key, node.key) < 0) {
            node.left = add(key, value, node.left);

            if (height(node.left) - height(node.right) == 2) {
                if (comparator.compare(key, node.left.key) < 0)
                    node = rotateWithLeftChild(node);
                else
                    node = doubleRotateWithLeft(node);
            }

        } else if (comparator.compare(key, node.key) > 0) {
            node.right = add(key, value, node.right);

            if (height(node.right) - height(node.left) == 2) {
                if (comparator.compare(key, node.right.key) > 0)
                    node = rotateWithRightChild(node);
                else
                    node = doubleRotateWithRight(node);
            }
        } else node.getValues().add(value);

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    @Override
    public Iterator<V> find(K key) {
        Node n = search(key, rootNode);
        if (n != null) {
            ArrayList<V> values = n.getValues();
            return values.iterator();
        } else {
            return new ArrayList<V>().iterator();
        }
    }

    private Node search(K key, Node node) {
        if (node == null) return null;
        else if (comparator.compare(key, node.getKey()) < 0)
            return search(key, node.left);
        else if (comparator.compare(key, node.getKey()) > 0)
            return search(key, node.right);
        else return node;
    }

    @Override
    public V remove(K key, V value) throws Exception {
        rootNode = remove(key, value, rootNode);
        return value;
    }

    private Node remove(K key, V value, Node node) {
        //If node with key contains one or less values, remove the whole key
        //Else remove value from node with key
        if (node == null) return null;
        else if (comparator.compare(key, node.key) < 0) {
            node.left = remove(key, value, node.left);

            if (height(node.left) - height(node.right) == 2) {
                if (comparator.compare(key, node.left.key) < 0)
                    node = rotateWithLeftChild(node);
                else
                    node = doubleRotateWithLeft(node);
            }
        } else if (comparator.compare(key, node.key) > 0) {
            node.right = remove(key, value, node.right);

            if (height(node.right) - height(node.left) == 2) {
                if (comparator.compare(key, node.right.key) < 0)
                    node = rotateWithRightChild(node);
                else
                    node = doubleRotateWithRight(node);
            }
        } else {
            if (node.valuesList.size() > 1) {
                node.valuesList.remove(value);
                return node;
            } else {
                if (node.left == null && node.right == null)
                    return null;
                if (node.left == null) return balance(node.right);
                if (node.right == null) return balance(node.left);

                Node smallestNode = smallestNode(node.right);
                node = smallestNode;
                node.right = remove(key, value, node.right);
                return balance(node);
            }
        }

        return balance(node);
    }

    @Override
    public Iterator<V> removeAll(K key) {
        Node n = search(key, rootNode);
        return n.valuesList.iterator();
    }

    @Override
    public Iterator<V> listAll() {
        ArrayList<V> entries = new ArrayList<V>();
        listAll(rootNode, entries);
        return entries.iterator();
    }

    private void listAll(Node n, ArrayList<V> entries) {
        if (n != null) {
            listAll(n.left, entries);
            entries.addAll(n.valuesList);
            listAll(n.right, entries);
        }
    }

    @Override
    public int height() {
        return height(rootNode);
    }

    //Custom Methods
    public boolean isEmpty() {
        return rootNode == null;
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public int getTreeHeight() {
        return height(rootNode);
    }

    public int countNodes() {
        return countNodes(rootNode);
    }

    private int countNodes(Node n) {
        if (n == null) return 0;
        else {
            return 1 + countNodes(n.left) + countNodes(n.right);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(rootNode);
    }

    private void inOrderTraversal(Node n) {
        if (n != null) {
            inOrderTraversal(n.left);
            System.out.println(n.getKey());
            inOrderTraversal(n.right);
        }
    }

    private Node rotateWithLeftChild(Node node2) {
        Node node1 = node2.left;
        node2.left = node1.right;
        node1.right = node2;

        node2.height = Math.max(height(node2.left), height(node2.right)) + 1;
        node1.height = Math.max(height(node1.left), node2.height) + 1;

        return node1;
    }

    private Node rotateWithRightChild(Node node1) {
        Node node2 = node1.right;
        node1.right = node2.left;
        node2.left = node1;

        node1.height = Math.max(height(node1.left), height(node1.right)) + 1;
        node2.height = Math.max(height(node2.left), node1.height) + 1;

        return node2;
    }

    private Node doubleRotateWithLeft(Node node) {
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }

    private Node doubleRotateWithRight(Node node) {
        node.right = rotateWithLeftChild(node.right);
        return rotateWithRightChild(node);
    }

    private Node balance(Node node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private Node smallestNode(Node node) {
        if (node.left == null) return node;
        else return smallestNode(node.left);
    }
}