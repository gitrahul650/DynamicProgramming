package designPattern.builder;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        ComputerBuilder desktopBuilder = new DesktopBuilder();
        director.setComputerBuilder(desktopBuilder);
        Computer desktop = director.buildComputer();
        ComputerBuilder laptopBuilder = new LaptopBuilder();
        director.setComputerBuilder(laptopBuilder);
        Computer laptop = director.buildComputer();
        System.out.println(desktop);
        System.out.println(laptop);
    }
}
 