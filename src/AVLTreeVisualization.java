import edu.macalester.graphics.CanvasWindow;

public class AVLTreeVisualization<E extends Comparable<E>> extends BSTTreeVisualization<E> {

    public AVLTreeVisualization(double width, double height) {
        super(width, height);
        this.tree = new AVLTree<>();
    }
    
    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("test", 1000, 1000);
        AVLTreeVisualization<Integer> test = new AVLTreeVisualization<>(1000, 1000);
        canvas.add(test.graphics);
        test.addGraphics(0);
        test.addGraphics(3);
    }
}
