package designPattern.builder;

public class DesktopBuilder extends ComputerBuilder {
 @Override
 public void buildMotherboard() {
        computer.setMotherboard("Standard Desktop Motherboard");
    }
 @Override
 public void buildProcessor() {
        computer.setProcessor("Intel Core i5");
    }
 @Override
 public void buildMemory() {
        computer.setMemory("8GB DDR4 RAM");
    }
 @Override
 public void buildStorage() {
        computer.setStorage("256GB SSD");
    }
 }