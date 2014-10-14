import java.io.*;
import java.util.Comparator;

public class Problem1521 {

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        OrderStatisticTree<Integer> tree = new OrderStatisticTree<Integer>();
        for (int i = 1; i <= n; i++) {
            tree.add(i);
        }
        int i = k - 1;
        while (n > 0) {
            Integer key = tree.select(i);
            n--;
            out.print(key);
            if (n == 0) {
                out.println();
            } else {
                out.print(' ');
                i = (i + k - 1) % n;
            }
            tree.remove(key);
        }
        out.flush();
    }


    static class OrderStatisticTree<E> {

        private static final Comparator DEFAULT_COMPARATOR = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) o1).compareTo(o2);
            }
        };

        final Comparator<E> comparator;
        final Node NIL = createNil();
        Node<E> root = NIL;

        public OrderStatisticTree() {
            this.comparator = DEFAULT_COMPARATOR;
        }

        public OrderStatisticTree(Comparator<E> comparator) {
            this.comparator = comparator;
        }

        private Node createNil() {
            Node node = new Node(null);
            node.size = 0;
            node.color = Color.BLACK;
            return node;
        }

        public void add(E key) {
            Node<E> y = NIL;
            Node<E> x = root;
            int lastComparisonResult = -1;
            while (x != NIL) {
                x.size++;
                y = x;
                lastComparisonResult = comparator.compare(key, x.key);
                x = lastComparisonResult < 0 ? x.left : x.right;
            }
            Node<E> newNode = new Node<E>(key);
            if (y == NIL) {
                root = newNode;
            } else if (lastComparisonResult < 0) {
                y.left = newNode;
                newNode.parent = y;
            } else {
                y.right = newNode;
                newNode.parent = y;
            }
            newNode.color = Color.RED;
            addFixup(newNode);
        }

        private void addFixup(Node<E> z) {
            while (z.parent.color == Color.RED) {
                if (z.parent == z.parent.parent.left) {
                    if (z.parent.parent.right.color == Color.RED) {
                        z.parent.color = Color.BLACK;
                        z = z.parent.parent;
                        z.right.color = Color.BLACK;
                        z.color = Color.RED;
                    } else {
                        if (z == z.parent.right) {
                            z = z.parent;
                            leftRotate(z);
                        }
                        z.parent.color = Color.BLACK;
                        z.parent.parent.color = Color.RED;
                        rightRotate(z.parent.parent);
                    }
                } else {
                    if (z.parent.parent.left.color == Color.RED) {
                        z.parent.color = Color.BLACK;
                        z = z.parent.parent;
                        z.left.color = Color.BLACK;
                        z.color = Color.RED;
                    } else {
                        if (z == z.parent.left) {
                            z = z.parent;
                            rightRotate(z);
                        }
                        z.parent.color = Color.BLACK;
                        z.parent.parent.color = Color.RED;
                        leftRotate(z.parent.parent);
                    }
                }
            }
            root.color = Color.BLACK;
        }

        public boolean remove(E key) {
            Node<E> z = search(key);
            if (z == NIL) {
                return false;
            }
            Node<E> y = (z.left != NIL && z.right != NIL) ? successor(z) : z;
            //y can't have both children by definition (successor can not have left child in this situation)
            Node<E> yChild = (y.left != NIL) ? y.left : y.right;
            yChild.parent = y.parent; //Even if yChild is NIL
            if (y.parent == NIL) {
                root = yChild;
            } else if (y.parent.left == y) {
                y.parent.left = yChild;
            } else {
                y.parent.right = yChild;
            }
            if (y != z) {
                z.key = y.key;
            }
            Node<E> sizeFixup = y.parent;
            while (sizeFixup != NIL) {
                updateSize(sizeFixup);
                sizeFixup = sizeFixup.parent;
            }
            if (y.color == Color.BLACK) {
                removeFixup(yChild);
            }
            return true;
        }

        private void removeFixup(Node<E> x) {
            while (x != root && x.color == Color.BLACK) {
                if (x == x.parent.left) {
                    Node<E> w = x.parent.right;
                    if (w.color == Color.RED) {
                        w.color = Color.BLACK;
                        x.parent.color = Color.RED;
                        leftRotate(x.parent);
                        w = x.parent.right;
                    }
                    if (w.left.color == Color.BLACK && w.right.color == Color.BLACK) {
                        w.color = Color.RED;
                        x = x.parent;
                    } else {
                        if (w.right.color == Color.BLACK) {
                            w.left.color = Color.BLACK;
                            w.color = Color.RED;
                            rightRotate(w);
                            w = x.parent.right;
                        }
                        //w is black, w.right is red
                        w.color = x.parent.color;
                        x.parent.color = w.right.color = Color.BLACK;
                        leftRotate(x.parent);
                        x = root;
                    }
                } else {
                    Node<E> w = x.parent.left;
                    if (w.color == Color.RED) {
                        w.color = Color.BLACK;
                        x.parent.color = Color.RED;
                        rightRotate(x.parent);
                        w = x.parent.left;
                    }
                    if (w.right.color == Color.BLACK && w.left.color == Color.BLACK) {
                        w.color = Color.RED;
                        x = x.parent;
                    } else {
                        if (w.left.color == Color.BLACK) {
                            w.right.color = Color.BLACK;
                            w.color = Color.RED;
                            leftRotate(w);
                            w = x.parent.left;
                        }
                        //w is black, w.left is red
                        w.color = x.parent.color;
                        x.parent.color = w.left.color = Color.BLACK;
                        rightRotate(x.parent);
                        x = root;
                    }
                }
            }
            x.color = Color.BLACK;
        }

        private Node<E> search(E key) {
            Node<E> node = root;
            while (node != NIL) {
                int compareResult = compare(key, node);
                if (compareResult == 0) {
                    return node;
                } else if (compareResult < 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            return NIL;
        }

        private int compare(E key, Node<E> node) {
            return comparator.compare(key, node.key);
        }

        private Node<E> successor(Node<E> node) {
            if (node.right != NIL) {
                return min(node.right);
            }
            Node<E> parent = node.parent;
            while (parent != NIL && parent.right == node) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }

        private Node<E> min(Node<E> node) {
            while (node.left != NIL) {
                node = node.left;
            }
            return node;
        }

        private void leftRotate(Node<E> x) {
            Node<E> y = x.right;
            x.right = y.left;
            if (y.left != NIL) {
                y.left.parent = x;
            }
            y.parent = x.parent;
            if (x.parent == NIL) {
                root = y;
            } else if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
            x.parent = y;
            y.left = x;
            updateSize(x);
            updateSize(y);
        }

        private void rightRotate(Node<E> y) {
            Node<E> x = y.left;
            y.left = x.right;
            if (y.left != NIL) {
                y.left.parent = y;
            }
            x.right = y;
            x.parent = y.parent;
            if (y.parent == NIL) {
                root = x;
            } else if (y.parent.left == y) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
            y.parent = x;
            updateSize(y);
            updateSize(x);
        }

        private void updateSize(Node<E> node) {
            node.size = node.left.size + node.right.size + 1;
        }

        public E select(int k) {
            return select(root, k + 1).key;
        }

        private Node<E> select(Node<E> root, int k) {
            int r = root.left.size + 1;
            if (r == k) {
                return root;
            } else if (r > k) {
                return select(root.left, k);
            } else {
                return select(root.right, k - r);
            }
        }

        final class Node<T> {
            T key;
            Node<T> left = NIL;
            Node<T> right = NIL;
            Node<T> parent = NIL;
            Color color;

            /** The size of sub-tree with this node as the root */
            int size = 1;

            public Node(T key) {
                this.key = key;
            }
        }

        static enum Color {
            BLACK,
            RED,
        }
    }

}
