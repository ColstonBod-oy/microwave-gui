/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microwavegui;

import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author User
 */
public class SciIconButton extends SciButton {
    
    public SciIconButton(String text, Font font) throws IOException {
        super(text, font, null, null);
        setFont(font.deriveFont(25f));
        setBorder(BorderFactory.createCompoundBorder(new RoundedBorder(), new EmptyBorder(new Insets(15, 25, 15, 25))));
        BufferedImage img = ImageIO.read(getClass().getResource("/microwavegui/assets/emblem.png"));
        Image dimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon ico = new ImageIcon(dimg);
        setIcon(ico);
        setFocusPainted(false);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);
    }
    
}
