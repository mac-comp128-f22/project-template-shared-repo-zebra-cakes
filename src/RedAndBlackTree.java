import java.awt.Color;
/**
 * A class to represent a red and black search tree.
 * Red and black trees self-balance to maintain a heights that only differ by at most 1 between the left and right child
 *
 * @author Bret Jackson, Mayank Jaiswal, (adjusted by Brayden Coronado, Devinn Chi, and Minh Nguyen to work with Red and Black trees)
 */
public class RedAndBlackTree<E extends Comparable<E>> extends BinarySearchTree<E> {
    protected boolean addReturn;
    // Inner class that extends Node to add a heightFromLeaf property to calculate the balance factor
    protected static class RedAndBlackNode<E> extends Node<E>{
        public int heightFromLeaf;

        public RedAndBlackNode(E data) {
            super(data);
            heightFromLeaf = 1; // nodes are created at the leaves so start with a height of 1
        }
    }

    protected static class NilNode<E> extends RedAndBlackNode<E> {
        public NilNode() {
            super(null);
        }
    }

    private void adjustBasedOnBlack (RedAndBlackNode<E> node, RedAndBlackNode<E> siblingNode) {
        boolean nodeIsLeftChild = node == node.parent.left;

        if (nodeIsLeftChild && siblingNode.right.color == Color.black) {
            siblingNode.left.color = Color.black;
            siblingNode.color = Color.red;
            rotateRight(siblingNode);
            siblingNode = (RedAndBlackNode<E>) node.parent.right;
        } else if (!nodeIsLeftChild && siblingNode.left.color == Color.black) {
            siblingNode.right.color = Color.black;
            siblingNode.color = Color.red;
            rotateLeft(siblingNode);
            siblingNode = (RedAndBlackNode<E>) node.parent.left;
        }
        siblingNode.color = node.parent.color;
        node.parent.color = Color.black;
        if (nodeIsLeftChild) {
            siblingNode.right.color = Color.black;
            rotateLeft((RedAndBlackNode<E>)node.parent);
        }else {
            siblingNode.left.color = Color.black;
            rotateRight((RedAndBlackNode<E>) node.parent);
        }
    }

    /**
     * Method to adjust node based on its sibling
     * @param node
     * @param siblingNode
     */
    private void adjustBasedOnRed(RedAndBlackNode<E> node, RedAndBlackNode<E> siblingNode) {
        siblingNode.color = Color.black;
        node.parent.color = Color.red;
        if (node == node.parent.left) {
            rotateLeft((RedAndBlackNode<E>)node.parent);
        } else {
            rotateRight((RedAndBlackNode<E>) node.parent);
        }
    }

    /**
     * Returns the sibling of a node
     * @param searchNode
     * @return
     */
    private RedAndBlackNode<E> getSibling(RedAndBlackNode<E> searchNode) {
        RedAndBlackNode<E> parentNode = (RedAndBlackNode<E>) searchNode.parent;
        if (searchNode  == parentNode.left) {
            return (RedAndBlackNode<E>) parentNode.right;
        } else {
            return (RedAndBlackNode<E>) parentNode.left;
        }
    }

    /**
     * Gets the color of a node
     * @param nodeToReadjust
     */
    private void readjustColor(RedAndBlackNode<E> nodeToReadjust) {
        if (nodeToReadjust == root) {
            return;
        }

        RedAndBlackNode<E> siblingNode = getSibling(nodeToReadjust);

        if (siblingNode.color == Color.red) {
            adjustBasedOnRed(nodeToReadjust, siblingNode);
            siblingNode = getSibling(nodeToReadjust);
        }
        if (siblingNode.left.color == Color.black && siblingNode.right.color == Color.black) {
            siblingNode.color = Color.red;
            if (nodeToReadjust.parent.color == Color.red) {
                nodeToReadjust.parent.color = Color.black;
            } else {
                readjustColor((RedAndBlackNode<E>) nodeToReadjust.parent);
            }
        } else {
            adjustBasedOnBlack(nodeToReadjust, siblingNode);
        }
    }

    /**
     * Finds the minimum node
     * @param nodeToSearch
     * @return
     */
    private RedAndBlackNode<E> findMinimum(RedAndBlackNode<E> nodeToSearch) {
        while (nodeToSearch.left != null) {
            nodeToSearch = (RedAndBlackNode<E>) nodeToSearch.left;
        }
        return nodeToSearch;
    }

    /**
     * Deletes the node if one or no child
     */
    private RedAndBlackNode<E> deleteNodeWithOneOrNoChild(RedAndBlackNode<E> nodeToDelete) {
        RedAndBlackNode nilChild = new RedAndBlackNode(null);
        if (nodeToDelete.left != null) {
            replaceParentsChild((RedAndBlackNode<E>)nodeToDelete.parent, nodeToDelete, (RedAndBlackNode<E>)nodeToDelete.left);
            return (RedAndBlackNode<E>) nodeToDelete.left;
        } else if (nodeToDelete.right != null) {
            replaceParentsChild((RedAndBlackNode<E>)nodeToDelete.parent, nodeToDelete, (RedAndBlackNode<E>)nodeToDelete.right);
            return (RedAndBlackNode<E>) nodeToDelete.right;
        } else {
            nilChild = nilChild.color == Color.black ? new NilNode() : null;
            replaceParentsChild((RedAndBlackNode<E>)nodeToDelete.parent, nodeToDelete, nilChild);
            return nilChild;
        }

    }

    /**
     * deletes the node
     * @param key
     */
    public void deleteNode(E key) {
        RedAndBlackNode<E> searchNode = (RedAndBlackNode<E>) root;

        while (searchNode.data != key && searchNode != null) {
            if (key.compareTo(searchNode.data) < 0) {
                searchNode = (RedAndBlackNode<E>) searchNode.left;
            } else {
                searchNode  = (RedAndBlackNode<E>) searchNode.right;
            }
        }
        if (searchNode == null) {
             return;
        }

        RedAndBlackNode<E> nodeToMove = new RedAndBlackNode<E>(null);
        Color deletedNodeColor;

        if (searchNode.left == null || searchNode.right == null) {
            nodeToMove = deleteNodeWithOneOrNoChild(searchNode);
            deletedNodeColor = searchNode.color;
        } else {
            RedAndBlackNode<E> successor = findMinimum((RedAndBlackNode<E>)searchNode.right);
            searchNode.data = successor.data;
            deletedNodeColor = successor.color;
        }
        if (deletedNodeColor == Color.black) {
            readjustColor(nodeToMove);
            if (nodeToMove.getClass() == NilNode.class) {
                replaceParentsChild((RedAndBlackNode<E>)nodeToMove.parent, nodeToMove, null);
            }
        }
    }

    /**
     * handles rotations for nodes
     * @param insertedNode
     */
    private void rotations(RedAndBlackNode<E> insertedNode) {
        RedAndBlackNode<E> parentNode = (RedAndBlackNode<E>) insertedNode.parent;
        if (parentNode == null) {
            insertedNode.color = Color.black;
            return;
        }
        if (parentNode.color == Color.black) {
            return;
        }

        RedAndBlackNode<E> grandparentNode = (RedAndBlackNode<E>) parentNode.parent;

        if (grandparentNode == null) {
            parentNode.color =Color.black;
            return;
        }

        RedAndBlackNode<E> uncleNode = getUncle(parentNode);

        if (uncleNode != null && uncleNode.color == Color.black) {
            parentNode.color = Color.black;
            grandparentNode.color = Color.red;
            uncleNode.color = Color.black;

            rotations(grandparentNode);
        } else if (parentNode == grandparentNode.left) {
            if (insertedNode == parentNode.right) {
                rotateLeft(parentNode);
                parentNode = insertedNode;
            }
            rotateRight(grandparentNode);
            parentNode.color = Color.black;
            grandparentNode.color = Color.red;
        } else {
            if (insertedNode == parentNode.left) {
                rotateRight(parentNode);
                parentNode = insertedNode;
            }
            rotateLeft(grandparentNode);
            parentNode.color = Color.black;
            grandparentNode.color = Color.red;
        }
    }

    /**
     * Gets the uncle node of the parent
     * @param parentNode
     * @return
     */
    public RedAndBlackNode<E> getUncle(RedAndBlackNode<E> parentNode) {
        RedAndBlackNode<E> grandparentNode = (RedAndBlackNode<E>) parentNode.parent;
        if (grandparentNode.right == parentNode) {
            return (RedAndBlackNode<E>) grandparentNode.right;
        } else {
            return (RedAndBlackNode<E>) grandparentNode.left;
        }
    }

    /**
     * Handles the insertion of a node
     * @param parentNode
     * @param key
     */
    public void insert(RedAndBlackNode<E> parentNode, E key) {
        RedAndBlackNode<E> nodeToInsert = new RedAndBlackNode<E>(key);
        nodeToInsert.color = Color.red;
        if (parentNode == nodeToInsert) {
            root = nodeToInsert;
        } else if (key.compareTo(parentNode.data) < 0) {
            parentNode.left = nodeToInsert;
        } else {
            parentNode.right = nodeToInsert;
        }
        nodeToInsert.parent = parentNode;

        rotations(nodeToInsert);

    }

    /**
     * adds node
     * @param key
     */
    public void addNode(E key) {
        RedAndBlackNode<E> nodeSearcher = ((RedAndBlackNode<E>)root);
        RedAndBlackNode<E> parent = null;

        for (;;) {
            if (nodeSearcher == null) {
                break;
            } 
            parent = nodeSearcher;
            if (key.compareTo(nodeSearcher.data) < 0) {
                nodeSearcher = (RedAndBlackNode<E>) nodeSearcher.left;
            } else if (key.compareTo(nodeSearcher.data) > 0) {
                nodeSearcher = (RedAndBlackNode<E>) nodeSearcher.right;
            }
        }
        insert(parent, key);
    }

    /**
     * Searches for input node based on key
     * @param key
     * @return
     */
    public RedAndBlackNode<E> searchForNode(E key) {
        RedAndBlackNode<E> nodeSearcher = ((RedAndBlackNode<E>)root);
        for (;;) {
            if (nodeSearcher == null) {
                return null;
            } else if (key.compareTo(nodeSearcher.data) == 0) {
                return nodeSearcher;
            } else if (key.compareTo(nodeSearcher.data) < 0) {
                nodeSearcher = (RedAndBlackNode<E>) nodeSearcher.left;
            } else {
                nodeSearcher = (RedAndBlackNode<E>) nodeSearcher.right;
            }
        }
    }

    /**
     * replaces the child of the parent inputted
     * @param parentNode
     * @param oldChildNode
     * @param newChildNode
     */
    private void replaceParentsChild(RedAndBlackNode<E> parentNode, RedAndBlackNode<E> oldChildNode, RedAndBlackNode<E> newChildNode) {
        if (parentNode == null) {
            root = newChildNode;
        } else if (parentNode.left == oldChildNode) {
            parentNode.left = newChildNode;
        } else if (parentNode.right == oldChildNode) {
            parentNode.right = newChildNode;
        }
        if (newChildNode != null) {
            newChildNode.parent = parentNode;
        }
    }

    /**
     * Left rotation of x around the pivot node
     * @param pivot
     * @return
     */
    private void rotateLeft(RedAndBlackNode<E> pivot) {

        RedAndBlackNode<E> parent = ((RedAndBlackNode<E>) pivot.parent);
        RedAndBlackNode<E> pivotRightChild = ((RedAndBlackNode<E>) pivot.right);
        pivot.right = pivotRightChild.left;

        if(pivotRightChild.left != null) {
            pivotRightChild.left.parent = pivot;
        }

        pivotRightChild.left = pivot;
        pivot.parent = pivotRightChild;

        if (parent == null) {
            root = pivotRightChild;
        } else if(pivot.left == pivot) {
            parent.left = pivotRightChild;
        } else if(parent.right == pivot) {
            parent.right = pivotRightChild;
        }

        if (pivotRightChild != null) {
            pivotRightChild.parent = parent;
        }
    }

    /**
     * Right rotation of x around the pivot node
     * @param pivot
     * @return
     */
    private void rotateRight(RedAndBlackNode<E> pivot) {


        RedAndBlackNode<E> parent = ((RedAndBlackNode<E>) pivot.parent);
        RedAndBlackNode<E> pivotLeftChild = ((RedAndBlackNode<E>) pivot.left);
        pivot.left = pivotLeftChild.right;

        if(pivotLeftChild.right != null) {
            pivotLeftChild.right.parent = pivot;
        }

        pivotLeftChild.right = pivot;
        pivot.parent = pivotLeftChild;

        if (parent == null) {
            root = pivotLeftChild;
        } else if(pivot.left == pivot) {
            parent.left = pivotLeftChild;
        } else if(parent.right == pivot) {
            parent.right = pivotLeftChild;
        }

        if (pivotLeftChild != null) {
            pivotLeftChild.parent = parent;
        }
    }


   

    


    

}

