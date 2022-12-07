

//imports
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;
import edu.macalester.graphics.Line;
import java.awt.Color;


public class AVLHomepageButton implements PleasingButton {

    //instance variables
    private final double size;
    private GraphicsGroup group;

    private Image avlIcon;
    private GraphicsText avlLabel;
    private GraphicsText avlDescription;
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
    public AVLHomepageButton (double size, CanvasWindow canvas) {

        //initialize size
        this.size = size;
        this.canvas = canvas;

        //new graphics group, create new icon
        group = new GraphicsGroup();
        avlIcon = new Image(0, 0);
        avlIcon.setMaxWidth(size * .5);
        avlIcon.setMaxHeight(size * .5);
        group.add(avlIcon);

        //avl label
        avlLabel = new GraphicsText();
        avlLabel.setFont(FontStyle.PLAIN, size * 0.02);
        group.add(avlLabel);    

        //avl description
        avlDescription = new GraphicsText();
        avlDescription.setFont(FontStyle.PLAIN, size * 0.02);
        avlDescription.setCenter(size * .35, size * .8);
        canvas.add(avlDescription);

        //calls the update method to update the visuals of the group
        update();

        //creates a border around the picture
        topBorder = new Line(leftX-5, topY-2, rightX+5, topY-2);
        rightBorder = new Line(rightX+2, topY-5, rightX+2, bottomY+5);
        leftBorder = new Line(leftX-2, topY-5, leftX-2, bottomY+5);
        bottomBorder= new Line(leftX-5, bottomY+2, rightX+5, bottomY+2);

        //sets the border to the color of the background and their width
        topBorder.setStrokeWidth(5);
        rightBorder.setStrokeWidth(5);
        leftBorder.setStrokeWidth(5);
        bottomBorder.setStrokeWidth(5);
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
     * updates the avl label
     */
    @Override
    public void update() {
        //updates the visuals of the group
        avlIcon.setImagePath("images/avlImage .png");
        avlLabel.setText("AVL Tree");
        avlDescription.setText("");
        //calls the method to update positions of graphics objects
        updateLayout();

    }

    /**
     * updates layout of avlicon and avllabel
     * Initializes variables which are used to create borders.
     */
    public void updateLayout() {
        //updating positions of the image and label
        avlIcon.setCenter(size * .25, size *.25);
        avlLabel.setCenter(size * .25, size * .5);
        //grabs the borders position of the image
        leftX = avlIcon.getX();
        topY = avlIcon.getY();
        rightX = avlIcon.getX() + avlIcon.getWidth();
        bottomY = avlIcon.getY() + avlIcon.getHeight();
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
        if (avlIcon.isInBounds(position)) {
            //add information about the tree to the canvas
            avlDescription.setText("Information about the avl structure");
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
            avlDescription.setText("");
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
     * upon clicking the avl label button, this function will clear 
     * the canvas and add the input box screen
     * @param position
     * @param textField
     * @param button
     * @param doneButton
     * @param removeButton
     * @param backButton
     */
    public void onClick(Point position, TextField textField, Button button, Button doneButton, Button removeButton, Button backButton) {
        //if the mouse position is within the bounds of the image
        if (avlIcon.isInBounds(position)) {
            //reset the canvas
            canvas.removeAll();
            canvas.add(textField);
            canvas.add(button);
            canvas.add(doneButton);
            canvas.add(removeButton);
            canvas.add(backButton);
        }
    }

}
