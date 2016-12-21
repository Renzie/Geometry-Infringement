package Game;


import GUI.GamePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import java.util.*;

import static java.lang.Math.abs;

/**
 * Created by Yentl-PC on 8/11/2016.
 */
public class Schip extends Sprite {

    //region Instance Variables

    private int nr;
    private int hp = 100;
    private int maxhp = 100;
    private int kracht = 10;
    private double speed;
    private double dx;
    private double dy;
    private int score = 0;
    private int newscore = 0;
    private int combo = 0;
    private int level = 0;
    private int currentXp = 0;
    private double maxXp = 1000;

    private int keyLeft;
    private int keyRight;
    private int keyUp;
    private int keyDown;
    private ArrayList<Kogel> kogels = new ArrayList<Kogel>();
    private double locationX;
    private double locationY;
    private double currentAngle;
    private Movement move;
    private boolean lifesteal;
    private boolean invulnerability;
    private boolean randomBullets;
    private boolean slowerEnemies;
    private boolean droneActive;
    private int SCREEN_WIDTH = 1024;
    private int SCREEN_HEIGHT = 768;
    private Drone drone;

    //private HashMap<String, Boolean> buffs = new HashMap<String, Boolean>();

    private String imageString;
    private Timer mousePressedTimer;


    //endregion

    //region Constructors

    public Schip(int nr, int hp, int kracht, String image, int keyLeft, int keyRight, int keyUp, int keyDown, double speed) {
        super(image);
        imageString = image;
        currentLocation = new Point();
        currentLocation.setLocation(700, 300);
        locationX = currentLocation.getX();
        locationY = currentLocation.getY();
        currentAngle = 0;
        this.nr = nr;
        this.hp = hp;
        this.kracht = kracht;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.speed = speed;
        move = new Movement(this, keyLeft, keyRight, keyUp, keyDown);
        //updateBuffs();
    }
    //endregion


   /* private void updateBuffs(){
        buffs.put("lifesteal", lifesteal);
        buffs.put("invulnerability", invulnerability);
        buffs.put("randomBullets", randomBullets);
        buffs.put("slowerEnemies", slowerEnemies);
        buffs.put("droneActive", droneActive);
    }
*/
    //region Getters


    public Drone getDrone() {
        return drone;
    }

    public String getImageString() {
        return imageString;
    }

    public int getKeyUp() {
        return keyUp;
    }

    public int getKeyDown() {
        return keyDown;
    }

    public int getKeyRight() {
        return keyRight;
    }

    public int getKeyLeft() {
        return keyLeft;
    }

    public int getKracht() {
        return kracht;
    }

    public int getNr() {
        return nr;
    }

    public Movement getMove() {
        return move;
    }

    public int getCombo() {
        return combo;
    }

    public int getScore() {
        return score;
    }

    public int getHp() {
        return hp;
    }

    public double getSpeed() {
        return speed;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentXp() {
        return currentXp;
    }

    /*public HashMap<String,Boolean> getBuffs() {
        return buffs;
    }*/

    //endregion

    //region Setters


    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void setControls(int keyLeft, int keyRight, int keyUp, int keyDown){
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
        this.keyUp = keyUp;
        this.keyDown = keyDown;
    }

    public ArrayList<Kogel> getKogels() {
        return kogels;
    }


    public double getCurrentAngle() {
        return currentAngle;
    }
    public void setCurrentAngle(double currentAngle) {
        this.currentAngle = currentAngle;
    }
    //endregion

    //region ComboProperties
    public boolean isInvulnerability() {
        return invulnerability;
    }

    public void setInvulnerability(boolean invulnerability) {
        this.invulnerability = invulnerability;
    }

    public boolean isLifesteal() {
        return lifesteal;
    }

    public void setLifesteal(boolean lifesteal) {
        this.lifesteal = lifesteal;
    }

    public boolean isRandomBullets() {
        return randomBullets;
    }

    public void setRandomBullets(boolean randomBullets) {
        this.randomBullets = randomBullets;
    }

    public boolean isSlowerEnemies() {
        return slowerEnemies;
    }

    public void setSlowerEnemies(boolean slowerEnemies) {
        this.slowerEnemies = slowerEnemies;
    }

    public boolean isDroneActive() {
        return droneActive;
    }

    public void setDroneActive(boolean droneActive) {
        this.droneActive = droneActive;
    }

    //endregion

    //region levelProperties


    public void addLevel() {
        this.level += 1;
    }

    public void addCurrentXp(int xp) {
        this.currentXp += xp;
    }

    public void resetCurrentXp() { this.currentXp = 0;}

    public double getMaxXp() {
        return maxXp;
    }

    public void setMaxXp(int level) {
        this.maxXp = Math.pow(2,level) * 1000;
    }

    //endregion


    public void checkLevel(){
        if(getCurrentXp() >= getMaxXp()){
            addLevel();
            setMaxXp(getLevel());
            checkLevel();
            resetCurrentXp();
        }

        switch (getLevel()){
            case 1:
                setKracht(75);
                break;
            case 2:
                setKracht(100);
                break;
            case 3:
                setKracht(150);
                break;
            case 4:
                setKracht(200);
                break;
            case 5:
                setKracht(250);
                break;
        }
    }

    public void checkForUpgrade(int combo) {
        //TODO terugveranderen :p - Renzie dit is voor de upgrade arraylist check
        if (combo % 4 == 0) {
            //Every 50 combo
            setInvulnerability(true);

            //System.out.println("setInvulnerability");
        } else if (combo % 2 == 0) {
            //Every 75 combo
            setSlowerEnemies(true);
        }
        switch (combo) {
            case 1:
                //when combo resets
                setLifesteal(false);
                setRandomBullets(false);
                break;
            case 50:
                setLifesteal(true);
                break;
            case 2:
                //stays active when reached
                setDroneActive(true);
                break;
            case 150:
                setRandomBullets(true);
                break;


        }
        //updateBuffs();
    }

    public void setCombo(int combo) {
        this.combo = combo;
    }

    //region Behaviour
    public void resetCombo() {
        setCombo(0);
    }

    public void addCombo() {
        combo += 1;
        addScore(100, combo);
    }


    public void addScore(int enemyscore, int combo) {
        score = enemyscore * combo;
        score = adjustScore(score);
    }

    public int adjustScore(int score) {

        newscore += score;
        System.out.println("score: " + newscore);
        System.out.println("combo: " + combo);
        return newscore;
    }

    public void setKracht(int kracht) {
        this.kracht = kracht;
    }

    public void addKracht(int amount) {
        this.kracht += amount;
    }

    public void addHp(int amount) {
        this.hp += amount;
    }

    public void loseHP(int amount) {
        this.hp -= amount;
    }

    public void beweegSchip() {


        locationX = limitToBorders(locationX, 75, 875);
        locationY = limitToBorders(locationY, 125, 525);

        currentLocation.setLocation(locationX += dx, locationY += dy);
    }

    private double limitToBorders(double currLocation, double minBorder, double maxBorder) {
        if (currLocation > maxBorder) {
            return maxBorder;
        } else if (currLocation < minBorder) {
            return minBorder;
        }
        return currLocation;
    }

    public void controllerPressed(int key){
        move.controllerPressed(key);
    }

    public void controllerReleased(int key){
        move.controllerReleased(key);
    }

    public void keyPressed(KeyEvent e) {
        move.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        move.keyReleased(e);
    }

    public void moveUp(double speed) {
        dy = -speed;
    }

    public void moveDown(double speed) {
        dy = speed;
    }

    public void moveLeft(double speed) {
        dx = -speed;
    }

    public void moveRight(double speed) {
        dx = speed;
    }

    public void controllerAim(int x, int y){
        Point point = new Point(x, y);
        fire(point);
        if (isRandomBullets()) {
            randomFire();
        }
    }

    public void mousePressed(MouseEvent e) {
        fire(e.getPoint());
        if (isRandomBullets()) {
            randomFire();
        }

    }

    public void mouseReleased(MouseEvent e) {
        /*if (mousePressedTimer != null){
            mousePressedTimer.stop();
            System.out.println("mouse released");
        }*/
    }

    private void addKogels(Kogel k) {
        kogels.add(k);
    }

    public void fire(Point mousePointer) {
        /*if (mousePressedTimer == null){
            mousePressedTimer = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {*/
                    double kogelX = locationX;
                    double kogelY = locationY;
                    addKogels(new Kogel(kogelX, kogelY, mousePointer, "src/Media/kogel1.png"));
               /* }
            });
       }
        else{
            mousePressedTimer.start();
        }
*/
    }

    public int randomX() {
        Random randomGenerator = new Random();

        int randGetal = randomGenerator.nextInt(SCREEN_WIDTH);


        return randGetal;

    }

    public int randomY() {

        Random randomGenerator = new Random();

        int randGetal = randomGenerator.nextInt(SCREEN_HEIGHT);

        return randGetal;

    }

    public void randomFire() {

        double kogelX = locationX;
        double kogelY = locationY;
        int kogelX2 = randomX();
        int kogelY2 = randomY();
        Point mousePointer2 = new Point(kogelX2, kogelY2);

        addKogels(new Kogel(kogelX, kogelY, mousePointer2, "src/Media/kogel1.png"));
        System.out.println(kogelX2 + " " + kogelY2);
    }



    public void setImage(String image){

    }


    // Dit zorgt ervoor dat de angle binnen 360 blijft.
    public double normalizeAngle(double angle) {
        if (angle < 0 || 360 < angle) {
            angle = (angle + 360) % 360;
            return angle;
        } else {
            return angle;
        }
    }
    //endregion
}
