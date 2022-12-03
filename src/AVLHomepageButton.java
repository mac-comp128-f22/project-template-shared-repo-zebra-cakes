

//imports
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;


public class AVLHomepageButton implements PleasingButton{

    //instance variables
    private final double size;
    private GraphicsGroup group;

    private Image avlIcon;
    private GraphicsText avlLabel;
    private GraphicsText avlDescription;
    public CanvasWindow canvas;



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
            
        } else {
            avlDescription.setText("");
        }
        
    }

}
