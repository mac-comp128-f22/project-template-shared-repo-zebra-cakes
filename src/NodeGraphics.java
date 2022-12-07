import edu.macalester.graphics.GraphicsObject;

import edu.macalester.graphics.*;
import java.awt.Color;

public class NodeGraphics<E> {
    public GraphicsGroup nodeGraphics = new GraphicsGroup();
    public Ellipse nodeBoundary = new Ellipse(0, 0, 30, 30);
    public GraphicsText nodeContent = new GraphicsText();
    public Color backgroundColor;
    public Color textColor;

    public NodeGraphics(E data) {
        this.nodeBoundary.setFillColor(Color.WHITE);
        this.nodeBoundary.setStrokeColor(Color.BLACK);
        this.nodeGraphics.add(nodeBoundary);
        this.nodeContent.setText(data.toString());
        this.nodeContent.setCenter(14, 14);
        this.nodeContent.setFillColor(Color.BLACK);
        this.nodeGraphics.add(this.nodeContent);
    }

    public NodeGraphics(E data, Color color) {
        this.backgroundColor = color;
        this.nodeGraphics.add(nodeBoundary);
        this.nodeGraphics.add(this.nodeContent);
        this.nodeContent.setText(data.toString());
        this.nodeContent.setCenter(14, 14);
        if (color == Color.BLACK) {
            setColorBlack();
        } else if (color == Color.RED) {
            setColorRed();
        }
    }

    public void setColorBlack() {
        this.backgroundColor = Color.BLACK;
        this.nodeBoundary.setFillColor(this.backgroundColor);
        this.nodeContent.setFillColor(Color.WHITE);
    }

    public void setColorRed() {
        this.backgroundColor = Color.RED;
        this.nodeBoundary.setFillColor(this.backgroundColor);
        this.nodeContent.setFillColor(Color.WHITE);
    }


    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Test", 100, 100);
        NodeGraphics<Integer> test1 = new NodeGraphics<>(15);
        canvas.add(test1.nodeGraphics, 10, 10);
    }
    
}
