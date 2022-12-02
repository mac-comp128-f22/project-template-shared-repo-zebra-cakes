import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;

public interface PleasingButton {

    /*
     * This shows what the graphics of the button look like.
     */
    GraphicsObject getButtonGraphics();

    /*
     * This will show the proper image, label and description for the button
     */
    void update();

    /*
     * This is called when the mouse is on top of the button.
     */
    void onHover(Point position);
    
}
