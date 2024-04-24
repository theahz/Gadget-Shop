// Due to this class not being part of our course work, I have added comments to each line to explain them properly.
import javax.swing.*;
import java.awt.*;

// Creating a custom JTextArea with rounded corners
public class RoundedTextArea extends JTextArea {

    private Shape shape; // To hold the shape of the rounded rectangle

    public RoundedTextArea(int rows, int columns) {
        super(rows, columns); // Calling the parent class (JTextArea) constructor
        setOpaque(false); // Making the JTextArea transparent
    }

    // Overriding the paintComponent method to draw the custom rounded shape
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; // Converting or casting Graphics to Graphics2D for more control over geometry
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Enabling anti-aliasing for smoother corners
        g2d.setColor(getBackground()); // Setting the color to the background of the JTextArea
        g2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15); // Drawing the rounded rectangle filled with the background color
        super.paintComponent(g); // Calling the superclass method to ensure proper painting of text and other components
    }

    // Overriding the paintBorder method to draw the border with rounded corners
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; // Casting Graphics to Graphics2D for more control over geometry
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Enabling anti-aliasing for smoother corners
        g2d.setColor(getForeground()); // Setting the color to the foreground of the JTextArea
        g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15); // Drawing the rounded rectangle border
    }

    // Overriding the contains method to check if a given point is within the rounded rectangle
    public boolean contains(int x, int y) {
        // If the shape is null or the bounds have changed, create a new shape
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            // Creating a new RoundRectangle2D with the current dimensions and corner radius
            shape = new java.awt.geom.RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        // Checking if the given point (x, y) is within the bounds of the rounded rectangle
        return shape.contains(x, y);
    }
}
