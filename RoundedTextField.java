// Due to this class not being part of our course work, I have added comments to each line to explain them properly.
import javax.swing.*;
import java.awt.*;

// This class extends JTextField to create a text field with rounded corners.
public class RoundedTextField extends JTextField {

    // Shape used to define the rounded rectangle boundary of the text field.
    private Shape shape;

    public RoundedTextField(int size) {
        super(size); // Calls the constructor of the superclass (JTextField) with the size parameter.
        setOpaque(false); // Makes the text field non-opaque, which allows us to paint a custom background.
    }

    // Overridden method from JComponent to handle the painting of the text field's components.
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; // Converting or casting the Graphics object to Graphics2D for more advanced operations.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Enables anti-aliasing to smooth out the edges of the shapes.
        g2d.setColor(getBackground()); // Sets the color to the background color of the text field.
        g2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15); // Fills a rounded rectangle with the current color.
        super.paintComponent(g); // Calls the superclass method to ensure proper painting of text field components.
    }

    // Overridden method to paint the border of the text field with rounded corners.
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; // Converting or casting the Graphics object to Graphics2D for more advanced operations.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Enables anti-aliasing to smooth out the edges of the shapes.
        g2d.setColor(getForeground()); // Sets the color to the foreground color of the text field.
        g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15); // Draws a rounded rectangle outline with the current color.
    }

    // Overridden method to determine if a given point is within the bounds of the rounded rectangle.
    public boolean contains(int x, int y) {
        // Checks if the shape is null or if the bounds have changed.
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            // Creates a new rounded rectangle shape with the current dimensions.
            shape = new java.awt.geom.RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        // Returns true if the point (x, y) is within the bounds of the rounded rectangle.
        return shape.contains(x, y);
    }
}
