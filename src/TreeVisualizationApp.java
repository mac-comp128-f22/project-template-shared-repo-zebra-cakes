

import edu.macalester.graphics.CanvasWindow;

public class TreeVisualizationApp {
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 1000;

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
        
    }

    
}


