

import edu.macalester.graphics.CanvasWindow;

public class TreeVisualizationApp {
    private final CanvasWindow canvas;
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 1000;

    public TreeVisualizationApp(int width, int height) {
        canvas = new CanvasWindow("Tree Visualization App", width, height);
    }

    public static void main(String[] args) {
        TreeVisualizationApp treeApp = new TreeVisualizationApp(CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    
}


