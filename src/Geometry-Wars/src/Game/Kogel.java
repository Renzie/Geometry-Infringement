package Game;

/**
 * Created by Yentl-PC on 10/11/2016.
 */
public class Kogel extends Sprite {

    private final int SCREEN_WIDTH = 1920;
    private int kogelSnelheid = 5;

    public Kogel (int x, int y, int mousex, int mousey){
        super(x, y, mousex, mousey);

        initKogel();
    }

    private void initKogel(){
        loadImage("src/Media/kogel1.png");
    }

    public int getKogelSnelheid() {
        return kogelSnelheid;
    }

    public void move(double velocityX, double velocityY){
        x += velocityX;
        y += velocityY;

        if(x > SCREEN_WIDTH){
            visible = false;
        }
    }
}
