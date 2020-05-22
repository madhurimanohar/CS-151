package hw3;

public abstract class Pizza {
    
    public abstract void pickToppings();
    public abstract void pickCrustSize();   // thin crust or regular
    
    public void makeCrust() {
        System.out.println("Making the crust");
    }

    public void addToppings() {
        System.out.println("Adding the toppings");
    }

    public void preHeatOven() {
        System.out.println("Preheating the oven");
    }
    
    public void cook() {
        System.out.println("Cooking the pizza");
    }

    public final void makeFromScratch() {
        pickToppings();
        pickCrustSize();
        makeCrust();
        addToppings();
        preHeatOven();
        cook();
    }
}