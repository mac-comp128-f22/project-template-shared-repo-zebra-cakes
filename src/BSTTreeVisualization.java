import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import edu.macalester.graphics.*;

public class BSTTreeVisualization<E extends Comparable<E>> extends BinarySearchTree<E> {
    public GraphicsGroup BSTGraphics;
    public double width;
    public double height;
    public HashMap<Integer, Point> coordinate = new HashMap<>();

    /**
     * Creates a binary tree visualization
     * @param width
     * @param height
     */
    public BSTTreeVisualization(double width, double height) {
        super();
        this.BSTGraphics = new GraphicsGroup(width, height);
        this.width = width;
        this.height = height;
        createCoordinates();
    }
    
    /**
     * Creates coordinates to be used in the visualization.
     */
    public void createCoordinates() {
        for (int i = 0; i <= 31; i++) {
            double level = Math.floor(Math.log(i + 1) / Math.log(2));
            double verticalGap = (level + 1) * this.height / 6;
            double startingNode = Math.pow(2, level) - 1;
            double numberOfNodes = Math.pow(2, level);
            double horizontalGap = (i - startingNode + 1) * (this.width / (numberOfNodes + 1));
            coordinate.put(i, new Point(horizontalGap, verticalGap));
        }
    }

    public void addGraphics(E data) {
        add(data);
        BSTGraphics.removeAll();
        createGraphics(this.root);
    }

    private void createGraphics(Node<E> root) {
        if (root != null) {
            if (root.left != null) {
                Line connector = new Line(coordinate.get(root.getIndex()), coordinate.get(root.left.getIndex()));
                BSTGraphics.add(connector);
            }
            if (root.right != null) {
                Line connector = new Line(coordinate.get(root.getIndex()), coordinate.get(root.right.getIndex()));
                BSTGraphics.add(connector);
            }
            BSTGraphics.add(root.graphics.nodeGraphics);
            root.graphics.nodeGraphics.setCenter(coordinate.get(root.getIndex()));
            createGraphics(root.left);
            createGraphics(root.right);
        }
    }


    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("test", 400, 200);
        BSTTreeVisualization<Integer> test = new BSTTreeVisualization<>(canvas.getWidth(), canvas.getHeight());
        canvas.add(test.BSTGraphics, 0, 0);
        test.addGraphics(1);
        test.addGraphics(2);
        test.addGraphics(3);
        test.addGraphics(0);
        test.addGraphics(6);
        test.addGraphics(-3);
        test.addGraphics(-1);
        test.addGraphics(-4);
    }
}
