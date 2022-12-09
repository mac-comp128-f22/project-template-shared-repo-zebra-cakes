import edu.macalester.graphics.CanvasWindow;

public class AVLTreeVisualization<E extends Comparable<E>> extends BSTTreeVisualization<E> {

    /**
     * Declaration for AVLTree, which is a child of BSTTreeVisualization
     * @param width
     * @param height
     */
    public AVLTreeVisualization(double width, double height) {
        super(width, height);
        this.tree = new AVLTree<>();
    }

    
    /**
     * Main method
     * @param args
     */
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
        // test.removeGraphics(3);
        // test.removeGraphics(0);
        
        test.addGraphics(37);
        test.addGraphics(44);
        test.addGraphics(25);
        test.addGraphics(63);
        test.addGraphics(15);
        test.addGraphics(-16);
        test.addGraphics(-24);
        test.addGraphics(025);

        
        test.addGraphics(37);
        test.addGraphics(45);
        test.addGraphics(267);
        test.addGraphics(68);
        test.addGraphics(19);
        test.addGraphics(-16);
        test.addGraphics(-24);
        test.addGraphics(0245);

        
        test.addGraphics(376);
        test.addGraphics(445);
        test.addGraphics(273);
        test.addGraphics(638);
    }
}
