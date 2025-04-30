import java.util.Scanner;

abstract class Animal { /* Abstract parent class Animals, 5 child classes (Tiger, Elephant,
                         Rhino, Monkey, Panda) have dependency on Animal.java  */

    protected static int totalCost = 1000; // Total cost initiated at 1000, as per specifications.
    private String name;
    private String species;
    protected int hunger = 50;
    protected int thirst = 50;
    protected int boredom = 50;

    protected String previousItem = ""; // stores previous entered item (Food, Water,Toy)
    private boolean diedMessagePrinted = false;  // boolean for status of animal has died message print

    /**
     * Abstract giveFood(), giveWater(), giveToy() methods for implementation by subclasses
     */
    abstract void giveFood();

    abstract void giveWater();

    abstract void giveToy();

    /**
     * Parent class Animal() constructor, takes in (String name, String species)
     */
    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    /**
     * Getter methods
     */

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getBoredom() {
        return boredom;
    }

    public String getPreviousItem() {
        return previousItem;
    }

    public boolean isDead() {
        return hunger > 100 || thirst > 100 || boredom > 100; // Boolean check if animal isDead()
    }


    public static int getTotalCost() {
        return totalCost;
    }

    /**
     * Setter methods
     */

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public void setBoredom(int boredom) {
        this.boredom = boredom;
    }

    public void setPreviousItem(String previousItem) {
        this.previousItem = previousItem;
    }

    public void setDiedMessagePrinted(boolean diedMessagePrinted) { // sets hadDiedMessage printed true/false
        this.diedMessagePrinted = diedMessagePrinted;
    }

    public static void setTotalCost(int totalCost) {
        Animal.totalCost = totalCost;
    }

    /**
     * toString() method
     */

    @Override
    public String toString() {
        String statusMessage = isDead() ? "Name = " + getName() + " (Dead)\n" : "Name = " + getName() + "\n";
        statusMessage += "Species = " + getSpecies() + "\n";
        statusMessage += "Hunger = " + getHunger() + "\n";
        statusMessage += "Thirst = " + getThirst() + "\n";
        statusMessage += "Boredom = " + getBoredom() + "\n";
        return statusMessage;
    }

}


