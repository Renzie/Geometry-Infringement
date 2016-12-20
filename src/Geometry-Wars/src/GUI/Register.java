/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GComponents.*;
import Game.Spel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Yentl
 */
public class Register extends GPanel {
    private Register panel = this;

    public Register() throws MalformedURLException, IOException, FontFormatException {

        initComponents();

    }

    @Override
    public void initComponents() throws IOException, FontFormatException {
        JLabel label = new JLabel("Geometry Wars", SwingConstants.CENTER);
        GButton register = new GButton("Register", 24f, 220,500,170,50);
        GButton Back = new GButton("Back", 24f, 635,650, 170, 63);
        GLabel registered = new GLabel("Registration Successful", 24f, 220,120,350,50, false, Color.white);
        GInputField username = new GInputField(480,190,200,50);
        GLabel lblusername = new GLabel("Username", 24f, 220,190,150,50, false, Color.white);
        GPasswordField password = new GPasswordField(480, 260, 200, 50);
        GLabel lblpassword = new GLabel("Password", 24f, 220, 260, 150, 50, false, Color.white);
        GPasswordField passwordconfirm = new GPasswordField(480,330,200,50);
        GLabel lblpasswordconfirm = new GLabel("Repeat Password", 24f, 220, 330, 300, 50, false, Color.white);
        GInputField email = new GInputField(480,400,200,50);
        GLabel lblemail = new GLabel("E-mail", 24f, 220, 400, 150, 50, false, Color.white);
        JButton Exit = new GButton("Exit", 24f, 820, 650, 170, 63);

        label.setOpaque(true);
        label.setFont(new GFont(65));
        label.setBackground(new Color(255,255,255,95));
        registered.setVisible(false);

        label.setBounds(25,25,650,100);

        this.add(label);
        this.add(register);
        this.add(registered);
        this.add(username);
        this.add(lblusername);
        this.add(password);
        this.add(lblpassword);
        this.add(passwordconfirm);
        this.add(lblpasswordconfirm);
        this.add(email);
        this.add(lblemail);
        this.add(Exit);
        this.add(Back);

        //Action Listeners
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(username.getText(), "")){
                    registered.setText("Please enter a username");
                } else if (password.getPassword().length == 0){
                    registered.setText("Please enter a password");
                } else if (passwordconfirm.getPassword().length == 0){
                    registered.setText("Please confirm your password");
                } else if (Objects.equals(email.getText(), "")){
                    registered.setText("Please enter your email address");
                } else if (!Arrays.equals(password.getPassword(), passwordconfirm.getPassword())){
                    registered.setText("Your passwords do not match, please try again");
                } else {
                    String result = checkAndCreate(username.getText(), password.getPassword(), email.getText());

                    if(Objects.equals(result, "")){
                        registered.setText("Registration Successful");
                    } else {
                        registered.setText(result + " bestaat al.");
                    }
                }
                registered.setVisible(true);
            }
        });

        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panel.setVisible(false);
                GUI.Window window = (GUI.Window) SwingUtilities.getRoot(panel.getParent());
                window.getLogin().setVisible(true);
            }
        });
    }

    private String checkAndCreate(String gebruikersnaam, char[] password, String email){
        Spel spel = new Spel();
        String result = "";
        try {
            result = spel.infoChecker(gebruikersnaam, email);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        if(Objects.equals(result, "")){
            try {
                spel.registerPlayer(gebruikersnaam, password, email);
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (NoSuchAlgorithmException e1) {
                e1.printStackTrace();
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        } else {
            return result;
        }
        return "";
    }
}
