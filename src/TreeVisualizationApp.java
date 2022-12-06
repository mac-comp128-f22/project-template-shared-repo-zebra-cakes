

import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;
import edu.macalester.graphics.Point;
import java.awt.Color;

public class TreeVisualizationApp {
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static GraphicsText errorText = new GraphicsText("You may not have entered an Integer value. Please try again.");
    private static ArrayList<Integer> arrTree;
    private static TextField treeArray;
    private static CanvasWindow canvas;
    private static AVLHomepageButton avlButton;
    private static Button treeArrayButton;
    private static Button doneButton;
    private static RedAndBlackHomepageButton rbButton;
    private static int treeSize;
    private static Button removeButton;
    
    public TreeVisualizationApp() {
    }

    public static void main(String[] args) {
        TreeVisualizationApp newApp = new TreeVisualizationApp();
        treeAppRunner(newApp);
    }

    /**
     * Method which will create a canvas, and implement a user interface 
     * which will allow a user to see implmentations for AVL and Black and Red trees.
     * @param newApp
     */
    public static void treeAppRunner(TreeVisualizationApp newApp) {
        canvas = new CanvasWindow("Tree Visualization App", CANVAS_WIDTH, CANVAS_HEIGHT);
        avlButton = new AVLHomepageButton(CANVAS_WIDTH, canvas);
        rbButton = new RedAndBlackHomepageButton(CANVAS_WIDTH, canvas);

        arrTree = new ArrayList<>();

        //error text set position
        errorText.setCenter(avlButton.getSize()*0.5, avlButton.getSize()*0.7);
        errorText.setText("");
        canvas.add(errorText);

        //add the text input box
        treeArray = new TextField();
        treeArray.setCenter(avlButton.getSize()*0.5, avlButton.getSize()*0.6);

        //add the text input button
        treeArrayButton = new Button("Add to Tree (no duplicate values)");
        treeArrayButton.setCenter(avlButton.getSize()*0.7, avlButton.getSize()*0.6);
        treeArrayButton.onClick(() -> treeArrayButtonRunner());

        //add the done button
        doneButton = new Button("Done (maximum 31 value)");
        doneButton.setCenter(avlButton.getSize()*0.7, avlButton.getSize()*0.65);
        doneButton.onClick(() -> inputComplete());

        //add the remove button
        removeButton = new Button("Remove last input");
        removeButton.setCenter(avlButton.getSize()*0.7, avlButton.getSize()*0.7);
        removeButton.onClick(() -> removeButtonRunner());

        canvas.add(avlButton.getButtonGraphics());
        canvas.add(rbButton.getButtonGraphics());
        canvas.setBackground(Color.lightGray);

        canvas.onMouseMove(event -> totalOnHover(event.getPosition()));
        canvas.onClick(event -> totalOnClick(event.getPosition()));

    }

    /**
     * removes the most recently added value from the input treeArray
     * @return
     */
    private static void removeButtonRunner() {
        errorText.setText("");
        if (!arrTree.isEmpty()) {
            arrTree.remove(arrTree.get(arrTree.size()-1));
            treeSize--;
            System.out.println(arrTree);
        } else {
            errorText.setText("There are no values to remove.");
            canvas.add(errorText);
        }
        
    }

    /**
     * indicates that the user is done adding values to their tree
     * starts the visualization process
     */
    private static void inputComplete() {
        System.out.println("To be completed when Binary Tree functions are complete");
    }

    /**
     * run the button for the treeArrayButton
     * add the integer from the treeArray to an array
     * @return
     */
    private static void treeArrayButtonRunner() {
        //boolean to avoid running if statement
        Boolean woah = true;

        //get text inside of treeArray and convert it to an integer
        String getNode = treeArray.getText();
        
        try {
            Integer.parseInt(getNode);
        } catch (NumberFormatException e) {
            errorText.setText("You may not have entered an Integer value. Please try again.");
            canvas.add(errorText);
            woah = false;
        } catch (NullPointerException e) {
            errorText.setText("You may not have entered an Integer value. Please try again.");
            canvas.add(errorText);
            woah = false;
        } 

        if (treeSize >= 31) {
            errorText.setText("You have reached the maximum number of values. Press the done button to vizualize your tree.");
            canvas.add(errorText);
        } else {
            if (woah == true) {
                Integer getNodeInt = Integer.valueOf(getNode);
                if (arrTree.contains(getNodeInt)) {
                    errorText.setText("You have entered a duplicate value. Please try again.");
                    canvas.add(errorText);
                } else {
                    errorText.setText("");
                    arrTree.add(getNodeInt);
                    System.out.println(arrTree);   
                    treeArray.setText("");
                    treeSize++;
                }
            }
        }
    }

    /**
     * 
     * @param position
     */
    public static void totalOnHover(Point position) {
        avlButton.onHover(position);
        rbButton.onHover(position);
    }

    public static void totalOnClick(Point position) {
        avlButton.onClick(position, treeArray, treeArrayButton, doneButton, removeButton);
        rbButton.onClick(position, treeArray, treeArrayButton, doneButton, removeButton);
    }
}


