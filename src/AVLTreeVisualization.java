import edu.macalester.graphics.CanvasWindow;

public class AVLTreeVisualization<E extends Comparable<E>> extends BSTTreeVisualization<E> {

    public AVLTreeVisualization(double width, double height) {
        super(width, height);
        this.tree = new AVLTree<>();
    }
    
    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("test", 1000, 500);
        AVLTreeVisualization<Integer> test = new AVLTreeVisualization<>(1000, 500);
        canvas.add(test.graphics, 0, 0);
        test.addGraphics(0);
        test.addGraphics(3);
        test.addGraphics(4);
        test.addGraphics(2);
        test.addGraphics(6);
        test.addGraphics(1);
        test.addGraphics(-1);
        test.addGraphics(-2);
        test.addGraphics(0);
        test.removeGraphics(3);
        test.removeGraphics(0);
    }
}
