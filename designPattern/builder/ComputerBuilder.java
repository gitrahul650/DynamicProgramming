package designPattern.builder;

public abstract class ComputerBuilder {

    protected Computer computer;
    public void createComputer() {
        computer = new Computer();
    }
    public abstract void buildMotherboard();
    public abstract void buildProcessor();
    public abstract void buildMemory();
    public abstract void buildStorage();
    public Computer getComputer() {
        return computer;
    }
}
