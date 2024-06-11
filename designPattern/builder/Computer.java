package designPattern.builder;

public class Computer {
    private String motherboard;
    private String processor;
    private String memory;
    private String storage;

    public Computer(String motherboard, String processor, String memory, String storage) {
        this.motherboard
                = motherboard;
        this.processor = processor;
        this.memory = memory;
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "motherboard='" + motherboard + '\'' +
                ", processor='" + processor + '\'' +
                ", memory='" + memory + '\'' +
                ", storage='" + storage + '\'' +
                '}';
    }

    public Computer() {

    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public Computer(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }
}
