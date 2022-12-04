import edu.macalester.graphics.GraphicsObject;

import edu.macalester.graphics.*;
import java.awt.Color;

public class NodeGraphics<E> extends Node<E> {
    public GraphicsGroup nodeGraphics = new GraphicsGroup();
    public Ellipse nodeBoundary = new Ellipse(0, 0, 30, 30);
    public GraphicsText nodeContent = new GraphicsText();
    public Color backgroundColor;
    public Color textColor;

    public NodeGraphics(E data) {
        super(data);
        this.nodeBoundary.setFillColor(Color.WHITE);
        this.nodeBoundary.setStrokeColor(Color.BLACK);
        this.nodeGraphics.add(nodeBoundary);
        this.nodeContent.setText(data.toString());
        this.nodeContent.setCenter(5, 5);
        this.nodeContent.setFillColor(Color.BLACK);
        this.nodeGraphics.add(this.nodeContent);
    }

    public NodeGraphics(E data, Color color) {
        super(data, color);
        this.nodeGraphics.add(nodeBoundary);
        this.nodeGraphics.add(this.nodeContent);
        this.nodeContent.setText(data.toString());
        this.nodeContent.setCenter(12, 12);
        if (color == Color.BLACK) {
            setColorBlack();
        } else if (color == Color.RED) {
            setColorRed();
        }
    }

    public void setColorBlack() {
        this.color = Color.BLACK;
        this.nodeBoundary.setFillColor(this.color);
        this.nodeContent.setFillColor(Color.WHITE);
    }

    public void setColorRed() {
        this.color = Color.RED;
        this.nodeBoundary.setFillColor(this.color);
        this.nodeContent.setFillColor(Color.WHITE);
    }


    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Test", 100, 100);
        NodeGraphics<Integer> test1 = new NodeGraphics<>(1, Color.RED);
        canvas.add(test1.nodeGraphics, 10, 10);
    }
    
}
