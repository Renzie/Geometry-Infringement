/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.gm;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Renzie
 */
public class GUIGM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, FontFormatException {
        // TODO code application logic here
        
            //create the font to use. Specify the size!
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("src\\font\\Audiowide-Regular.ttf")).deriveFont(64f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\font\\Audiowide-Regular.ttf")));
           
      
       
        
        //Make components
        //==================================================
                JFrame frame = new JFrame("Test");
                JButton button = new JButton("startGame");
                JButton button2 = new JButton("test");
                JLabel label = new JLabel("title", SwingConstants.CENTER);
        
        
        //==================================================
        
        //Set text
        //==================================================
                button.setText("Start Game");
                
                label.setText("Geometry Wars");
                
                
        
        
        //==================================================
        
        //Set Properties
        //==================================================
                label.setFont(font);
                label.setOpaque(true);
                label.setBackground(new Color(255,255,255,95));
                
        
        //==================================================
        
    frame.setContentPane(new JPanel() {
        BufferedImage image = ImageIO.read(new File("src\\Media\\Background.png"));
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, 1920, 1080, this);
            
        }
    });
    frame.setLayout(null);
    
    
    
    
        //Set Bounds
        //==================================================
                 
        button.setBounds(250,200,300,80);
        label.setBounds(50,50,600,100);
       
        
        
        //==================================================
        
        //Add Components
        //==================================================
                frame.add(button);
                frame.add(button2);
                frame.add(label);
        
        //==================================================
    
    

    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1920, 1080);
    frame.setVisible(true);
    }
    
}
