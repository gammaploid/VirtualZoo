# Virtual Zoo

A simple Java console application that simulates running a virtual zoo for OOP paractice. Manage animals, give them food, water, and toys, and track their well-being and costs over a simulated week.

## Features

- Add animals (Tiger, Elephant, Rhino, Panda, Monkey) with unique names.
- Interact with each animal daily by giving food, water, or toys.
- Animals' hunger, thirst, and boredom levels change based on your actions.
- Animals can die if their needs are not met.
- Total cost of caring for the animals is tracked.

## How to Run

1. **Compile all Java files:**
    ```sh
    javac src/*.java
    ```

2. **Run the program:**
    ```sh
    java -cp src VirtualZooDriver
    ```

3. **Follow the prompts in the console to manage your zoo.**

## File Structure

- `Animal.java` - Abstract base class for all animals.
- `Tiger.java`, `Elephant.java`, `Rhino.java`, `Panda.java`, `Monkey.java` - Animal subclasses.
- `VirtualZoo.java` - Main zoo logic and simulation.
- `VirtualZooDriver.java` - Entry point for the application.

## License

This project is for educational purposes only.  
Starter files were provided by instructors at Flinders University.
Do not redistribute or use for commercial purposes.
