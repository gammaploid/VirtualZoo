class Panda extends Animal{ // Child class of parent class Animal

     /**
     * Child class constructor
     */
    public Panda(String name) {
        super(name, "Panda");
    }


     /**
     * giveFood(), giveWater(), giveToy() overriden child class methods
     */
    @Override
    public void giveFood() {
        setHunger(Math.max(0, hunger - 25));
        setThirst(Math.max(0, thirst + 15));
        setBoredom(Math.max(0, boredom + 15));
        setTotalCost(Math.max(0, totalCost + 60 ));
    }

    @Override
    public void giveWater() {
        setHunger(Math.max(0, hunger + 40));
        setThirst(Math.max(0, thirst - 80));
        setBoredom(Math.max(0, boredom + 10));
        setTotalCost(Math.max(0, totalCost + 5 ));
    }

    @Override
    public void giveToy() {
        setHunger(Math.max(0, hunger + 40));
        setThirst(Math.max(0, thirst + 15));
        setBoredom(Math.max(0, boredom - 40));
        setTotalCost(Math.max(0, totalCost + 10 ));
    }
}

