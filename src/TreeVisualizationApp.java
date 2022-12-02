

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;


public class TreeVisualizationApp {
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 1000;
    private static GraphicsGroup avlGroup;

    public TreeVisualizationApp() {
    }

    public static void main(String[] args) {
        TreeVisualizationApp newApp = new TreeVisualizationApp();
        avlGroup = new GraphicsGroup();
        treeAppRunner(newApp);
    }

    /**
     * Method which will create a canvas, and implement a user interface 
     * which will allow a user to see implmentations for AVL and Black and Red trees.
     * @param newApp
     */
    public static void treeAppRunner(TreeVisualizationApp newApp) {
        CanvasWindow canvas = new CanvasWindow("Tree Visualization App", CANVAS_WIDTH, CANVAS_HEIGHT);

        Image avlImage = new Image("images/avlImage .png");
        avlImage.setScale(CANVAS_WIDTH * .0020, CANVAS_HEIGHT * .0020);
        avlImage.setCenter(CANVAS_WIDTH * .25, CANVAS_HEIGHT * .25);

        canvas.add(avlImage);
    }

    // public void onHover(Point position) {
    //     GraphicsObject object = avlGroup.getElementAt(position);
    //     if ()
    // }


}


