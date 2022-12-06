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

    public BSTTreeVisualization(double width, double height) {
        super();
        this.width = width;
        this.height = height;
        createCoordinates();
    }
    
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
    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("test", 400, 200);
        BSTTreeVisualization<Integer> test = new BSTTreeVisualization<>(canvas.getWidth(), canvas.getHeight());
        test.coordinate.forEach((k, v) -> canvas.add(new Ellipse(v.getX(), v.getY(), 1, 1)));      
    }
}
