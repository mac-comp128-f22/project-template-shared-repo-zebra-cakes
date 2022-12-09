//imports
import java.awt.Color;

/**
 * A class to represent a red and black search tree.
 * Red and black trees self-balance to maintain a heights that follow a set of rules based on color 
 *
 * @author Bret Jackson, Mayank Jaiswal, (adjusted by Brayden Coronado, Devinn Chi, and Minh Nguyen to work with Red and Black trees)
 */
public class RedAndBlackTree<E extends Comparable<E>> extends BinarySearchTree<E> {
    protected boolean addReturn;

    /**
     * Left rotation of x around the pivot node
     * @param pivot
     * @ret
    */
    private Node<E> rotateLeft(Node<E> pivot) {
        //create new AVLNode x, it takes the value of the right child of pivot (for rotation, x will be new root)
        //create new AVLNode t2, node that is the left child of pivot
        Node<E> x = ((Node<E>) pivot.right);
        Node<E> t2 = ((Node<E>) x.left);
        pivot.right = t2;
        Node<E> parent = pivot.parent;
        //if pivot does have a pointer to a parent..
        if(t2 != null) {

           //t2's parent is pivot
           t2.parent = pivot;
        }

        //x's left, pivot, reset pointer after rotation
        //x's parent is pivot's parent
        //pivot's parent is x (new root)
        x.left = pivot;
        x.parent = pivot.parent;
        pivot.parent = x;
        if (x.parent != null) {
            if (x.data.compareTo(x.parent.data) < 0) {
                x.parent.left = x;
            } else {
                x.parent.right = x;
            }
        }
        return x;
    }

    /**
     * Right rotation of x around the pivot node
     * @param pivot
     * @return
     */
    private Node<E> rotateRight(Node<E> pivot) {
        //create new AVLNode x, it takes the value of the right child of pivot (for rotation, x will be new root)
        //create new AVLNode t2, node that is the right child of x
        Node<E> x = ((Node<E>) pivot.left);
        Node<E> t2 = ((Node<E>) x.right);
        pivot.left = t2;
        //if pivot does have a pointer to a parent..
        if(t2 != null) {

            //new parent node is created, 
            //which has the value of pivot's parent node
            t2.parent = pivot;
        }

        //x's right, pivot, reset pointer after rotation
        //x's right is pivot
        //pivot's parent is x (new root)
        x.right = pivot;
        x.parent = pivot.parent;
        pivot.parent = x;
        if (x.parent != null) {
            if (x.data.compareTo(x.parent.data) < 0) {
                x.parent.left = x;
            } else {
                x.parent.right = x;
            }
        }
        return x;
    }

    /**
     * 
     */
    public void deleteRebalance(Node<E> node) {
        while (node.parent != null && node.color == Color.black) {
            if (node == node.parent.right) {
                Node<E> sibling = node.parent.left;
                Color siblingColor = Color.black;
                if (siblingColor != null && sibling.color == Color.red) {
                    siblingColor = Color.red;
                }
                if (siblingColor == Color.red) {
                    sibling.setBlack();
                    node.parent.setRed();
                    rotateRight(node.parent);
                    sibling = node.parent.left;
                }
                Color leftSiblingColor = Color.black;
                Color rightSiblingColor = Color.black;
                if (sibling.left != null && sibling.left.color == Color.red) {
                    leftSiblingColor = Color.red;
                } 
                if (sibling.right != null && sibling.right.color == Color.red) {
                    rightSiblingColor = Color.red;
                }
                if (leftSiblingColor == Color.black && rightSiblingColor == Color.black) {
                    sibling.setRed();
                    node = node.parent;
                } else {
                    if (leftSiblingColor == Color.black) {
                        sibling.right.setBlack();
                        sibling.setRed();
                        rotateLeft(sibling);
                        sibling = node.parent.left;
                    }
                    sibling.color = node.parent.color;
                    node.parent.setBlack();
                    sibling.left.setBlack();
                    rotateRight(node.parent);
                    node = root;
                } 
            }
            if (node == node.parent.left) {
                Node<E> sibling = node.parent.right;
                Color siblingColor = Color.black;
                if (siblingColor != null && sibling.color == Color.red) {
                    siblingColor = Color.red;
                }
                if (siblingColor == Color.red) {
                    sibling.setBlack();
                    node.parent.setRed();
                    rotateLeft(node.parent);
                    sibling = node.parent.right;
                }
                Color leftSiblingColor = Color.black;
                Color rightSiblingColor = Color.black;
                if (sibling.right != null && sibling.left.color == Color.red) {
                    leftSiblingColor = Color.red;
                } 
                if (sibling.right != null && sibling.right.color == Color.red) {
                    rightSiblingColor = Color.red;
                }
                if (leftSiblingColor == Color.black && rightSiblingColor == Color.black) {
                    sibling.setRed();
                    node = node.parent;
                } else {
                    if (rightSiblingColor == Color.black) {
                        sibling.left.setBlack();
                        sibling.setRed();
                        rotateRight(sibling);
                        sibling = node.parent.right;
                    }
                    sibling.color = node.parent.color;
                    node.parent.setBlack();
                    sibling.right.setBlack();
                    rotateLeft(node.parent);
                    node = root;
                } 
            }
        }
        node.setBlack();
    }

    /**
     * 
     */
    public Node<E> add(Node<E> localRoot, Node<E> parent, Node <E> item) {
        if (localRoot == null) {
            // item is not in the tree � insert it.
            addReturn = true;
            // Node<E> newNode = new Node<E>(item);
            item.parent = parent;
            return item;
        } else if (item.data.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        } else if (item.data.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, localRoot, item);
            return localRoot;
        } else {
            // item is greater than localRoot.data
            localRoot.right = add(localRoot.right, localRoot, item);
            return localRoot;
        }
    }

    /**
     * 
     */
    private Node<E> delete(Node<E> localRoot, Node<E> item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }

        // Search for item to delete.
        int compResult = item.data.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            if (localRoot.left != null) {
                localRoot.left.parent = localRoot;
            }
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            if (localRoot.right != null) {
                localRoot.right.parent = localRoot;
            }
            return localRoot;
        } else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    localRoot.updateGraphics();
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    if (localRoot.left != null) {
                        localRoot.left.parent = localRoot;
                    }
                    return localRoot;
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    localRoot.updateGraphics();
                    return localRoot;
                }
            }
        }
    }

    /**
     * 
     * @param parent
     * @return
     */
    private E findLargestChild(Node<E> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            if (parent.right != null) {
                parent.right.parent = parent;
            }
            return returnValue;
        } else {
            return findLargestChild(parent.right);
        }
    }

    /**
     * 
     * @param localRoot
     * @param target
     * @return
     */
    private Node<E> findNode(Node<E> localRoot, E target) {
        if (localRoot == null) {
            return null;
        }

        // Compare the target with the data field at the root.
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0) {
            return localRoot;
        } else if (compResult < 0) {
            return findNode(localRoot.left, target);
        } else {
            return findNode(localRoot.right, target);
        }
    }
    
    /**
     * 
     */
    @Override
    public E delete(E item) {
        Node<E> itemNode = new Node<E>(item);
        Node<E> itemNodeArchive = findNode(root, item);
        root = this.delete(root, itemNode);
        updateRoot();
        deleteRebalance(itemNodeArchive);
        return null;
    }

    /**
     * 
     */
    @Override
    public boolean add(E item) {
        Node<E> itemNode = new Node<E>(item);
        root = this.add(root, null, itemNode);
        itemNode.setRed();
        if (itemNode.parent == null) {
            itemNode.setBlack();
            return addReturn;
        }
        if (itemNode.parent.parent == null) {
            return addReturn;
        } 
        insertRebalance(itemNode);
        return addReturn;
    }

    /**
     * 
     */
    public void updateRoot() {
        while (root.parent!= null) {
            root = root.parent;
        }
    }   

    /**
     * 
     */
    public void insertRebalance (Node<E> node) {
        while (node.parent != null && node.parent.color == Color.red) {
            if (node.parent == node.parent.parent.right) {
                Node<E> uncle = node.parent.parent.left;
                Color uncleColor = Color.red;
                if (uncle == null || uncle.color == Color.black) {
                    uncleColor = Color.black;
                }
                if (uncleColor == Color.red) {
                    node.parent.setBlack();
                    uncle.setBlack();
                    node.parent.parent.setRed();
                    node = node.parent.parent;
                } else if (node == node.parent.right) {
                    node.parent.setBlack();
                    node.parent.parent.setRed();
                    rotateLeft(node.parent.parent);
                } else {
                    node = node.parent;
                    rotateRight(node);
                    node.parent.setBlack();
                    node.parent.parent.setRed();
                    rotateLeft(node.parent.parent);
                }
            } else {
                Node<E> uncle = node.parent.parent.right;
                Color uncleColor = Color.red;
                if (uncle == null || uncle.color == Color.black) {
                    uncleColor = Color.black;
                }
                if (uncleColor == Color.red) {
                    node.parent.setBlack();
                    uncle.setBlack();
                    node.parent.parent.setRed();
                    node = node.parent.parent;
                } else if (node == node.parent.left) {
                    node.parent.setBlack();
                    node.parent.parent.setRed();
                    rotateRight(node.parent.parent);
                } else if (node == node.parent.right) {
                    node = node.parent;
                    rotateLeft(node);
                    node.parent.setBlack();
                    node.parent.parent.setRed();
                    rotateRight(node.parent.parent);
                }
            }
            updateRoot();
            root.setBlack();   
        }
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        RedAndBlackTree<Integer> test = new RedAndBlackTree<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        test.delete(1);
        test.delete(2);
    }
}

