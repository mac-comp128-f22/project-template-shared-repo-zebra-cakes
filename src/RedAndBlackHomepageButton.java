

//imports
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;
import java.awt.Color;


public class RedAndBlackHomepageButton implements PleasingButton{

    //instance variables
    private final double size;
    private GraphicsGroup group;

    private Image rbIcon;
    private GraphicsText rbLabel;
    private GraphicsText rbDescription;
    public CanvasWindow canvas;
    private Line topBorder;
    private Line rightBorder;
    private Line leftBorder;
    private Line bottomBorder;
    private double leftX;
    private double topY;
    private double rightX;
    private double bottomY;

    /**
     * AVLHomepageButton class object
     * creates graphics group objects and text buttons
     * @param size
     * @param cavas
     */
    public RedAndBlackHomepageButton (double size, CanvasWindow canvas) {

        //initialize size
        this.size = size;
        this.canvas = canvas;

        //new graphics group, create new icon
        group = new GraphicsGroup();
        rbIcon = new Image(0, 0);
        rbIcon.setMaxWidth(size * .5);
        rbIcon.setMaxHeight(size * .5);
        group.add(rbIcon);

        //avl label
        rbLabel = new GraphicsText();
        rbLabel.setFont(FontStyle.PLAIN, size * 0.02);
        group.add(rbLabel);    

        //avl description
        rbDescription = new GraphicsText();
        rbDescription.setFont(FontStyle.PLAIN, size * 0.02);
        rbDescription.setCenter(size * .35, size * .8);
        canvas.add(rbDescription);

        // topBorder = new Line(size * 0.5, (size * 0) + 2.5, size, (size * 0) + 2.5);
        // rightBorder= new Line(size - 2.5, size * 0, size - 2.5, size * .5);
        // leftBorder = new Line(size * 0.5, size * 0, size * 0.5, size * .5);
        // bottomBorder= new Line(size * 0.5, size * .5, size, size * .5);\

        update();

        topBorder = new Line(leftX-5, topY-2, rightX+5, topY-2);
        rightBorder = new Line(rightX+2, topY-5, rightX+2, bottomY+5);
        leftBorder = new Line(leftX-2, topY-5, leftX-2, bottomY+5);
        bottomBorder= new Line(leftX-5, bottomY+2, rightX+5, bottomY+2);

        topBorder.setStrokeWidth(30);
        rightBorder.setStrokeWidth(30);
        leftBorder.setStrokeWidth(30);
        bottomBorder.setStrokeWidth(30);
        topBorder.setStrokeColor(Color.lightGray);
        rightBorder.setStrokeColor(Color.lightGray);
        leftBorder.setStrokeColor(Color.lightGray);
        bottomBorder.setStrokeColor(Color.lightGray);

        canvas.add(topBorder);
        canvas.add(rightBorder);
        canvas.add(leftBorder);
        canvas.add(bottomBorder);
    }

    /**
     * return the graphics group
     */
    @Override
    public GraphicsObject getButtonGraphics() {
        return group;
    }

    /**
     * updates the avl label
     */
    @Override
    public void update() {
        rbIcon.setImagePath("images/redAndBlackPicture.png");
        rbLabel.setText("Red and Black Tree");
        rbDescription.setText("");
        updateLayout();

    }

    /**
     * updates layout of avlicon and avllabel
     */
    public void updateLayout() {
        rbIcon.setCenter(size * .75, size *.25);
        rbLabel.setCenter(size * .75, size * .5);
        leftX = rbIcon.getX();
        topY = rbIcon.getY();
        rightX = rbIcon.getX() + rbIcon.getWidth();
        bottomY = rbIcon.getY() + rbIcon.getHeight();
    }

    /**
     * get size
     */
    public double getSize() {
        return this.size;
    }

    /**
     * 
     */
    @Override
    public void onHover(Point position) {
        if (rbIcon.isInBounds(position)) {
            rbDescription.setText("Information about the avl structure");
            topBorder.setStrokeWidth(5);
            rightBorder.setStrokeWidth(5);
            leftBorder.setStrokeWidth(5);
            bottomBorder.setStrokeWidth(5);
            topBorder.setStrokeColor(Color.black);
            rightBorder.setStrokeColor(Color.black);
            leftBorder.setStrokeColor(Color.black);
            bottomBorder.setStrokeColor(Color.black);

        } else {
            rbDescription.setText("");
            topBorder.setStrokeWidth(0);
            rightBorder.setStrokeWidth(0);
            leftBorder.setStrokeWidth(0);
            bottomBorder.setStrokeWidth(0);
            topBorder.setStrokeColor(Color.lightGray);
            rightBorder.setStrokeColor(Color.lightGray);
            leftBorder.setStrokeColor(Color.lightGray);
            bottomBorder.setStrokeColor(Color.lightGray);
        }
        
    }

    public void onClick(Point position, TextField textField, Button button, Button doneButton, Button removeButton) {
        if (rbIcon.isInBounds(position)) {
            canvas.removeAll();
            canvas.add(textField);
            canvas.add(button);
            canvas.add(doneButton);
            canvas.add(removeButton);
        }
    }

}
