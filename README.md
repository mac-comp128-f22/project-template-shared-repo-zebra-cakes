# Binary Tree Visualizer - Zebra Cakes
Project Title - Binary Tree Visualizer

Group - Zebra Cakes

Members - Minh Nguyen | Brayden Coronado | Devinn Chi

# Information About Our Project
Project Goal - We attempted to create a visualization GUI in Java that would be able to accurately represent the automatic balancing operations done with an AVL Binary search Tree and a Black and Red Binary Search Tree. We allowed to user to input an array of values (one input at a time) with no duplicate values, and a maximum number of values that would represent a complete and full Binary Search Tree (31) of height 4. Our GUI also prints out the Inorder, Preorder, and Postorder traversals of the tree that is created. Each traversal is represented in its array form, with the order of the array being the order of the nodes to be traversed. Another strict boundary we made sure to add was that each value added to the Binary Search Tree through user input can ONLY be an Integer (not a double or string or anything else).

# Steps to run our project 
1. Upon running the app, select either the Black and Red or AVL picture to select which type of automatic rebalancing will be implemented.

2. After selecting which type of tree you want to visualize, add each value you want to be added to the tree using the input box.

3. Every time you want to add a node, (must be an integer) after entering your value, you must press the "add" button which is right next to the input box.

4. The input box does not accept duplicate values or any values which are not integers. It also does not accept more than 31 values because we are limiting our input amount to be the amount of nodes in a full and complete binary search tree. 

5. If you want to remove a value you inputted, you can press the "remove" button which will be next to the input box.

6. When you are finished entering your values into the input box, you can press the "done" button.

7. VOILA! On the next screen you will see your inputs being added to the binary search tree which will be sorted by the method you chose in the first step. You will also see each of the traversals represented in array form. 

# Information About Our Classes and Their Methods
AVLHomepageButton ( implements PleasingButton interface )

@author Minh Nguyen, Brayden Coronado, Devinn Chi

This class is used to create a button which is represented as an image of an AVL Tree. Pressing this button leads to the input screen.

        --Methods

            - AVLHomepageButton(double size, CanvasWindow canvas) :: Class level object, creates the AVL home page button and creates a border around it upon hovering.
            
            - getButtonGraphics() :: Returns the graphics group which the AVL home button page is on.

            - update() :: Updates the AVL label

            - updateLayout() :: Updates layout of avlicon and avllabel. Initializes variables which are used to create borders.

            - getSize() :: Returns the value of the size variable

            - onHover(Point position) :: Runs the visual on hover effect. Borders around the image button appear.

            - onClick(Point position, TextField textField, Button button, Button doneButton, Button removeButton, Button backButton) :: Upon clicking the avl label button, this function will clear the canvas and add the input box screen.


AVLTree ( AVLTree<E extends Comparable<E>> extends BinarySearchTree<E> )

@author Bret Jackson, Mayank Jaiswal

A class to represent an AVL binary search tree. AVL trees self-balance to maintain a heights that only differ by at most 1 between the left and right child.

        --Methods

            - heightFromLeaf(Node<E> node) :: Convenience funtion to check for null and convert nodes to AVLNodes when getting the heightfromLeaf.

            - getBalance(Node<E> node) :: Calculates the balance factor for node.

            - rotateLeft(AVLNode<E> pivot) :: Left rotation of x around the pivot node.

            - rotateRight(AVLNode<E> pivot) :: Right rotation of x around the pivot node.

            - add(E item) :: The object being inserted. Return true if the object is inserted, false if the object already exists in the tree. The object to insert must implement the Comparable interface.

            - add(AVLNode<E> localRoot, AVLNode<E> parent, E item) :: Recursive add method.

            - delete(E target) :: Starter method delete.

            - delete(AVLNode<E> localRoot, E item) :: Recursive delete method.

            - findLargestChild(Node<E> parent) :: Find the node that is the inorder predecessor.


BinarySearchTree ( BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> )

@author Koffman and Wolfgang

A class to represent a binary search tree.

        --Methods

            - contains(E target) :: Checks whether the target is contained in the tree.

            - find(E target) :: Starter method find.

            - find(Node<E> localRoot, E target) :: Recursive find method.

            - add(E item) :: Starter method add.

            - add(Node<E> localRoot, Node<E> parent, E item) :: Recursive add method.

            - delete(E target) :: Starter delete method.

            - delete(Node<E> localRoot, E item) :: Recursive delete method.

            - findLargestChild(Node<E> parent) :: Find the node that is the inorder predecessor and replace it with its left child (if any).


BinaryTree ( BinaryTree<E> implements Serializable )

@author Koffman and Wolfgang

Class for a binary tree that stores type E objects.

    --Methods

        - BinaryTree() :: Constructs an empty binary tree.

        - BinaryTree(Node<E> root) :: Construct a BinaryTree with a specified root. Should only be used by subclasses.

        - BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) :: Constructs a new binary tree with data in its root,leftTree as its left subtree and rightTree as its right subtree.

        - getLeftSubtree() :: Return the left subtree.

        - getRightSubtree() :: Return the right subtree.
        
        - getData() :: Return the data field of the root.

        - isLeaf() :: Determine whether this tree is a leaf.

        - toString() :: no description found

        - preOrderTraverse(Node<E> node, int depth, StringBuilder sb) :: Perform a preorder traversal.

        - readBinaryTree(BufferedReader bR) :: Method to read a binary tree.


BSTTreeVisualization ( BSTTreeVisualization<E extends Comparable<E>> extends BinarySearchTree<E> )

@author Minh Nguyen, Brayden Coronado, Devinn Chi

A class which aids in the visualizations that are represented in TreeVisualizationApp.java

        --Methods

            - BSTTreeVisualization(double width, double height) :: Creates a binary tree visualization.

            - createCoordinates() :: Creates coordinates to be used in the visualization. 


NilNode 

@author unknown

NilNode

    --Methods
        -MethodOne :: methodD
        -MethodTwo :: methodD


Node ( Node<E> implements Serializable )

@author unknown

A class which represents the parts and functions of a node

        --Methods

            - MethodNameOne :: methodDescriptionOne

            - MethodNameTwo :: methodDescriptionTwo


NodeGraphics

@author Minh Nguyen, Brayden Coronado, Devinn Chi

A class which handles the graphics of AVL and Black and Red trees including the visual shape of a node and the color (black/red)

        --Methods
            MethodNameOne :: methodDescriptionOne
            MethodNameTwo :: methodDescriptionTwo


PleasingButton

@author Minh Nguyen, Brayden Coronado, Devinn Chi

An interface to help the operations of buttons

        --Methods
            MethodNameOne :: methodDescriptionOne
            MethodNameTwo :: methodDescriptionTwo


RedAndBlackHomepageButton

@author Minh Nguyen, Brayden Coronado, Devinn Chi

This class is used to create a button which is represented as an image of a Red and Black Tree. Pressing this button leads to the input screen.

        --Methods
            MethodNameOne :: methodDescriptionOne
            MethodNameTwo :: methodDescriptionTwo


RedAndBlackTree

@author Minh Nguyen, Brayden Coronado, Devinn Chi

A class to represent a Red and Black binary search tree. Red and Black trees self-balance by following a few rules relating to color.

        --Methods
            MethodNameOne :: methodDescriptionOne
            MethodNameTwo :: methodDescriptionTwo


TreeVisualization

@author Minh Nguyen, Brayden Coronado, Devinn Chi

A class which handles visualizations for a Tree in a GUI

        --Methods
            MethodNameOne :: methodDescriptionOne
            MethodNameTwo :: methodDescriptionTwo


TreeVisualizationApp

@author Minh Nguyen, Brayden Coronado, Devinn Chi

A class which operates and creates a Graphical User Interface that has the capability of generating a Binary Search Tree visualization. This tree can either be sorted via AVL or black and red. This GUI will also print out the traversals of the created tree.

        --Methods
            MethodNameOne :: methodDescriptionOne
            MethodNameTwo :: methodDescriptionTwo