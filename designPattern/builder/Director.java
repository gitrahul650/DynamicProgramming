package designPattern.builder;

public class Director {
    private ComputerBuilder computerBuilder;

    public void setComputerBuilder(ComputerBuilder builder) {
        computerBuilder = builder;
    }
    public Computer buildComputer() {
        computerBuilder.createComputer();
        computerBuilder.buildMotherboard();
        computerBuilder.buildProcessor();
        computerBuilder.buildMemory();
        computerBuilder.buildStorage();
        return computerBuilder.getComputer();
    }
}