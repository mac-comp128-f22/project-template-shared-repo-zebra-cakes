//imports
import edu.macalester.graphics.*;
import java.awt.Color;

/**
 * A class which handles the graphics of AVL and Black and Red trees including the visual shape of a node and the color (black/red)
 */
public class NodeGraphics<E> {
    public GraphicsGroup nodeGraphics = new GraphicsGroup();
    public Ellipse nodeBoundary = new Ellipse(0, 0, 20, 20);
    public GraphicsText nodeContent = new GraphicsText();
    public Color backgroundColor;
    public Color textColor;

    /**
     * Creates the graphics for a node
     * @param data
     */
    public NodeGraphics(E data) {
        this.nodeBoundary.setFillColor(Color.WHITE);
        this.nodeBoundary.setStrokeColor(Color.BLACK);
        this.nodeGraphics.add(nodeBoundary);
        this.nodeContent.setText(data.toString());
        this.nodeContent.setCenter(10, 10);
        this.nodeContent.setFillColor(Color.BLACK);
        this.nodeGraphics.add(this.nodeContent);
    }

    /**
     * Creates the graphics for a node, with color
     * @param data
     * @param color
     */
    public NodeGraphics(E data, Color color) {
        this.backgroundColor = color;
        this.nodeGraphics.add(nodeBoundary);
        this.nodeGraphics.add(this.nodeContent);
        this.nodeContent.setText(data.toString());
        this.nodeContent.setCenter(10, 10);
        if (color == Color.BLACK) {
            setColorBlack();
        } else if (color == Color.RED) {
            setColorRed();
        }
    }

    /**
     * Sets the color of a node to black
     */
    public void setColorBlack() {
        this.backgroundColor = Color.BLACK;
        this.nodeBoundary.setFillColor(this.backgroundColor);
        this.nodeContent.setFillColor(Color.WHITE);
    }

    /**
     * Sets color of a node to red
     */
    public void setColorRed() {
        this.backgroundColor = Color.RED;
        this.nodeBoundary.setFillColor(this.backgroundColor);
        this.nodeContent.setFillColor(Color.WHITE);
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Test", 100, 100);
        NodeGraphics<Integer> test1 = new NodeGraphics<>(15);
        canvas.add(test1.nodeGraphics, 10, 10);
    }
    
}
