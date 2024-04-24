// A class to represent an MP3 player, which is a subclass of the gadget class
public class MP3 extends Gadget {
    private int memory;

    // initializing the constructor
    public MP3(String model, double price, int weight, String size, int memory) {
        super(model, price, weight, size);
        this.memory = memory;
    }

    // An accessor method to get the memory value
    public int getMemory() {
        return memory;
    }

    // A method to download music to the MP3 player
    public void downloadMusic(int size) {
        if (memory >= size) {
            memory -= size;
            System.out.println("You have downloaded " + size + "MB of music to your MP3 player.");
        } else {
            System.out.println("You do not have enough memory to download this music.");
        }
    }

    // A method to delete music from the MP3 player
    public void deleteMusic(int size) {
        memory += size;
        System.out.println("You have deleted " + size + "MB of music from your MP3 player.");
    }

    // A method to display the details of the MP3 player, which overrides the display method in the gadget class
    @Override
    public String display() {
        StringBuilder output = new StringBuilder();
        output.append(super.display());
        output.append("Memory: " + memory + "MB" + "\n");
        return output.toString();
    }
}
