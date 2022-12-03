

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


public class RedAndBlackHomepageButton implements PleasingButton{

    //instance variables
    private final double size;
    private GraphicsGroup group;

    private Image rbIcon;
    private GraphicsText rbLabel;
    private GraphicsText rbDescription;
    public CanvasWindow canvas;



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
            rbDescription.setText("Information about the red and black structure");
            
        } else {
            rbDescription.setText("");
        }
    }

    public void onClick(Point position, TextField textField, Button button) {
        if (rbIcon.isInBounds(position)) {
            canvas.removeAll();
            canvas.add(textField);
            canvas.add(button);
        }
    }

}
