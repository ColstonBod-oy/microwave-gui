/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microwavegui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author User
 */
public class SciTextField extends JTextField {
    
    private String initText;
    
    public SciTextField(String initText, Font font) {
        this.initText = initText;
        setText(initText);
        setFont(font.deriveFont(21f));
        setEditable(false);
        setBackground(Color.decode("#01012b"));
        setForeground(Color.decode("#ff160c"));
        setBorder(BorderFactory.createCompoundBorder(new RoundedBorder(), new EmptyBorder(new Insets(15, 25, 15, 25))));
    }
    
    public String getInitText() {
        return initText;
    }
    
}
