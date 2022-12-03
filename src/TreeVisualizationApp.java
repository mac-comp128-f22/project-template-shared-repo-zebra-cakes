

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;


public class TreeVisualizationApp {
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static AVLHomepageButton avlButton;

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
        CanvasWindow canvas = new CanvasWindow("Tree Visualization App", CANVAS_WIDTH, CANVAS_HEIGHT);
        AVLHomepageButton avlButton = new AVLHomepageButton(CANVAS_HEIGHT, canvas);

        canvas.add(avlButton.getButtonGraphics());

        canvas.onMouseMove(event -> totalOnHover(event.getPosition()));

    }

    public static void totalOnHover(Point position) {
        avlButton.onHover(position);
    }


}


