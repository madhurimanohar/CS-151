package hw3;

public class NewYorkStylePizza extends Pizza {

    @Override
    public void pickToppings() {
        System.out.println("Picking the toppings for the New York Style Pizza");
    }

    @Override
    public void pickCrustSize() {
        System.out.println("Picking the crust size for the New York Style Pizza");
    }
}
