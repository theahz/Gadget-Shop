// Due to this class not being part of our course work, I have added comments to each line to explain them properly.
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.BasicStroke;

// Class RoundedButton extends JButton to create a button with rounded corners.
public class RoundedButton extends JButton {

    public RoundedButton(String label) {
        super(label); // Call to the parent class (JButton) constructor.
        Dimension size = new Dimension(110, 25); // Set the preferred size of the button.
        setPreferredSize(size); // Set the preferred size for the button.
        setMaximumSize(size); // Set the maximum size for the button.
        setFont(new Font("Arial", Font.PLAIN, 12)); // Set the font of the button's text.
        setContentAreaFilled(false); // This is the Do not fill the content area by default, allows for custom painting.
    }
    // Method to paint the round background and label of the button.
    protected void paintComponent(Graphics g) {
        // Change the color of the button when it's pressed.
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray); // Set the color to light gray when the button is pressed.
        } else {
            g.setColor(getBackground()); // Set the color to the button's background color.
        }
        Graphics2D g2d = (Graphics2D) g; // Cast Graphics object to Graphics2D for more control.
        // Apply anti-aliasing to make the edges smoother.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Fill the round rectangle with the current color.
        g2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        super.paintComponent(g); // Call superclass method to handle standard painting.
    }
    // Method to paint the border of the button.
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground()); // Set the color to the button's foreground color.
        Graphics2D g2d = (Graphics2D) g; // Cast Graphics object to Graphics2D.
        // Apply anti-aliasing to make the edges smoother.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Set the stroke of the border.
        g2d.setStroke(new BasicStroke(1));
        // Draw the round rectangle border.
        g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    }
    // Hit detection for the button.
    Shape shape; // Declare a Shape object to represent the button's hitbox.
    // Method to determine if a given point is within the bounds of the button.
    public boolean contains(int x, int y) {
        // Check if the shape needs to be reinitialized.
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            // Create a new shape that matches the button's current bounds.
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        }
        // Return true if the given point is within the shape.
        return shape.contains(x, y);
    }
}
