import java.util.ArrayList;
import java.util.List;

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

    //list of buttons
    private List<PleasingButtonBox> boxes = new ArrayList<>();


    /**
     * AVLHomepageButton class object
     * creates graphics group objects and text buttons
     * @param size
     * @param cavas
     */
    public AVLHomepageButton (double size, CanvasWindow cavas) {

        //initialize size
        this.size = size;

        //new graphics group, create new icon
        group = new GraphicsGroup();
        avlIcon = new Image(0, 0);
        avlIcon.setMaxWidth(size);
        avlIcon.setMaxHeight(size);
        group.add(avlIcon);

        //avl label
        avlLabel = new GraphicsText();
        avlLabel.setFont(FontStyle.PLAIN, size * 0.075);
        group.add(avlLabel);    

        //avl description
        avlDescription = new GraphicsText();
        avlDescription.setFont(FontStyle.PLAIN, size * 0.035);

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
        avlIcon.setImagePath(null);
        avlLabel.setText("AVL Tree");
        avlDescription.setText("AVL tree description goes here");

    }

    /**
     * updates layout of avlicon and avllabel
     */
    public void updateLayout() {
        avlIcon.setCenter(size * .5, size *.5);
        avlLabel.setCenter(size * .5, size * .25);
    }

    /**
     * 
     * @param location
     * @return
     */
    private PleasingButtonBox getBoxAt(Point location) {
        GraphicsObject obj = group.getElementAt(location);
        if (obj instanceof PleasingButtonBox) {
            return (PleasingButtonBox) obj;
        }
        return null;
    }

    /**
     * 
     * @param box
     */
    private void updateZoomAndDescription (PleasingButtonBox box) {
        box.setActive(true);
        for (PleasingButtonBox item : boxes) {
            if (item != box) {
                item.setActive(false);
            }
        }
        avlIcon.setScale( size * 1.2, size * 1.2);
    }

    /**
     * 
     */
    @Override
    public void onHover(Point position) {
        if (getBoxAt(position) != null) {
            updateZoomAndDescription(getBoxAt(position));
        }        
    }

    
    
}
