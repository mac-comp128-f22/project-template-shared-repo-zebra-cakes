import edu.macalester.graphics.CanvasWindow;

public class RedAndBlackTreeVisualization<E extends Comparable<E>> extends BSTTreeVisualization<E> {
    public RedAndBlackTreeVisualization(double width, double height) {
        super(width, height);
        this.tree = new RedAndBlackTree();
    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("test", 1000, 300);
        RedAndBlackTreeVisualization<Integer> test = new RedAndBlackTreeVisualization<>(canvas.getWidth(), canvas.getHeight());
        canvas.add(test.graphics, 0, 0);
        // test.addGraphics(1);
        // test.addGraphics(2);
        // test.addGraphics(3);
        // test.addGraphics(0);
        // test.addGraphics(6);
        // test.addGraphics(-3);
        // test.addGraphics(-1);
        // test.addGraphics(-4);
        // // test.removeGraphics(1);
        // // test.removeGraphics(2);
        // test.addGraphics(9);
        // test.addGraphics(12);
        // test.addGraphics(20);
        // test.addGraphics(10);
        // test.addGraphics(25);
        test.addGraphics(4);
        test.addGraphics(1);
        test.addGraphics(2);
        test.addGraphics(3);
        test.addGraphics(5);
        test.addGraphics(6);
        // test.addGraphics(7);
    }
}
