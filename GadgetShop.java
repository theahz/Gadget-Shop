// A class to represent the GUI for the gadget shop
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GadgetShop implements ActionListener {

    // Attributes for the GUI components
    private JFrame frame;
    private RoundedTextField modelTextField;
    private RoundedTextField priceTextField;
    private RoundedTextField weightTextField;
    private RoundedTextField sizeTextField;
    private RoundedTextField creditTextField;
    private RoundedTextField memoryTextField;
    private RoundedTextField numberTextField;
    private RoundedTextField durationTextField;
    private RoundedTextField downloadTextField;
    private RoundedTextField displayTextField;
    private RoundedTextArea resultTextArea;
    private RoundedButton addMobileButton;
    private RoundedButton addMP3Button;
    private RoundedButton clearButton;
    private RoundedButton displayAllButton;
    private RoundedButton makeCallButton;
    private RoundedButton downloadMusicButton;

    // An attribute to store an array list of gadgets
    private ArrayList<Gadget> gadgets;

    // A constructor to initialize the attributes and create the GUI
    public GadgetShop() {
        // Creating a new array list of gadgets
        gadgets = new ArrayList<Gadget>();
        frame = new JFrame("Gadget Shop");
        // Setting the size and layout of the frame
        frame.setSize(850, 750);
        frame.setLayout(new BorderLayout());

        // Set colors
        Color backgroundColor = new Color(240, 240, 240); 
        Color buttonColor = new Color(200, 200, 200); 
        Color textColor = new Color(50, 50, 50);
        
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new GridLayout(12, 2));
        panelNorth.setBackground(backgroundColor);
        frame.getContentPane().add(panelNorth, "North");
        
        JLabel modelLabel = new JLabel("Model");
        panelNorth.add(modelLabel);
        modelTextField = new RoundedTextField(15);
        panelNorth.add(modelTextField);
        
        JLabel priceLabel = new JLabel("Price");
        panelNorth.add(priceLabel);
        priceTextField = new RoundedTextField(15);
        panelNorth.add(priceTextField);
        
        JLabel weightLabel = new JLabel("Weight");
        panelNorth.add(weightLabel);
        weightTextField = new RoundedTextField(15);
        panelNorth.add(weightTextField);

        JLabel sizeLabel = new JLabel("Size");
        panelNorth.add(sizeLabel);
        sizeTextField = new RoundedTextField(15);
        panelNorth.add(sizeTextField);

        JLabel creditLabel = new JLabel("Credit");
        panelNorth.add(creditLabel);
        creditTextField = new RoundedTextField(15);
        panelNorth.add(creditTextField);

        JLabel memoryLabel = new JLabel("Memory");
        panelNorth.add(memoryLabel);
        memoryTextField = new RoundedTextField(15);
        panelNorth.add(memoryTextField);

        JLabel displayLabel = new JLabel("Display Number");
        panelNorth.add(displayLabel);
        displayTextField = new RoundedTextField(15);
        panelNorth.add(displayTextField);

        JLabel numberLabel = new JLabel("Phone Number");
        panelNorth.add(numberLabel);
        numberTextField = new RoundedTextField(15);
        panelNorth.add(numberTextField);

        JLabel durationLabel = new JLabel("Duration");
        panelNorth.add(durationLabel);
        durationTextField = new RoundedTextField(15);
        panelNorth.add(durationTextField);

        JLabel downloadLabel = new JLabel("Download Size");
        panelNorth.add(downloadLabel);
        downloadTextField = new RoundedTextField(15);
        panelNorth.add(downloadTextField);

        JPanel panelWest = new JPanel();
        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
        panelWest.setBackground(new Color(240, 240, 240));
        frame.getContentPane().add(panelWest, "West");

        addMobileButton = new RoundedButton("Add Mobile");
        panelWest.add(addMobileButton);
        addMobileButton.addActionListener(this);

        addMP3Button = new RoundedButton("Add MP3");
        panelWest.add(addMP3Button);
        addMP3Button.addActionListener(this);

        clearButton = new RoundedButton("Clear");
        panelWest.add(clearButton);
        clearButton.addActionListener(this);

        displayAllButton = new RoundedButton("Display All");
        panelWest.add(displayAllButton);
        displayAllButton.addActionListener(this);

        makeCallButton = new RoundedButton("Make A Call");
        panelWest.add(makeCallButton);
        makeCallButton.addActionListener(this);

        downloadMusicButton = new RoundedButton("Download Music");
        panelWest.add(downloadMusicButton);
        downloadMusicButton.addActionListener(this);

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        panelCenter.setBackground(new Color(240, 200, 240));
        frame.getContentPane().add(panelCenter, "Center");

        JLabel resultLabel = new JLabel("Result");
        panelCenter.add(resultLabel);
        resultTextArea = new RoundedTextArea(10, 20);
        resultTextArea.setFont(new Font("Monaco", Font.PLAIN, 20));
        panelCenter.add(resultTextArea);
        
        //because we are setting the size of the application manually, frame.pack is not needed
        // Centralizing the application
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    // A main method to create an object of the GadgetShop class
    public static void main(String[] args) {
        GadgetShop shop = new GadgetShop();
    }

    // A method to handle the action events from the buttons
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        try {
            if (command.equals("Add Mobile")) {
                addMobile();
            } else if (command.equals("Add MP3")) {
                addMP3();
            } else if (command.equals("Clear")) {
                clear();
            } else if (command.equals("Display All")) {
                displayAll();
            } else if (command.equals("Make A Call")) {
                makeCall();
            } else if (command.equals("Download Music")) {
                downloadMusic();
            }
        } catch (NumberFormatException e) {
            resultTextArea.setText("Error: " + e.getMessage());
        }
    }

    // A method to get the model from the text field and return it as a string
    public String getModel() {
        return modelTextField.getText();
    }

    // A method to get the price from the text field and return it as a double using catch and try
    public double getPrice() {
        String priceText = priceTextField.getText();
        try {
            return Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Price must be a valid double value.");
        }
    }
    // A method to get the weight from the text field and return it as an int using catch and try
    public int getWeight() {
        String weightText = weightTextField.getText();
        try {
            return Integer.parseInt(weightText);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Weight must be a valid integer value.");
        }
    }

    // A method to get the size from the text field and return it as a string
    public String getSize() {
        return sizeTextField.getText();
    }

    // A method to get the credit from the text field and return it as an int using catch and try
    public int getCredit() {
        String creditText = creditTextField.getText();
        try {
            return Integer.parseInt(creditText);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Credit must be a valid integer value.");
        }
    }

    // A method to get the memory from the text field and return it as an int using catch and try
    public int getMemory() {
        String memoryText = memoryTextField.getText();
        try {
            return Integer.parseInt(memoryText);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Memory must be a valid integer value.");
        }
    }

    // A method to get the phone number from the text field and return it as a string
    public String getNumber() {
        return numberTextField.getText();
    }
    // A method to get the duration from the text field and return it as an int using catch and try
    public int getDuration() {
        String durationText = durationTextField.getText();
        try {
            return Integer.parseInt(durationText);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Duration must be a valid integer value.");
        }
    }

    // A method to get the download size from the text field and return it as an int using catch and try
    public int getDownload() {
        String downloadText = downloadTextField.getText();
        try {
            return Integer.parseInt(downloadText);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Download size must be a valid integer value.");
        }
    }

    // A method to get the display number from the text field and return it as an int
    public int getDisplay() {
        int display = -1;
        String displayText = displayTextField.getText();
        try {
            display = Integer.parseInt(displayText);
            if (display < 0 || display >= gadgets.size()) {
                JOptionPane.showMessageDialog(frame, "The display number must be 0 or higher" , "Error", JOptionPane.ERROR_MESSAGE);
                display = -1;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "The display number must be an integer", "Error", JOptionPane.ERROR_MESSAGE);
        }
        // Returning the display number
        return display;
    }

    // A method to add a mobile phone to the array list of gadgets
    public void addMobile() {
        String model = getModel();
        if (model.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Model cannot be empty. Please enter a model name.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method without adding the mobile
        }
        double price = getPrice();
        int weight = getWeight();
        String size = getSize();
        int credit = getCredit();
        Mobile mobile = new Mobile(model, price, weight, size, credit);
        gadgets.add(mobile);
        resultTextArea.setText("You have added a mobile phone to the gadget shop.");
    }

    // A method to add an MP3 player to the array list of gadgets
    public void addMP3() {
        String model = getModel();
        if (model.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Model cannot be empty. Please enter a model name.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method without adding the mp3
        }
        double price = getPrice();
        int weight = getWeight();
        String size = getSize();
        int memory = getMemory();
        MP3 mp3 = new MP3(model, price, weight, size, memory);
        gadgets.add(mp3);
        resultTextArea.setText("You have added an MP3 player to the gadget shop.");
    }

    // A method to clear the text from the text fields and the text area
    public void clear() {
        // Setting the text of each text field and the text area to an empty string
        modelTextField.setText("");
        priceTextField.setText("");
        weightTextField.setText("");
        sizeTextField.setText("");
        creditTextField.setText("");
        memoryTextField.setText("");
        numberTextField.setText("");
        durationTextField.setText("");
        downloadTextField.setText("");
        displayTextField.setText("");
        resultTextArea.setText("");
    }

    // A method to display the details of all the gadgets in the array list
    public void displayAll() {
        StringBuilder result = new StringBuilder();
        // Looping through the array list of gadgets
        for (int i = 0; i < gadgets.size(); i++) {
            Gadget gadget = gadgets.get(i);
            result.append("Display Number: " + i + "\n");
            result.append(gadget.display() + "\n");
            result.append("------------------------------\n");
        }
        resultTextArea.setText(result.toString());
    }

    // A method to make a call using a mobile phone from the array list of gadgets
    public void makeCall() {
        int display = getDisplay();
        String number = getNumber();
        int duration = getDuration();
        // Checking if the display number is not equal to -1
        if (display != -1) {
            Mobile mobile = (Mobile) gadgets.get(display);
            mobile.makeCall(number, duration);
            resultTextArea.setText("You have made a call using the mobile phone at display number " + display + ".");
        }
    }

    // A method to download music to an MP3 player from the array list of gadgets
    public void downloadMusic() {
        int display = getDisplay();
        int download = getDownload();
        // Checking if the display number is not equal to -1
        if (display != -1) {
            MP3 mp3 = (MP3) gadgets.get(display);
            mp3.downloadMusic(download);
            resultTextArea.setText("You have downloaded music to the MP3 player at display number " + display + ".");
        }
    }
}

