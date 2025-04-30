class Rhino extends Animal{// Child class of parent class Animal


     /**
     * Child class constructor
     */
    public Rhino(String name) {
        super(name, "Rhino");
    }


     /**
     * giveFood(), giveWater(), giveToy() overriden child class methods
     */
    @Override
    public void giveFood() {
        setHunger(Math.max(0, hunger - 25));
        setThirst(Math.max(0, thirst + 5));
        setBoredom(Math.max(0, boredom + 25));
        setTotalCost(Math.max(0, totalCost + 50 ));
    }

    @Override
    public void giveWater() {
        setHunger(Math.max(0, hunger + 5));
        setThirst(Math.max(0, thirst - 25));
        setBoredom(Math.max(0, boredom + 25));
        setTotalCost(Math.max(0, totalCost + 50 ));
    }

    @Override
    public void giveToy() {
        setHunger(Math.max(0, hunger + 20));
        setThirst(Math.max(0, thirst + 20));
        setBoredom(Math.max(0, boredom - 50));
        setTotalCost(Math.max(0, totalCost + 20 ));
    }
}

