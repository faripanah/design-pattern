// Concrete Builder for Office Computer
public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("Intel Core i5 Processor"));
    }

    @Override
    public void buildRAM() {
        computer.addComponent(new Component("16 GB DDR4 RAM"));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("512 GB SSD"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addComponent(new Component("Integrated Intel UHD Graphics"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("Windows 11 Home"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
