class Elephant extends Animal{ // Child class of parent class Animal

     /**
     * Child class constructor
     */
    public Elephant(String name) {
        super(name, "Elephant");
    }


     /**
     * giveFood(), giveWater(), giveToy() overriden child class methods
     */
    @Override
    public void giveFood() {
        setHunger(Math.max(0, hunger - 50));
        setThirst(Math.max(0, thirst + 30));
        setBoredom(Math.max(0, boredom + 20));
        setTotalCost(Math.max(0, totalCost + 100 ));
    }

    @Override
    public void giveWater() {
        setHunger(Math.max(0, hunger + 20));
        setThirst(Math.max(0, thirst - 50));
        setBoredom(Math.max(0, boredom + 30));
        setTotalCost(Math.max(0, totalCost + 40 ));
    }

    @Override
    public void giveToy() {
        setHunger(Math.max(0, hunger + 30));
        setThirst(Math.max(0, thirst + 10));
        setBoredom(Math.max(0, boredom - 40));
        setTotalCost(Math.max(0, totalCost + 75 ));
    }
}

