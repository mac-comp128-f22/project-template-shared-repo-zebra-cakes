import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import edu.macalester.graphics.*;

public class BSTTreeVisualization<E extends Comparable<E>>{
    public GraphicsGroup graphics;
    public BinarySearchTree<E> tree;
    public double width;
    public double height;
    public HashMap<Integer, Point> coordinate = new HashMap<>();

    /**
     * Creates a binary tree visualization
     * @param width
     * @param height
     */
    public BSTTreeVisualization(double width, double height) {
        this.tree = new BinarySearchTree();
        this.graphics = new GraphicsGroup(width, height);
        this.width = width;
        this.height = height;
        createCoordinates();
    }
    
    /**
     * Creates coordinates to be used in the visualization.
     */
    public void createCoordinates() {
        for (int i = 0; i <= 127; i++) {
            double level = Math.floor(Math.log(i + 1) / Math.log(2));
            double verticalGap = (level + 1) * this.height / 8;
            double startingNode = Math.pow(2, level) - 1;
            double numberOfNodes = Math.pow(2, level);
            double horizontalGap = (i - startingNode + 1) * (this.width / (numberOfNodes + 1));
            coordinate.put(i, new Point(horizontalGap, verticalGap));
        }
    }

    public void addGraphics(E data) {
        tree.add(data);
        graphics.removeAll();
        createGraphics(this.tree.root);
    }

    public void removeGraphics(E data) {
        tree.delete(data);
        graphics.removeAll();
        createGraphics(this.tree.root);
    }
    private void createGraphics(Node<E> root) {
        if (root != null) {
                    root.getIndex();
            if (root.left != null) {
                Line connector = new Line(coordinate.get(root.getIndex()), coordinate.get(root.left.getIndex()));
                graphics.add(connector);
            }
            if (root.right != null) {
                Line connector = new Line(coordinate.get(root.getIndex()), coordinate.get(root.right.getIndex()));
                graphics.add(connector);
            }
            graphics.add(root.graphics.nodeGraphics);
            root.graphics.nodeGraphics.setCenter(coordinate.get(root.getIndex()));
            createGraphics(root.left);
            createGraphics(root.right);
        }
    }


    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("test", 1000, 300);
        BSTTreeVisualization<Integer> test = new BSTTreeVisualization<>(canvas.getWidth(), canvas.getHeight());
        canvas.add(test.graphics, 0, 0);
        test.addGraphics(1);
        test.addGraphics(2);
        test.addGraphics(3);
        test.addGraphics(0);
        test.addGraphics(6);
        test.addGraphics(-3);
        test.addGraphics(-1);
        test.addGraphics(-4);
        test.removeGraphics(1);
        test.addGraphics(3);
        test.removeGraphics(2);
        test.addGraphics(9);
        test.addGraphics(12);
        test.addGraphics(20);
        test.addGraphics(10);
    }
}
