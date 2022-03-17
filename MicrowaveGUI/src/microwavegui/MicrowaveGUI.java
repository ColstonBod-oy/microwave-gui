/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package microwavegui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author User
 */
public class MicrowaveGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FontFormatException, IOException {
        boolean[] isTimerRunning = {false};
        
        Font font = Font.createFont(Font.TRUETYPE_FONT, MicrowaveGUI.class.getResourceAsStream("/microwavegui/assets/cyberspace.ttf")).deriveFont(10f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        
        SciTextField textField = new SciTextField("time to be displayed here", font);
        
        JPanel controlsPanel = new JPanel();
        controlsPanel.setOpaque(false);
        controlsPanel.setLayout(new GridLayout(4, 3));
        
        for (int i = 1; i <= 9; i++) {
            controlsPanel.add(new SciButton(Integer.toString(i), font, textField, isTimerRunning));
        }
        
        controlsPanel.add(new SciButton(Integer.toString(0), font, textField, isTimerRunning));
        SciButton start = new SciButton("start", font, textField, controlsPanel, isTimerRunning);
        controlsPanel.add(start);
        controlsPanel.add(new SciButton("stop", font, textField, controlsPanel, start.getTimer(), isTimerRunning));
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(controlsPanel, BorderLayout.CENTER);
        
        JFrame mainFrame = new JFrame("Microwave GUI");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(mainPanel, BorderLayout.EAST);
        mainFrame.add(new SciIconButton("food to be placed here", font), BorderLayout.CENTER);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
    
}

// Creates rounded corners 
class RoundedBorder extends AbstractBorder {
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(12));
        g2d.setColor(Color.decode("#d1f7ff"));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
    }
}
