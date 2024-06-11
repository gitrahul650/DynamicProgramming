package designPattern.decorator;

public class Main {

    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Simple Coffee: " + simpleCoffee.getDescription() + ", Cost: $" + simpleCoffee.getCost());
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Milk Coffee: " + milkCoffee.getDescription() + ", Cost: $" + milkCoffee.getCost());
        Coffee sugarMilkCoffee = new SugarDecorator(simpleCoffee);
        System.out.println("Sugar Milk Coffee: " + sugarMilkCoffee.getDescription() + ", Cost: $" + sugarMilkCoffee.getCost());
    }
}
