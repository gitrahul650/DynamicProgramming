package designPattern.builder;

public class LaptopBuilder extends ComputerBuilder {
 @Override
 public void buildMotherboard() {
        computer.setMotherboard("Laptop Motherboard");
    }
 @Override
 public void buildProcessor() {
        computer.setProcessor("Intel Core i7");
    }
 @Override
 public void buildMemory() {
        computer.setMemory("16GB DDR4 RAM");
    }
 @Override
 public void buildStorage() {
        computer.setStorage("512GB NVMe SSD");
    }
 }