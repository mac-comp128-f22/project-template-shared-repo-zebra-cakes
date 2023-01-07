import java.awt.Color;
import java.io.Serializable;

/**
 * A class which represents the parts and functions of a node
 */
public class Node<E> implements Serializable {
    public E data;
    public Node<E> parent;
    public Node<E> left;
    public Node<E> right;
    public Color color;
    public int index;
    public NodeGraphics graphics;

    /**
     * Creates new graphics obj based on input
     */
    public Node(E data) {
        this.data = data;
        graphics = new NodeGraphics(data);
    }

    /**
     * Creates new graphics obj based on input
     * @param data
     * @param color
     */
    public Node(E data, Color color) {
        this.color = color;
        this.data = data;
        graphics = new NodeGraphics<>(data, color);
    }

    /**
     * Sets color to red
     */
    public void setRed() {
        this.color = Color.red;
        // this.graphics.setColorRed();
    }

    /**
     * Sets color to black
     */
    public void setBlack() {
        this.color = Color.black;
        // this.graphics.setColorBlack();
    }

    /**
     * Returns the index of the called object
     * @return
     */
    public int getIndex() {
        if (parent == null) {
            index = 0;
            return 0;
        } else if (parent.left == this) {
            index = 2 * parent.getIndex() + 1;
            return 2 * parent.getIndex() + 1;
        } else if (parent.right == this) {
            index = 2 * (parent.getIndex() + 1);
            return 2 * (parent.getIndex() + 1);
        } else {
            return (int) Double.NEGATIVE_INFINITY;
        }
    }

    /**
     * Updates the graphics of the node
     */
    public void updateGraphics() {
        if (this.color == null) {
            this.graphics = new NodeGraphics<E>(data);
        } else {
            this.graphics = new NodeGraphics<E>(data, color);
        }
    }

    /**
     * Converts node to string
     */
    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        sB.append('(');
        sB.append(data.toString());
        sB.append(", ");
        sB.append(color.toString());
        sB.append(")");
        return sB.toString();
    }
}