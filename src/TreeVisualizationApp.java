//imports
import java.util.ArrayList;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;
import edu.macalester.graphics.Point;
import java.awt.Color;

/**
 * A class which operates and creates a Graphical User Interface 
 * that has the capability of generating a Binary Search Tree visualization. 
 * This tree can either be sorted via AVL or black and red. This GUI will 
 * also print out the traversals of the created tree.
 */
public class TreeVisualizationApp {

    //instance variables
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static GraphicsText errorText = new GraphicsText("You may not have entered an Integer value. Please try again.");
    private static ArrayList<Integer> arrTree;
    private static TextField treeArray;
    private static CanvasWindow canvas;
    private static AVLHomepageButton avlButton;
    private static Button treeArrayButton;
    private static RedAndBlackHomepageButton rbButton;
    private static int treeSize;
    private static Button removeButton;
    private static Button backButton;
    private static GraphicsText infoText;
    private static AVLTreeVisualization<Integer> avlTree;
    private static RedAndBlackTreeVisualization<Integer> rbTree;
    private static Button traverseButton;
    private static Boolean avlOrRb;
    private static Boolean traversalsRan;
    private static GraphicsText inOrder;
    private static GraphicsText preOrder;
    private static GraphicsText postOrder;

    /**
     * Class level object
     */
    public TreeVisualizationApp() {
    }

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        TreeVisualizationApp newApp = new TreeVisualizationApp();
        canvas = new CanvasWindow("Tree Visualization App", CANVAS_WIDTH, CANVAS_HEIGHT);
        treeAppRunner(newApp);
    }

    /**
     * Method which will create a canvas, and implement a user interface 
     * which will allow a user to see implmentations for AVL and Black and Red trees.
     * @param newApp
     */
    public static void treeAppRunner(TreeVisualizationApp newApp) {
        //initialize variables in case of recalling
        avlOrRb = null;
        treeSize = 0;
        traversalsRan = null;
        //initialize first homescreen and picture buttons
        avlButton = new AVLHomepageButton(CANVAS_WIDTH, canvas);
        rbButton = new RedAndBlackHomepageButton(CANVAS_WIDTH, canvas);

        //initialize the traversals
        postOrder = new GraphicsText();
        postOrder.setCenter(avlButton.getSize()*0.02, avlButton.getSize()*0.66);
        preOrder = new GraphicsText();
        preOrder.setCenter(avlButton.getSize()*0.02, avlButton.getSize()*0.69);
        inOrder = new GraphicsText();
        inOrder.setCenter(avlButton.getSize()*0.02, avlButton.getSize()*0.72);

        //initialize array to store input values
        arrTree = new ArrayList<>();

        //error text set position
        errorText.setCenter(avlButton.getSize()*0.3, avlButton.getSize()*0.9);
        errorText.setText("");
        canvas.add(errorText);

        //add info text
        infoText = new GraphicsText();
        infoText.setText("Click the add button to add a value to the tree.");
        infoText.setCenter(avlButton.getSize()*0.5, avlButton.getSize()*0.75);

        //add the text input box
        treeArray = new TextField();
        treeArray.setCenter(avlButton.getSize()*0.5, avlButton.getSize()*0.8);

        //add the text input button
        treeArrayButton = new Button("Add to Tree (no duplicate values)");
        treeArrayButton.setCenter(avlButton.getSize()*0.7, avlButton.getSize()*0.8);
        treeArrayButton.onClick(() -> treeArrayButtonRunner());

        //add the remove button
        removeButton = new Button("Remove last input");
        removeButton.setCenter(avlButton.getSize()*0.7, avlButton.getSize()*0.85);
        removeButton.onClick(() -> removeButtonRunner());

        //add the back button
        backButton = new Button("Back to Home");
        backButton.setCenter(avlButton.getSize()*0.7, avlButton.getSize()*0.9);
        backButton.onClick(() -> backMethod(newApp));

        //traverse button
        traverseButton = new Button("View Traversals");
        traverseButton.setCenter(avlButton.getSize()*0.7, avlButton.getSize()*0.95);
        traverseButton.onClick(() -> traversals());

        //avlTree visualization handling
        avlTree = new AVLTreeVisualization<>(CANVAS_WIDTH,CANVAS_HEIGHT*0.7);

        //rbTree visualization handling
        rbTree = new RedAndBlackTreeVisualization<>(CANVAS_WIDTH,CANVAS_HEIGHT*0.7);

        //add button graphics and set background color
        canvas.add(avlButton.getButtonGraphics());
        canvas.add(rbButton.getButtonGraphics());
        canvas.setBackground(Color.lightGray);

        //create event handlers
        canvas.onMouseMove(event -> totalOnHover(event.getPosition()));
        canvas.onClick(event -> totalOnClick(event.getPosition()));
    }

    /**
     * Prints out the traversals for the tree
     * prints inorder, postorder, and preorder
     * @return
     */
    private static void traversals() {

        //set error text to ""
        //add error text
        errorText.setText("");
        canvas.add(errorText);

        //if no traversals have been ran
        if (traversalsRan == null) {

            //if the array for the traversals is not empty
            if (!arrTree.isEmpty()) {

                //if red and black tree
                if (!avlOrRb) {

                    //run operations for red and black tree
                    //add the traversals to canvas
                    //set traversals ran to true
                    postOrder.setText("Post-Order: " + rbTree.tree.postOrderTraversal());
                    preOrder.setText("Pre-Order: " + rbTree.tree.preOrderTraversal());
                    inOrder.setText("In-Order: " + rbTree.tree.inOrderTraversal());
                    canvas.add(postOrder);
                    canvas.add(preOrder);
                    canvas.add(inOrder);
                    traversalsRan = true;

                //else its avl tree
                } else {

                    //run operations for AVL Tree
                    //add traversals to canvas
                    //set traversals ran to true
                    postOrder.setText("Post-Order: " + avlTree.tree.postOrderTraversal());
                    preOrder.setText("Pre-Order: " + avlTree.tree.preOrderTraversal());
                    inOrder.setText("In-Order: " + avlTree.tree.inOrderTraversal());
                    canvas.add(postOrder);
                    canvas.add(preOrder);
                    canvas.add(inOrder);
                    traversalsRan = true;
                }

            //if the array of traversals is empty
            } else {

                //set and display new error text
                errorText.setText("There are no values to traverse.");
                canvas.add(errorText);
            }

        //if the traversals button has already been pushed once
        } else {

            //set and display new error text
            errorText.setText("The values have already been traversed.");
            canvas.add(errorText);
        }
    }

    /**
     * setter method for avlOrRb
     * @param newApp
     */
    public static void avlrbSetter(int n) {

        //if statement sets boolean to true or false based on user input
        //will determine wether or not to run AVL or RB balancing
        if (n == 0) {
            avlOrRb = true;
        } else {
            avlOrRb = false;
        }
    }

    /**
     * method to return to the home page from the second page
     * @param newApp
     */
    private static void backMethod(TreeVisualizationApp newApp) {

        //clears canvas
        canvas.removeAll();

        //re-runs the main app running method
        treeAppRunner(newApp);
    }

    /**
     * removes the most recently added value from the input treeArray
     * @return
     */
    private static void removeButtonRunner() {

        //sets error text to ""
        errorText.setText("");

        //if the array of inputs is not empty...
        if (!arrTree.isEmpty()) {
            if (traversalsRan == null) {

                //if avl...
                if (avlOrRb == true) {

                    //remove the most recent value which was added to the array
                    //amount of values is decremented
                    //print out array ( for testing purposes )
                    avlTree.removeGraphics(arrTree.get(arrTree.size()-1));
                    arrTree.remove(arrTree.get(arrTree.size()-1));
                    treeSize--;
                    System.out.println(arrTree);

                //else (red and black)
                } else {

                    //remove the most recent value which was added to the array
                    //amount of values is decremented
                    //print out array ( for testing purposes )
                    rbTree.removeGraphics(arrTree.get(arrTree.size()-1));
                    arrTree.remove(arrTree.get(arrTree.size()-1));
                    treeSize--;
                    System.out.println(arrTree);
                }
            
            //traversals have been run
            } else {

                //lock out of adding due to traversals having been run
                errorText.setText("Traversals have been run. Restart to continue.");
                canvas.add(errorText);
            }

        //else if array of inputs is empty...
        } else {

            //set and display new error text 
            errorText.setText("There are no values to remove.");
            canvas.add(errorText);
        }
    }

    /**
     * run the button for the treeArrayButton
     * add the integer from the treeArray to an array
     * @return
     */
    private static void treeArrayButtonRunner() {

        //boolean to avoid running if statement
        Boolean errorBoolean = true;

        //get text inside of treeArray and convert it to an integer
        String getNode = treeArray.getText();
        
        //cases for the input box 
        // 1. If the value cannot be converted to Int
        // 2. If the value is null
        try {
            Integer.parseInt(getNode);
        } catch (NumberFormatException e) {

            //sets new error text
            //sets errorBoolean to false
            errorText.setText("You may not have entered an Integer value. Please try again.");
            canvas.add(errorText);
            errorBoolean = false;
        } catch (NullPointerException e) {

            //sets new error text
            //sets errorBoolean to false
            errorText.setText("You may not have entered an Integer value. Please try again.");
            canvas.add(errorText);
            errorBoolean = false;
        } 

        //if traversals have not been run...
        if (traversalsRan == null) {

            //if array of inputs is full...
            if (treeSize >= 31) {

                //display error text for maximum values
                errorText.setText("You have reached the maximum number of values. Press the done button to vizualize your tree.");
                canvas.add(errorText);
    
            //else if array can store another value...
            } else {
    
                //if there was no error earlier in the method
                if (errorBoolean == true) {
    
                    //get the value of the input box
                    Integer getNodeInt = Integer.valueOf(getNode);
    
                    //if the gotten value is a duplicate...
                    if (arrTree.contains(getNodeInt)) {
    
                        //display error text
                        errorText.setText("You have entered a duplicate value. Please try again.");
                        canvas.add(errorText);
    
                    //if the gotten value is not a duplicate...
                    } else {

                        //if avl tree...
                        if (avlOrRb == true) {

                            //clear error text
                            //add value to the input array
                            //print out array for testing
                            //clear the input box
                            //increment the size of the tree
                            errorText.setText("");
                            arrTree.add(getNodeInt);
                            avlTree.addGraphics(getNodeInt);
                            System.out.println(arrTree);   
                            treeArray.setText("");
                            treeSize++;

                        //else (red and black tree)
                        } else {

                            //clear error text
                            //add value to the input array
                            //print out array for testing
                            //clear the input box
                            //increment the size of the tree
                            errorText.setText("");
                            arrTree.add(getNodeInt);
                            rbTree.addGraphics(getNodeInt);
                            System.out.println(arrTree);   
                            treeArray.setText("");
                            treeSize++;
                        }
                    }
                }
            }
           
        //if traversals have been run, lock out of adding    
        } else {

            //error
            errorText.setText("Traversals have been run. Restart to continue.");
            canvas.add(errorText);
        }
    }

    /**
     * runs methods for onHover upon home screen
     * @param position
     */
    public static void totalOnHover(Point position) {

        //runs on hover methods
        avlButton.onHover(position);
        rbButton.onHover(position);
    }

    /**
     * creates the second screen
     * @param position
     */
    public static void totalOnClick(Point position) {

        //runs methods to clear canvas and add new items to screen
        avlButton.onClick(position, treeArray, treeArrayButton, removeButton, backButton, infoText, avlTree, traverseButton);
        rbButton.onClick(position, treeArray, treeArrayButton, removeButton, backButton, infoText, rbTree, traverseButton);
    }
}


