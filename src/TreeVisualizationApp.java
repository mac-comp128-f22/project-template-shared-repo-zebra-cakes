

import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;
import edu.macalester.graphics.Point;


public class TreeVisualizationApp {
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static GraphicsText errorText = new GraphicsText("You may not have entered an Integer value. Please try again.");
    private static ArrayList<Integer> arrTree;
    private static TextField treeArray;
    private static CanvasWindow canvas;
    private static AVLHomepageButton avlButton;
    private static Button treeArrayButton;
    private static RedAndBlackHomepageButton rbButton;
    

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

        //add the text input box
        treeArray = new TextField();
        treeArray.setCenter(avlButton.getSize()*0.5, avlButton.getSize()*0.6);

        //add the text input button
        treeArrayButton = new Button("Add to Tree");
        treeArrayButton.setCenter(avlButton.getSize()*0.7, avlButton.getSize()*0.6);
        treeArrayButton.onClick(() -> treeArrayButtonRunner());

        canvas.add(avlButton.getButtonGraphics());
        canvas.add(rbButton.getButtonGraphics());

        canvas.onMouseMove(event -> totalOnHover(event.getPosition()));
        canvas.onClick(event -> totalOnClick(event.getPosition()));

    }

    /**
     * run the button for the treeArrayButton
     * add the integer from the treeArray to an array
     * @return
     */
    private static void treeArrayButtonRunner() {
        //error text create
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

        if (woah == true) {
            errorText.setText("");
            Integer getNodeInt = Integer.valueOf(getNode);
            arrTree.add(getNodeInt);
            System.out.println(arrTree);   
            treeArray.setText("");
        }
    }

    /**
     * 
     * @param position
     * @param avlButton
     */
    public static void totalOnHover(Point position) {
        avlButton.onHover(position);
        rbButton.onHover(position);
    }

    public static void totalOnClick(Point position) {
        avlButton.onClick(position, treeArray, treeArrayButton);
        rbButton.onClick(position, treeArray, treeArrayButton);
    }
}


