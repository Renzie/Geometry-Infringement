package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Yentl on 25-Jan-17.
 */
public class HitFlash implements Runnable {
    private Schip schip;

    @Override
    public void run() {
        InputStream image = getClass().getResourceAsStream(schip.getImageString());
        String hit = (schip.getImageString().substring(0, schip.getImageString().length() - 4)) + "-hit.png";
        InputStream imagehit = getClass().getResourceAsStream(hit);

        try {
            ImageIcon ii = new ImageIcon(ImageIO.read(imagehit));
            schip.setImage(ii.getImage());
            Thread.sleep(100);
            ii = new ImageIcon(ImageIO.read(image));
            schip.setImage(ii.getImage());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public HitFlash(Schip schip){
        this.schip = schip;
    }
}
