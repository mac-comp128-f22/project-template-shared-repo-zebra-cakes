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

7. VOILA! On the next screen you will see your inputs being added to the binary search tree which will be sorted by the method you chose in the first step. If you are DONE adding / removing inputs from your tree, you can press the traversals button which will lock you out of adding or removing, and will display your traversals on screen.


# Steps to test our project
1. Most of our testing was done via visual testing, in line with AVL tree test where we tried removing a node to see if the tree aligns with what we were thinking. The visual test was done by inserting random numbers into tree visualization app, and checking to see if the tree behaves as expected. The tests for each of the visualization are commented out in the main method

2. For our AVL tree, we tested by removing a node with left child, right child, 2 childs and no child at all. By doing that, we were able to find a bug in the AVL tree class, where the original author was using in order successor and in order predecessor at the same time, which led to a buggy tree

3. For our red and black tree, we tested the tree by inserting nodes in different cases (i.e. left child or right child, grandparent color is black, etc.) and observe its behavior 


# Future implementations
1. We were unable to get the deletion for the Red and Black Tree to work, however, our attempt is shown in the code file. The remove button was deleted from the Red and Black tree interface due to this problem.

2. We were unable to animate the insertions and deletions in our tree graphics. Given more time, we would have made it so that the nodes would move to more clearly show the rotations resulting from adding and removing. 

3. 


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


AvlTreeVisualization ( AVLTreeVisualization<E extends Comparable<E>> extends BSTTreeVisualization<E> )

@author Minh Nguyen, Brayden Coronado, Devinn Chi

Class that handles visualizations with the AVL Tree automatic Rotations. Extends BSTTReeVisualization.

    --Methods

        - AVLTreeVisualization(double width, double height) :: Declaration for AVLTree, which is a child of BSTTreeVisualization


BinarySearchTree ( BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> )

@author Koffman and Wolfgang

A class to represent a binary search tree.

        --Methods

            - contains(E target) :: Checks whether the target is contained in the tree.

            - find(E target) :: Starter method find

            - find(Node<E> localRoot, E target) :: Recursive find method

            - add(E item) :: Starter method add

            - add(Node<E> localRoot, Node<E> parent, E item) :: Recursive add method

            - delete(E target) :: Starter delete method

            - delete(Node<E> localRoot, E item) :: Recursive delete method

            - findLargestChild(Node<E> parent) :: Find the node that is the inorder predecessor and replace it with its left child (if any)

            - inOrderTraversal() :: returns a string of the in-order traversal

            - inOrderTraversal(Node<E> localRoot, ArrayList<E>order) :: helper method in order to create the in-order traversal

            - preOrderTraversal() :: returns a string of the pre-order traversal

            - preOrderTraversal(Node<E> localRoot, ArrayList<E>order) :: helper method in order to create the pre-order traversal

            - postOrderTraversal() :: returns a string of the post-order traversal

            - postOrderTraversal(Node<E> localRoot, ArrayList<E>order) :: helper method in order to create the post-order traversal


BinaryTree ( BinaryTree<E> implements Serializable )

@author Koffman and Wolfgang

Class for a binary tree that stores type E objects.

    --Methods

        - BinaryTree() :: Constructs an empty binary tree

        - BinaryTree(Node<E> root) :: Construct a BinaryTree with a specified root. Should only be used by subclasses

        - BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) :: Constructs a new binary tree with data in its root,leftTree as its left subtree and rightTree as its right subtree

        - getLeftSubtree() :: Return the left subtree

        - getRightSubtree() :: Return the right subtree
        
        - getData() :: Return the data field of the root

        - isLeaf() :: Determine whether this tree is a leaf

        - toString() :: no description found

        - preOrderTraverse(Node<E> node, int depth, StringBuilder sb) :: Perform a preorder traversal

        - readBinaryTree(BufferedReader bR) :: Method to read a binary tree


BSTTreeVisualization ( BSTTreeVisualization<E extends Comparable<E>> extends BinarySearchTree<E> )

@author Minh Nguyen, Brayden Coronado, Devinn Chi

A class which aids in the visualizations that are represented in TreeVisualizationApp.java

        --Methods

            - BSTTreeVisualization(double width, double height) :: Creates a binary tree visualization.

            - createCoordinates() :: Creates coordinates to be used in the visualization

            - addGraphics(E data) :: adds graphics based on data input

            - createGraphics(Node<E> root) :: Creates graphics


Node ( Node<E> implements Serializable )

@author unknown

A class which represents the parts and functions of a node

        --Methods

            - Node(E data) :: Creates new graphics obj based on input

            - Node(E data, Color color) :: Creates new graphics obj based on input

            - setRed() :: Sets color to red

            - setBlack() :: Sets color to black

            - getIndex() :: Returns the index of the called object

            - toString() :: Converts node to string

            - updateGraphics() :: Updates the graphics of the node


NodeGraphics ( NodeGraphics<E> )

@author Minh Nguyen, Brayden Coronado, Devinn Chi

A class which handles the graphics of AVL and Black and Red trees including the visual shape of a node and the color (black/red)

        --Methods

            - NodeGraphics(E data) :: Creates the graphics for a node

            - NodeGraphics(E data, Color color) :: Creates the graphics for a node, with color

            - setColorBlack() :: Sets the color of a node to black

            - setColorRed() :: Sets color of a node to red


PleasingButton ( interface )

@author Minh Nguyen, Brayden Coronado, Devinn Chi

An interface to help the operations of buttons

        --Methods

            - getButtonGraphics() :: This shows what the graphics of the button look like

            - update() :: This will show the proper image, label and description for the button

            - onHover(Point position) :: This is called when the mouse is on top of the button


RedAndBlackHomepageButton ( implements interface PleasingButton )

@author Minh Nguyen, Brayden Coronado, Devinn Chi

This class is used to create a button which is represented as an image of a Red and Black Tree. Pressing this button leads to the input screen.

        --Methods
            
            - RedAndBlackHomepageButton(double size, CanvasWindow canvas) :: RedAndBlackHomepageButton class object creates graphics group objects and text buttons

            - getButtonGraphics() :: Returns the graphics group which the Red and Black home button page is on.

            - update() :: Updates the Red and Black label

            - updateLayout() :: Updates layout of avlicon and avllabel. Initializes variables which are used to create borders.

            - getSize() :: Returns the value of the size variable

            - onHover(Point position) :: Runs the visual on hover effect. Borders around the image button appear.

            - onClick(Point position, TextField textField, Button button, Button doneButton, Button removeButton, Button backButton) :: Upon clicking the Red and Black label button, this function will clear the canvas and add the input box screen.


RedAndBlackTree ( RedAndBlackTree<E extends Comparable<E>> extends BinarySearchTree<E> )

@author Minh Nguyen, Brayden Coronado, Devinn Chi

A class to represent a Red and Black binary search tree. Red and Black trees self-balance by following a few rules relating to color.

        --Methods

            - adjustBasedOnBlack(RedAndBlackNode<E> node, RedAndBlackNode<E> siblingNode) :: Asjusts the node based on its sibling

            - adjustBasedOnRed(RedAndBlackNode<E> node, RedAndBlackNode<E> siblingNode) :: Method to adjust node based on its sibling

            - getSibling(RedAndBlackNode<E> searchNode) :: Returns the sibling of a node

            - readjustColor(RedAndBlackNode<E> nodeToReadjust) :: Gets the color of a node

            - findMinimum(RedAndBlackNode<E> nodeToSearch) :: Finds the minimum node 

            - deleteNodeWithOneOrNoChild(RedAndBlackNode<E> nodeToDelete) :: Deletes the node if one or no child

            - deleteNode(E key) :: Deletes the node

            - rotations(RedAndBlackNode<E> insertedNode) :: handles rotations for nodes
            
            - getUncle(RedAndBlackNode<E> parentNode) :: Gets the uncle node of the parent

            - insert(RedAndBlackNode<E> parentNode, E key) :: Handles the insertion of a node

            - addNode(E key) :: adds node

            - searchForNode(E key) :: Searches for input node based on key

            - replaceParentsChild(RedAndBlackNode<E> parentNode, RedAndBlackNode<E> oldChildNode, RedAndBlackNode<E> newChildNode) :: replaces the child of the parent inputted

            - rotateLeft(RedAndBlackNode<E> pivot) :: Left rotation of x around the pivot node

            - rotateRight(RedAndBlackNode<E> pivot) :: Right rotation of x around the pivot node


TreeVisualizationApp

@author Minh Nguyen, Brayden Coronado, Devinn Chi

A class which operates and creates a Graphical User Interface that has the capability of generating a Binary Search Tree visualization. This tree can either be sorted via AVL or black and red. This GUI will also print out the traversals of the created tree.

        --Methods

            - TreeVisualizationApp() :: Class level object

            - treeAppRunner(TreeVisualizationApp newApp) :: Method which will create a canvas, and implement a user interface which will allow a user to see implmentations for AVL and Black and Red trees.

            - traversals() :: Prints out the traversals for the tree; prints inorder, postorder, and preorder traversals

            - avlrbSetter(int n) :: setter method for avlOrRb

            - backMethod(TreeVisualizationApp newApp) :: Method to return to the home page from the second page

            - removeButtonRunner() :: Removes the most recently added value from the input treeArray

            - treeArrayButtonRunner() :: Run the button for the treeArrayButton add the integer from the treeArray to an array
            
            - totalOnHover(Point position) :: runs methods for onHover upon home screen

            - totalOnClick(Point position) :: Creates the second screen