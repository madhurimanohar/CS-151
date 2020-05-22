package hw3;

public class CaliforniaStylePizza extends Pizza {
    
    @Override
    public void pickToppings() {
        System.out.println("Picking the toppings for the California Style Pizza");
    }

    @Override
    public void pickCrustSize() {
        System.out.println("Picking the crust size for the California Style Pizza");
    }
}
