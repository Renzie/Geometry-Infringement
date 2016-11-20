package Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Renzie on 19/11/2016.
 */
public class SpriteRenzie {
    protected double x;
    protected double y;
    protected int width;
    protected int height;
    protected Image image;
    protected boolean visible;
    protected Point direction;

    public SpriteRenzie(double x, double y, Point direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
        visible = true;
    }

    protected void loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
        width = ii.getIconWidth();
        height = ii.getIconHeight();
    }

    public Image getImage() {
        return image;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point getDirection() { return direction; }


    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}