class Monkey extends Animal{ // Child class of parent class Animal

     /**
     * Child class constructor
     */
    public Monkey(String name) {
        super(name, "Monkey");
    }


     /**
     * giveFood(), giveWater(), giveToy() overriden child class methods
     */
    @Override
    public void giveFood() {
        setHunger(Math.max(0, hunger - 30));
        setThirst(Math.max(0, thirst + 10));
        setBoredom(Math.max(0, boredom + 10));
        setTotalCost(Math.max(0, totalCost + 5 ));
    }

    @Override
    public void giveWater() {
        setHunger(Math.max(0, hunger + 10));
        setThirst(Math.max(0, thirst - 40));
        setBoredom(Math.max(0, boredom + 10));
        setTotalCost(Math.max(0, totalCost + 5 ));
    }

    @Override
    public void giveToy() {
        setHunger(Math.max(0, hunger + 10));
        setThirst(Math.max(0, thirst + 10));
        setBoredom(Math.max(0, boredom - 15));
        setTotalCost(Math.max(0, totalCost + 15 ));
    }
}

