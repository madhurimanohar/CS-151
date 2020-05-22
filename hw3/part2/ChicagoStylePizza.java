package hw3;

public class ChicagoStylePizza extends Pizza {

    @Override
    public void pickToppings() {
        System.out.println("Picking the toppings for the Chicago Style Pizza");
    }

    @Override
    public void pickCrustSize() {
        System.out.println("Picking the crust size for the Chicago Style Pizza");
    }
}
