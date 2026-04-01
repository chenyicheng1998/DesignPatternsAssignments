package builder.computer;

public interface ComputerBuilder {
    void reset();
    void buildProcessor();
    void buildRAM();
    void buildHardDrive();
    void buildGraphicsCard();
    void buildOperatingSystem();
    void addAccessory(String accessory);
    Computer getComputer();
}

