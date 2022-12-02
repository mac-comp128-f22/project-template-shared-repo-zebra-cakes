import edu.macalester.graphics.Rectangle;
import java.awt.Color;


public class PleasingButtonBox extends Rectangle{

    public PleasingButtonBox(double x, double y, double width, double height) {
        super(x, y, width, height);
        //TODO Auto-generated constructor stub
        setStrokeWidth(Math.rint((width + height) / 40 + 1) * 0.5);
        setActive(false);
    }

    public void setActive(boolean active) {
        setFillColor(active
            ? new Color(0x3ba634)
            : new Color(0xD9D9D9));
    }
    
}
