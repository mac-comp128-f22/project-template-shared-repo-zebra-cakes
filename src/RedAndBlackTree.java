import java.awt.Color;
/**
 * A class to represent a red and black search tree.
 * Red and black trees self-balance to maintain a heights that only differ by at most 1 between the left and right child. Only supports addition
 *
 * @author Bret Jackson, Mayank Jaiswal, (adjusted by Brayden Coronado, Devinn Chi, and Minh Nguyen to work with Red and Black trees with reference from https://www.programiz.com/dsa/red-black-tree)
 */
public class RedAndBlackTree<E extends Comparable<E>> extends BinarySearchTree<E> {
    protected boolean addReturn;
    /**
     * Left rotation of x around the pivot node
     *    pivot                      x
     *    /  \                     /  \
     *   T1   x        ----->  pivot  T3
     *       / \                /  \
     *     T2  T3              T1  T2
     * @param pivot
     * @ret
    */

    private Node<E> rotateLeft(Node<E> pivot) {
        //create new AVLNode x, it takes the value of the right child of pivot (for rotation, x will be new root)
        //create new AVLNode t2, node that is the left child of pivot
        Node<E> x = ((Node<E>) pivot.right);
        Node<E> t2 = ((Node<E>) x.left);
        pivot.right = t2;
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
     *         pivot                 x
     *         /  \                /  \
     *        x   T3    ----->   T1   pivot
     *       / \                      /  \
     *     T1  T2                    T2  T3
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

    // public void deleteRebalance(Node<E> node) {
    //     while (node.parent != null && node.color == Color.black) {
    //         if (node == node.parent.right) {
    //             Node<E> sibling = node.parent.left;
    //             Color siblingColor = Color.black;
    //             if (siblingColor != null && sibling.color == Color.red) {
    //                 siblingColor = Color.red;
    //             }
    //             if (siblingColor == Color.red) {
    //                 sibling.setBlack();
    //                 node.parent.setRed();
    //                 rotateRight(node.parent);
    //                 sibling = node.parent.left;
    //             }
    //             Color leftSiblingColor = Color.black;
    //             Color rightSiblingColor = Color.black;
    //             if (sibling.left != null && sibling.left.color == Color.red) {
    //                 leftSiblingColor = Color.red;
    //             } 
    //             if (sibling.right != null && sibling.right.color == Color.red) {
    //                 rightSiblingColor = Color.red;
    //             }
    //             if (leftSiblingColor == Color.black && rightSiblingColor == Color.black) {
    //                 sibling.setRed();
    //                 node = node.parent;
    //             } else {
    //                 if (leftSiblingColor == Color.black) {
    //                     sibling.right.setBlack();
    //                     sibling.setRed();
    //                     rotateLeft(sibling);
    //                     sibling = node.parent.left;
    //                 }
    //                 sibling.color = node.parent.color;
    //                 node.parent.setBlack();
    //                 sibling.left.setBlack();
    //                 rotateRight(node.parent);
    //                 updateRoot();
    //                 node = root;
    //             } 
    //         }
    //         if (node == node.parent.left) {
    //             Node<E> sibling = node.parent.right;
    //             Color siblingColor = Color.black;
    //             if (siblingColor != null && sibling.color == Color.red) {
    //                 siblingColor = Color.red;
    //             }
    //             if (siblingColor == Color.red) {
    //                 sibling.setBlack();
    //                 node.parent.setRed();
    //                 rotateLeft(node.parent);
    //                 sibling = node.parent.right;
    //             }
    //             Color leftSiblingColor = Color.black;
    //             Color rightSiblingColor = Color.black;
    //             if (sibling.right != null && sibling.left.color == Color.red) {
    //                 leftSiblingColor = Color.red;
    //             } 
    //             if (sibling.right != null && sibling.right.color == Color.red) {
    //                 rightSiblingColor = Color.red;
    //             }
    //             if (leftSiblingColor == Color.black && rightSiblingColor == Color.black) {
    //                 sibling.setRed();
    //                 node = node.parent;
    //             } else {
    //                 if (rightSiblingColor == Color.black) {
    //                     sibling.left.setBlack();
    //                     sibling.setRed();
    //                     rotateRight(sibling);
    //                     sibling = node.parent.right;
    //                 }
    //                 sibling.color = node.parent.color;
    //                 node.parent.setBlack();
    //                 sibling.right.setBlack();
    //                 rotateLeft(node.parent);
    //                 updateRoot();
    //                 node = root;
    //             } 
    //         }
    //     }
    //     root.setBlack();
    // }

    /**
     * Add a node to the tree, comparing it to the local root
     * @param localRoot the root of the subtree
     * @param parent parent of the newly added node
     * @param item the node being added
     * @return
     */

    public Node<E> add(Node<E> localRoot, Node<E> parent, Node <E> item) {
        if (localRoot == null) {
            // item is not in the tree � insert it.
            addReturn = true;
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

    // private Node<E> findNode(Node<E> localRoot, E target) {
    //     if (localRoot == null) {
    //         return null;
    //     }

    //     // Compare the target with the data field at the root.
    //     int compResult = target.compareTo(localRoot.data);
    //     if (compResult == 0) {
    //         return localRoot;
    //     } else if (compResult < 0) {
    //         return findNode(localRoot.left, target);
    //     } else {
    //         return findNode(localRoot.right, target);
    //     }
    // }
        
    // @Override
    // public E delete(E item) {
    //     Node<E> origin;
    //     Node<E> inOrderSuccessor;
    //     Node<E> itemNode = findNode(root, item);
    //     if (itemNode == null) {
    //         return null;
    //     }
    //     Color originalColor = itemNode.color;
    //     if (itemNode.left == null) {
    //         origin = itemNode.right;
    //         transplant(itemNode, itemNode.right);
    //     } else if (itemNode.right == null) {
    //         origin = itemNode.left;
    //         transplant(itemNode, itemNode.left);
    //     } else {
    //         inOrderSuccessor = findSmallestChild(itemNode.right);
    //         originalColor = inOrderSuccessor.color;
    //         origin = itemNode.right;
    //         if (inOrderSuccessor.parent == itemNode) {
    //             origin.parent = inOrderSuccessor;
    //         } else {
    //             transplant(inOrderSuccessor, inOrderSuccessor.right);
    //             inOrderSuccessor.right = itemNode.right;
    //             inOrderSuccessor.right.parent = inOrderSuccessor; 
    //         }
    //         transplant(itemNode, inOrderSuccessor);
    //         inOrderSuccessor.left = itemNode.left;
    //         inOrderSuccessor.left.parent = inOrderSuccessor;
    //         inOrderSuccessor.color = itemNode.color;
    //     }

    //     if (originalColor == Color.black) {
    //         deleteRebalance(origin);
    //     }
    //     return itemNode.data;
    // }

    // private void transplant(Node<E> parent, Node<E> child) {
    //     if (parent.parent == null) {
    //         root = child;
    //     } else if (parent == parent.parent.left) {
    //         parent.left = child;
    //     } else {
    //         parent.right = child;
    //     }
    //     child.parent = parent.parent;
    // }

    // private Node<E> findSmallestChild(Node<E> parent) {
    //     Node<E> current = parent;

    //     /* loop down to find the leftmost leaf */
    //     while (current.left != null)
    //     {
    //         current = current.left;
    //     }
    //     return current;
    // }

    @Override
    public E delete(E item) {
        return null;
        //We tried implementing delete, which did not work out. All the codes commented out showed our attempt.
    }
    

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

    /*
     * Update the root of the tree
     */
    public void updateRoot() {
        while (root.parent!= null) {
            root = root.parent;
        }
    }

    /**
     * Assisit in rebalancing the tree affer addition of a node
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
        }
        updateRoot();
        root.setBlack();
    }

    public static void main(String[] args) {
        RedAndBlackTree<Integer> test = new RedAndBlackTree<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
    }
}



