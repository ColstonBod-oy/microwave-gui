# Documentation

Documentation for Activity #4: Microwave Oven.

## Groupmates

Colston Bod-oy - Coding  
Jean Delmari Bernal - Documentation

## Output

![Screenshot_1](https://user-images.githubusercontent.com/75562733/158831853-41eebf34-d7f0-4b57-b42a-7c3327fe1bad.png)

* Contains 1 main class named MicrowaveGUI and 3 additional classes (SciTextField, SciIconButton, SciButton).
* Assets: cyberspace.ttf, emblem.png.
```
Whole project with assets: https://github.com/ColstonBod-oy/microwave-gui
```

### MicrowaveGUI.java

![Screenshot_2](https://user-images.githubusercontent.com/75562733/158833048-72a86666-ea05-4ef7-8239-942540417886.png)

* The main class of the program that instantiates SciTextField, SciIconButton, and SciButton.
* Stores the isTimerRunning array that would be passed as an argument when creating SciButtons.
* Has a JPanel named controlsPanel that uses a 4x3 GridLayout and adds all the SciButtons.
* Has a JPanel named mainPanel that uses a BorderLayout and adds SciTextField to NORTH and controlsPanel to CENTER.
* Has a JFrame named mainFrame that adds mainPanel to EAST and SciIconButton to CENTER.
```
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
```
Creates rounded corners for the SciTextField and SciIconButton. 

### SciTextField.java

![Screenshot_3](https://user-images.githubusercontent.com/75562733/158834308-e4ea48d2-75fe-4b50-988b-5bb4a361e465.png)
![Screenshot_4](https://user-images.githubusercontent.com/75562733/158834325-7cad5d3f-7a16-4095-912f-236c38b5f3bb.png)
![Screenshot_5](https://user-images.githubusercontent.com/75562733/158834331-5fe293d8-7e18-4663-a472-839467bd5fa9.png)
![Screenshot_6](https://user-images.githubusercontent.com/75562733/158834337-83ed265f-281d-473d-b29a-1ce5da366d41.png)

* Extends the JTextField class.
* Instantiates a custom JTextField.
* Stores the initText String which is the default text displayed.
* Displays the timer in hh:mm:ss format after the start button was clicked. 

### SciIconButton.java

![Screenshot_7](https://user-images.githubusercontent.com/75562733/158836327-eeba064a-0bd8-451d-8f9d-e833311867fc.png)

* Extends the SciButton class.
* Calls the first constructor of SciButton class.
* Creates a custom JButton with an ImageIcon and a text below it.
```
Image dimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
```
Allows image to automatically adjust to the button's dimensions using a Buffered Image object.

### SciButton.java

![Screenshot_8](https://user-images.githubusercontent.com/75562733/158838459-de32da45-e8d2-449f-b942-2dc36c1bea7a.png)
![Screenshot_9](https://user-images.githubusercontent.com/75562733/158838478-155f8576-8ed2-497d-82a5-cd95dd68ca86.png)

* Extends the JButton class.
* Instantiates custom JButtons.
* Has an overloaded constructor.
* Its first constructor was used for all the buttons to create a general MouseListener and to input a number to the text field if the clicked button is not the start or stop button.
* Its second constructor was used for the start button which initializes a timer, converts the text input to hh:mm:ss format, and disables the buttons 0 to 9.
* Its third constructor was used for the stop button which stops the timer, resets the text field's text to the initText string, and enables the buttons 0 to 9.
```
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
```
Creates very rounded corners for the SciButtons.

### End of Documentation
