

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


public class AVLHomepageButton implements PleasingButton{

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

        //border lines
        topBorder = new Line(size * 0, (size * 0) + 2.5, size * .5, (size * 0) + 2.5);
        rightBorder= new Line(size * .5, size * 0, size * .5, size * .5);
        leftBorder = new Line((size * 0) + 2.5, size * 0, (size * 0) + 2.5, size * .5);
        bottomBorder= new Line(size * 0, size * .5, size * .5, size * .5);

        topBorder.setStrokeWidth(0);
        rightBorder.setStrokeWidth(0);
        leftBorder.setStrokeWidth(0);
        bottomBorder.setStrokeWidth(0);
        topBorder.setStrokeColor(Color.lightGray);
        rightBorder.setStrokeColor(Color.lightGray);
        leftBorder.setStrokeColor(Color.lightGray);
        bottomBorder.setStrokeColor(Color.lightGray);

        canvas.add(topBorder);
        canvas.add(rightBorder);
        canvas.add(leftBorder);
        canvas.add(bottomBorder);

        // topBorder.setStrokeWidth(size);


        update();

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
        avlIcon.setImagePath("images/avlImage .png");
        avlLabel.setText("AVL Tree");
        avlDescription.setText("");
        updateLayout();

    }

    /**
     * updates layout of avlicon and avllabel
     */
    public void updateLayout() {
        avlIcon.setCenter(size * .25, size *.25);
        avlLabel.setCenter(size * .25, size * .5);
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
        if (avlIcon.isInBounds(position)) {
            avlDescription.setText("Information about the avl structure");
            topBorder.setStrokeWidth(5);
            rightBorder.setStrokeWidth(5);
            leftBorder.setStrokeWidth(5);
            bottomBorder.setStrokeWidth(5);
            topBorder.setStrokeColor(Color.black);
            rightBorder.setStrokeColor(Color.black);
            leftBorder.setStrokeColor(Color.black);
            bottomBorder.setStrokeColor(Color.black);


        } else {
            avlDescription.setText("");
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

    public void onClick(Point position, TextField textField, Button button) {
        if (avlIcon.isInBounds(position)) {
            canvas.removeAll();
            canvas.add(textField);
            canvas.add(button);
        }
    }

}
