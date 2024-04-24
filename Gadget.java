// A class to represent a gadget
public class Gadget {
    private String model;
    private double price;
    private int weight;
    private String size;

    // Constructor to initialize the attributes
    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    // Accessor methods to get the Model values
    public String getModel() {
        return model;
    }
    // Accessor methods to get the Price values
    public double getPrice() {
        return price;
    }
    // Accessor methods to get the Weight values
    public int getWeight() {
        return weight;
    }
    // Accessor methods to get the Size values
    public String getSize() {
        return size;
    }

    // A display method to output the attribute values
    public String display() {
        StringBuilder output = new StringBuilder();
        output.append("Model: " + model + "\n");
        output.append("Price: £" + price + "\n");
        output.append("Weight: " + weight + "g" + "\n");
        output.append("Size: " + size + "\n");
        return output.toString();
    }

}
