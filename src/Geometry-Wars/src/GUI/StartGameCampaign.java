package GUI;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;
import javax.swing.*;

import GComponents.GButton;
import GComponents.GFont;
import GComponents.GPanel;

/**
 * Created by Laurens Visser on 9/11/2016.
 */
public class StartGameCampaign extends GPanel {
    private StartGameCampaign panel = this;

    public StartGameCampaign() throws MalformedURLException, IOException, FontFormatException {

       
        initComponents();


    }

    @Override
    public void initComponents() throws IOException, FontFormatException {
        JButton Continue = new GButton("Continue", 36f, 150,230,300,80);

        JButton NewCampaign = new GButton("New Campaign", 36f, 200,350,350,80);
        JButton ClearCampaign = new GButton("Clear Campaign", 36f, 250,470,350,80);
        JButton Back = new GButton("Back", 36f, 670,620,300,80);

        JLabel label = new JLabel("Geometry Wars", SwingConstants.CENTER);

        //props
        label.setOpaque(true);
        label.setFont(new GFont(65));
        label.setBackground(new Color(255,255,255,95));
        Continue.setBackground(new Color(255,255,255,200));
        NewCampaign.setBackground(new Color(255,255,255,200));
        ClearCampaign.setBackground(new Color(255,255,255,200));

        Back.setBackground(new Color(255,255,255,200));




        //Bounds

        label.setBounds(25,25,650,100);;


        this.add(Continue);
        this.add(NewCampaign);
        this.add(ClearCampaign);

        this.add(label);
        this.add(Back);


        //Action listeners
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panel.setVisible(false);
                GUI.Window window = (GUI.Window) SwingUtilities.getRoot(panel.getParent());
                window.getStartGame().setVisible(true);
            }



        });


        
    }


}
