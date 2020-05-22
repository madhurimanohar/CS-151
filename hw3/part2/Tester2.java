package hw3;

public class Tester2 {
    public static void main(String[] args) {        
        ChicagoStylePizza firstPizza = new ChicagoStylePizza();
        firstPizza.makeFromScratch();
        
        System.out.println("");
        
        CaliforniaStylePizza secondPizza = new CaliforniaStylePizza();
        secondPizza.makeFromScratch();
        
        System.out.println("");
        
        NewYorkStylePizza thirdPizza = new NewYorkStylePizza();
        thirdPizza.makeFromScratch();
    }
}