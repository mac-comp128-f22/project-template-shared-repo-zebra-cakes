import java.awt.Color;
import java.io.Serializable;

public class Node<E> implements Serializable {
    public E data;
    public Node<E> parent;
    public Node<E> left;
    public Node<E> right;
    public Color color;

    public Node(E data) {
        this.data = data;
    }

    public Node(E data, Color color) {
        this.color = color;
        this.data = data;
    }

    public void setRed() {
        this.color = Color.red;
    }

    public void setBlack() {
        this.color = Color.black;
    }

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