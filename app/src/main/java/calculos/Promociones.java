package calculos;

public class Promociones {
    private int Pizzapromo;
    private int Masterpizza;
    private int PizzaMax;

    public  Promociones()
    {
        Pizzapromo = 5990;
        Masterpizza= 12990;
        PizzaMax= 18500;
    }

    public int getPizzapromo() {
        return Pizzapromo;
    }

    public int getMasterpizza() {
        return Masterpizza;
    }

    public int getPizzaMax() {
        return PizzaMax;
    }
}
