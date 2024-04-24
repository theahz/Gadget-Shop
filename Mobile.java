// A class to represent a mobile phone, which is a subclass of the gadget class
public class Mobile extends Gadget {
    private int minutes;

    // Initializing  the constructor
    public Mobile(String model, double price, int weight, String size, int minutes) {
        super(model, price, weight, size);
        this.minutes = minutes;
    }

    // An accessor method to get the minutes value
    public int getMinutes() {
        return minutes;
    }

    // A method to add calling credit to the mobile
    public void addCredit(int amount) {
        if (amount > 0) {
            minutes += amount;
            System.out.println("You have added £" + amount + " to your calling credit.");
        } else {
            System.out.println("Please enter a positive amount to add to your calling credit.");
        }
    }

    // A method to represent the user making a phone call
    public void makeCall(String number, int duration) {
        if (minutes >= duration) {
            System.out.println("You have made a call to " + number + " for " + duration + " minutes.");
            minutes -= duration;
        } else {
            System.out.println("You do not have enough credit to make this call.");
        }
    }

    // A method to display the details of the mobile, which overrides the display method in the gadget class
    @Override
    public String display() {
        StringBuilder output = new StringBuilder();
        output.append(super.display());
        output.append("Credit: " + minutes + " minutes" + "\n");
        return output.toString();
    }

}
