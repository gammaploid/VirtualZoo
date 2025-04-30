import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Hassan 
 */
public class VirtualZoo {

    private final Scanner scan;
    private static ArrayList<String> animalNames = new ArrayList<>();
    private ArrayList<Animal> allZooAnimals = new ArrayList<>();

     /**
     * Class constructor
     */
    public VirtualZoo() {
        scan = new Scanner(System.in);
    }

    public void beginSimulation() {
        displayWelcome();
        ArrayList<Animal> zooAnimals = animalSelection();
        weekCycle(zooAnimals);
    }

    //-----------------------------------------operational methods-----------------------------------------//

     /**
     * Defines the Welcome Message text
     */
    private void displayWelcome() {
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                     Welcome to the Virtual Zoo!                      |");
        System.out.println("|   Use this application to simulate running a zoo with many animals   |");
        System.out.println("|           This program is intended for zoo employees only            |");
        System.out.println("+----------------------------------------------------------------------+");
    }

       /**
       * askNumberAnimals() method, prompts a question to input number of animals and returns
       * entered value in numAnimals. Method rejects non integer inputs and negative integers using a do-while
       * and if conditional.
       */
    public int askNumberAnimals() {
        int numAnimals;
        do {
            System.out.println("How many animals are at your zoo?");
            while (!scan.hasNextInt()) {
                System.out.println("Please enter a valid number of animals");
                scan.next();
            }
            numAnimals = scan.nextInt();
            scan.nextLine();
            if (numAnimals < 0) {
                System.out.println("Please enter a positive number of animals");
            }
            System.out.println();
        } while (numAnimals < 0);
        return numAnimals;
    }

     /**
     * askAnimalName() method, takes in (int id) parameter prompts a question to input animal name, and returns
     * entered value in animalName. Method rejects already used names by storing them using
     * animalNames.add(animalName) array, by looping through array checking conditions, is empty or name taken.
     */
    public String askAnimalName(int id) {
        String animalName = "";

        while (animalName.isEmpty() || animalNames.contains(animalName)) {
            System.out.println("What is the name of animal #" + id + "?");
            animalName = scan.nextLine();
            if (animalNames.contains(animalName)) {
                System.out.println("That name is already taken");
            }
        }

        animalNames.add(animalName);
        return animalName;
    }

      /**
      * isValidSpecies() boolean helper method for askAnimalSpecies(), takes in (String species) to check entered
      * species is of the listed one and returns true if species.equals() entry.
      */
    private boolean isValidSpecies(String species) {
        species = species.toLowerCase();
        return species.equals("tiger") || species.equals("elephant") || species.equals("rhino") ||
                species.equals("panda") || species.equals("monkey");
    }

      /**
      * askAnimalSpecies() Animal object method, takes in (String name) of animal
      * and prompts a question about species type, checks validity of entered species with helper isValidSpecies()
      * using a while loop boolean condition and null entry.
      * Method uses a switch to instantiate species subclass objcet with animal name parameter from parent constructor
      */
    public Animal askAnimalSpecies(String name) {
        String species = "";
        while (!isValidSpecies(species)) {
            System.out.println("What is the species of " + name + "?");
            species = scan.nextLine().toLowerCase();
            if (!isValidSpecies(species) && species != "") {
                System.out.println("That is not a valid species");
            }
        }
        species = species.substring(0, 1).toUpperCase() + species.substring(1).toLowerCase();
        switch (species) {
            case "Tiger":
                return new Tiger(name);
            case "Elephant":
                return new Elephant(name);
            case "Rhino":
                return new Rhino(name);
            case "Panda":
                return new Panda(name);
            case "Monkey":
                return new Monkey(name);
            default:
                throw new IllegalArgumentException("That is not a valid species");
        }
    }

     /**
     * ArrayList<Animals> which calls animalSelection() calling askAnimalName()
     * and instantiating Animal objects using askAnimalSpecies(), using for-loop < numAnimals,
     * and finally adding new Animal instances into the ArrayList allZooAnimals
     */

    public ArrayList<Animal> animalSelection() {
        ArrayList<Animal> allZooAnimals = new ArrayList<>();

        int numAnimals = askNumberAnimals();

        for (int i = 0; i < numAnimals; i++) {
            String animalName = askAnimalName(i + 1);
            Animal newAnimal = askAnimalSpecies(animalName);
            allZooAnimals.add(newAnimal);
        }

        return allZooAnimals;
    }

     /**
     * askItem() method, which takes in (Animal animal), prompts user with item to give animal, and checks entered
     * item using a switch if entry is legal item, the switch contains conditionals checking validity of item and
     * wither item was given yesterday. If item is legal it calls animal.giveFood(), animal.giveToy(),
     * animal.giveWater() methods in the respective species subclass, using a so-while loop.
     * checks status of animal isDead() to print it using animal.setDiedMessagePrinted.
     */
     public void askItem(Animal animal) {
         String item;
         boolean validItem;

         System.out.println("What item would you like to give to " + animal.getName() + "?");
         do {
             item = scan.nextLine().toLowerCase();
             validItem = true;

             switch (item) {
                 case "food":
                     if (animal.getPreviousItem().equals("food")) {
                         validItem = false;
                         System.out.println("You cannot give the same item as yesterday.");
                     } else {
                         animal.giveFood();
                     }
                     break;
                 case "toy":
                     if (animal.getPreviousItem().equals("toy")) {
                         validItem = false;
                         System.out.println("You cannot give the same item as yesterday.");
                     } else {
                         animal.giveToy();
                     }
                     break;
                 case "water":
                     if (animal.getPreviousItem().equals("water")) {
                         validItem = false;
                         System.out.println("You cannot give the same item as yesterday.");
                     } else {
                         animal.giveWater();
                     }
                     break;
                 default:
                     validItem = false;
                     System.out.println("That is not a valid item");
                     System.out.println("What item would you like to give to " + animal.getName() + "?");
                     break;
             }

             if (validItem) {
                 animal.setPreviousItem(item);
             }
         } while (!validItem);

         if (animal.isDead()) {
             System.out.println(animal.getName() + " has died");
             animal.setDiedMessagePrinted(true);
         }
     }


    /**
       * weekCycle() method, takes in (ArrayList<Animal> zooAnimals) and iterates through daysOfWeek array,
       * it prints current day and prints amimal.toString of each animal using zooAnimals.forEach array method,
       * and checks status of animal isDead() to label animal state, and prints total cost at end of week cycle.
       */
    public void weekCycle(ArrayList<Animal> zooAnimals) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (int day = 0; day < 7; day++) {
            System.out.println("The current day is " + daysOfWeek[day]);
            System.out.println();
            zooAnimals.forEach(animal -> System.out.println(animal.toString()));

            for (Animal animal : zooAnimals) {
                if (!animal.isDead()) {
                    askItem(animal);
                }
            }

        }
        System.out.println();
        System.out.println("Total week cost = $" + Animal.getTotalCost());
    }


}





