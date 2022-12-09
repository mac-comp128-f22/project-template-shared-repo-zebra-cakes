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

/**
 * This class is used to create a button which is represented as an image of a Red and Black Tree. Pressing this button leads to the input screen.
 */
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
     * RedAndBlackHomepageButton class object
     * creates graphics group objects and text buttons
     * @param size
     * @param cavas
     */
    public RedAndBlackHomepageButton(double size, CanvasWindow canvas) {

        //initialize size
        this.size = size;
        this.canvas = canvas;

        //new graphics group, create new icon
        group = new GraphicsGroup();
        rbIcon = new Image(0, 0);
        rbIcon.setMaxWidth(size * .5);
        rbIcon.setMaxHeight(size * .5);
        group.add(rbIcon);

        //red and black label
        rbLabel = new GraphicsText();
        rbLabel.setFont(FontStyle.PLAIN, size * 0.02);
        group.add(rbLabel);    

        //red and black description
        rbDescription = new GraphicsText();
        rbDescription.setFont(FontStyle.PLAIN, size * 0.02);
        rbDescription.setCenter(size * .35, size * .8);
        canvas.add(rbDescription);

        //calls the update method to update the visuals of the group
        update();

        //creates a border around the picture
        topBorder = new Line(leftX-5, topY-2, rightX+5, topY-2);
        rightBorder = new Line(rightX+2, topY-5, rightX+2, bottomY+5);
        leftBorder = new Line(leftX-2, topY-5, leftX-2, bottomY+5);
        bottomBorder= new Line(leftX-5, bottomY+2, rightX+5, bottomY+2);

        //sets the border to the color of the background and their width
        topBorder.setStrokeWidth(30);
        rightBorder.setStrokeWidth(30);
        leftBorder.setStrokeWidth(30);
        bottomBorder.setStrokeWidth(30);
        topBorder.setStrokeColor(Color.lightGray);
        rightBorder.setStrokeColor(Color.lightGray);
        leftBorder.setStrokeColor(Color.lightGray);
        bottomBorder.setStrokeColor(Color.lightGray);

        //adds the borders to the canvas
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
     * updates the red and black label
     */
    @Override
    public void update() {
        //updates the visuals of the group
        rbIcon.setImagePath("images/redAndBlackPicture.png");
        rbLabel.setText("Red and Black Tree");
        rbDescription.setText("");
        //calls the method to update positions of graphics objects
        updateLayout();

    }

    /**
     * updates layout of red and black icon and red and black icon
     * initializes variables which are used to create borders.
     */
    public void updateLayout() {
        //updating positions of the image and label
        rbIcon.setCenter(size * .75, size *.25);
        rbLabel.setCenter(size * .75, size * .5);

        //grabs the borders position of the image
        leftX = rbIcon.getX();
        topY = rbIcon.getY();
        rightX = rbIcon.getX() + rbIcon.getWidth();
        bottomY = rbIcon.getY() + rbIcon.getHeight();
    }

    /**
     * returns the value of the size variable
     */
    public double getSize() {
        return this.size;
    }

    /**
     * Runs the visual on hover effect. Borders around the image button appear.
     */
    @Override
    public void onHover(Point position) {
        //if the mouse position is within the bounds of the image
        if (rbIcon.isInBounds(position)) {
            //add information about the tree to the canvas
            rbDescription.setText("Red and Black Tree Automatic Balancing");

            //make the borders visible
            topBorder.setStrokeWidth(5);
            rightBorder.setStrokeWidth(5);
            leftBorder.setStrokeWidth(5);
            bottomBorder.setStrokeWidth(5);
            topBorder.setStrokeColor(Color.black);
            rightBorder.setStrokeColor(Color.black);
            leftBorder.setStrokeColor(Color.black);
            bottomBorder.setStrokeColor(Color.black);

        } else {
            //hide the information about the tree
            rbDescription.setText("");

            //hide the borders
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

    /**
     * Clears the canvas and adds new objects to the canvas which 
     * make up the input box screen
     * @param position
     * @param textField
     * @param button
     * @param doneButton
     * @param removeButton
     * @param backButton
     */
    public void onClick(Point position, TextField textField, Button button, Button removeButton, Button backButton, 
    GraphicsText infoText, RedAndBlackTreeVisualization<Integer> rbTree, Button traverseButton) {
        //if the mouse position is within the bounds of the image
        if (rbIcon.isInBounds(position)) {
            //reset the canvas
            canvas.removeAll();
            canvas.add(textField);
            canvas.add(button);
            // canvas.add(removeButton); // We were unable to implement the deletion 
            canvas.add(backButton);
            canvas.add(infoText);
            canvas.add(rbTree.graphics, 0, 0);
            canvas.add(traverseButton);
            TreeVisualizationApp.avlrbSetter(1);
        }
    }

}
