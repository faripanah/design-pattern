// Concrete Builder for Gaming Computer
public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("Intel Core i9 Processor"));
    }

    @Override
    public void buildRAM() {
        computer.addComponent(new Component("32 GB DDR5 RAM"));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("1 TB NVMe SSD"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addComponent(new Component("NVIDIA GeForce RTX 4090"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("Windows 11 Pro"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
