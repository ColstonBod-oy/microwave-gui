/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microwavegui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author User
 */
public class SciButton extends JButton {
    
    private int hours;
    private int minutes;
    private int seconds;
    private String ddHours;
    private String ddMinutes;
    private String ddSeconds;
    private DecimalFormat dFormat;
    private Component[] buttons;
    private Timer timer;
    
    public SciButton(String text, Font font, SciTextField textField, boolean[] isTimerRunning) {
        setText(text);
        setFont(font.deriveFont(14f));
        setFocusPainted(false);
        setBackground(Color.decode("#08deea"));
        setForeground(Color.decode("#01012b"));
        setBorder(BorderFactory.createCompoundBorder(new SciButton.VeryRoundedBorder(), new EmptyBorder(new Insets(25, 25, 25, 25))));
        
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isEnabled() && textField != null && !getText().equals("start") && !getText().equals("stop")) {
                    if (textField.getText().equals(textField.getInitText())) {
                        textField.setText(text);
                        textField.setForeground(Color.decode("#08deea"));
                    }
                    
                    else {
                        textField.setText(textField.getText() + text);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (isEnabled()) {
                    setContentAreaFilled(false);
                    setOpaque(true);
                    setBackground(Color.decode("#08deea"));
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isEnabled()) {
                    setContentAreaFilled(true);
                    setBackground(Color.decode("#00fefc"));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (isEnabled()) {
                    setBackground(Color.decode("#00fefc"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (isEnabled()) {
                    setBackground(Color.decode("#08deea"));
                }
            }
        });
    }
    
    public SciButton(String text, Font font, SciTextField textField, JPanel controlsPanel, boolean[] isTimerRunning) {
        this(text, font, textField, isTimerRunning);
        
        if (text.equals("start")) {
            dFormat = new DecimalFormat("00");
            
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    seconds--;
                    ddHours = dFormat.format(hours);
                    ddMinutes = dFormat.format(minutes);
                    ddSeconds = dFormat.format(seconds);
                    textField.setText(ddHours + ":" + ddMinutes + ":" + ddSeconds);
                    
                    if (seconds == -1) {
                        seconds = 59;
                        minutes--;
                        ddHours = dFormat.format(hours);
                        ddMinutes = dFormat.format(minutes);
                        ddSeconds = dFormat.format(seconds);
                        textField.setText(ddHours + ":" + ddMinutes + ":" + ddSeconds);
                    }
                    
                    if (minutes == -1) {
                        minutes = 59;
                        hours--;
                        ddHours = dFormat.format(hours);
                        ddMinutes = dFormat.format(minutes);
                        ddSeconds = dFormat.format(seconds);
                        textField.setText(ddHours + ":" + ddMinutes + ":" + ddSeconds);
                    }
                    
                    if (hours == 0 && minutes == 0 && seconds == 0) {
                        textField.setText(textField.getInitText());
                        timer.stop();
                        isTimerRunning[0] = false;
                        buttons = controlsPanel.getComponents();
                    
                        for (int i = 0; i < 10; i++) {
                            buttons[i].setEnabled(true);
                        }
                    }
                }
            });
        }
        
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (getText().equals("start") &&
                        !textField.getText().equals(textField.getInitText()) &&
                        !isTimerRunning[0]
                    ) {
                    if (Integer.parseInt(textField.getText()) == 0) {
                        textField.setText(textField.getInitText());
                        textField.setForeground(Color.decode("#ff160c"));
                    }
                    
                    else {
                        hours = Integer.parseInt(textField.getText()) / 60;
                        minutes = Integer.parseInt(textField.getText()) % 60;
                        seconds = 0;
                        timer.start();
                        isTimerRunning[0] = true;
                        textField.setForeground(Color.decode("#ff160c"));
                        buttons = controlsPanel.getComponents();
                    
                        for (int i = 0; i < 10; i++) {
                            buttons[i].setEnabled(false);
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    
    public SciButton(String text, Font font, SciTextField textField, JPanel controlsPanel, 
            Timer timer, boolean[] isTimerRunning
        ) {
        this(text, font, textField, isTimerRunning);
        
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (getText().equals("stop") &&
                        !textField.getText().equals(textField.getInitText()) &&
                        isTimerRunning[0]
                    ) {
                    timer.stop();
                    isTimerRunning[0] = false;
                    textField.setText(textField.getInitText());
                    buttons = controlsPanel.getComponents();
                    
                    for (int i = 0; i < 10; i++) {
                        buttons[i].setEnabled(true);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    
    public Timer getTimer() {
        return timer;
    }
    
    // Creates very rounded corners 
    class VeryRoundedBorder extends AbstractBorder {
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(22));
            g2d.setColor(Color.decode("#d1f7ff"));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawRoundRect(x, y, width - 1, height - 1, 50, 50);
        }
    }
    
}
