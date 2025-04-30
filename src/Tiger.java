
class Tiger extends Animal{   // Child class of parent class Animal

     /**
     * Child class constructor
     */
    public Tiger(String name) {
        super(name, "Tiger");
    }


     /**
     * giveFood(), giveWater(), giveToy() overriden child class methods
     */
    @Override
    public void giveFood() {
        setHunger(Math.max(0, hunger - 30));
        setThirst(Math.max(0, thirst + 15));
        setBoredom(Math.max(0, boredom + 15));
        setTotalCost(Math.max(0, totalCost + 30 ));

    }

    @Override
    public void giveWater() {
        setHunger(Math.max(0, hunger + 15));
        setThirst(Math.max(0, thirst - 30));
        setBoredom(Math.max(0, boredom + 15));
        setTotalCost(Math.max(0, totalCost + 20 ));
    }

    @Override
    public void giveToy() {
        setHunger(Math.max(0, hunger + 15));
        setThirst(Math.max(0, thirst + 15));
        setBoredom(Math.max(0, boredom - 30));
        setTotalCost(Math.max(0, totalCost + 40 ));
    }
}

