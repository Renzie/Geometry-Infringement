package GUI;

import java.awt.Color;
import java.awt.FontFormatException;
import java.io.*;
import java.sql.SQLException;
import javax.swing.*;
import GComponents.*;
import Game.Sound;

/**
 * Created by Laurens Visser on 9/11/2016.
 */
class StartGame extends GPanel {
    //region Instance Variables

    private StartGame panel = this;

    //endregion

    //region Constructors

    StartGame() throws IOException, FontFormatException {
        initComponents();
    }

    //endregion

    //region Behaviour

    @Override
    public void initComponents() throws IOException, FontFormatException {
        panel.removeAll();

        JButton SoloGame = new GButton("Solo Game", 24f, 150,230,300,80);
        //JButton War = new GButton("War", 24f, 550,230,300,80);
        //JButton SoloGame = new GButton("Solo Game", 24f, 200,350,300,80);
        JButton Coop = new GButton("Co-op", 24f, 200,350,300,80);
        JButton Back = new GButton("Back", 24f, 820, 650, 170, 63);
        JButton Highscores = new GButton("High Scores", 24f, 550,230,300,80);

        JLabel label = new GLabel("Geometry Wars", 65f, 25, 25, 650, 100, true, Color.darkGray);

        //props
        //War.setBackground(new Color(255,255,255,200));
        SoloGame.setBackground(new Color(255,255,255,200));
        //Campaign.setBackground(new Color(255,255,255,200));
        Coop.setBackground(new Color(255,255,255,200));
        Back.setBackground(new Color(255,255,255,200));
        Highscores.setBackground(new Color(255,255,255,200));

        //Bounds

        this.add(SoloGame);
        //this.add(War);
        //this.add(Campaign);
        this.add(Coop);
        this.add(label);
        this.add(Back);
        this.add(Highscores);

        //ActionListeners

        SoloGame.addActionListener(evt -> {
            new Sound("click");
            panel.setVisible(false);
            Window window = (Window) SwingUtilities.getRoot(panel.getParent());
            try {
                window.getSpel().initDankabank();
                window.getStartGameCampaign().initComponents();
            } catch (IOException | FontFormatException | SQLException e) {
                e.printStackTrace();
            }
            window.getStartGameCampaign().setVisible(true);
        });

        Coop.addActionListener(evt -> {
            new Sound("click");
            panel.setVisible(false);
            Window window = (Window) SwingUtilities.getRoot(panel.getParent());
            window.getInGame().setVisible(true);
            window.getInGame().getStartGame().setVisible(true);
            window.getInGame().getGameEnd().setVisible(false);
            window.getInGame().getPause().setVisible(false);
            window.getInGame().setCoop(true);
        });

        Back.addActionListener(evt -> {
            new Sound("click");
            panel.setVisible(false);
            Window window = (Window) SwingUtilities.getRoot(panel.getParent());
            window.getMainMenu().setVisible(true);
        });

        Highscores.addActionListener(evt -> {
            new Sound("click");
            panel.setVisible(false);
            Window window = (Window) SwingUtilities.getRoot(panel.getParent());

            try {
                window.getSpel().initDankabank();
                window.getHighScores().initComponents();
            } catch (IOException | FontFormatException | SQLException e) {
                e.printStackTrace();
            }
            window.getHighScores().setVisible(true);
        });
    }

    //endregion
}