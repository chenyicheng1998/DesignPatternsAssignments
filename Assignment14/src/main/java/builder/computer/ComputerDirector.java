package builder.computer;

import java.util.List;

public class ComputerDirector {
    private final ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer constructComputer() {
        builder.reset();
        builder.buildProcessor();
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildGraphicsCard();
        builder.buildOperatingSystem();
        return builder.getComputer();
    }

    public Computer constructComputerWithAccessories(List<String> accessories) {
        Computer computer = constructComputer();
        for (String accessory : accessories) {
            builder.addAccessory(accessory);
        }
        return computer;
    }
}

