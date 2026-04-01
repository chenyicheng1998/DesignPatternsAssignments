package builder.computer;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String processor;
    private int ramSizeGb;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;
    private final List<String> accessories;

    public Computer() {
        this.accessories = new ArrayList<>();
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRamSizeGb(int ramSizeGb) {
        this.ramSizeGb = ramSizeGb;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void addAccessory(String accessory) {
        this.accessories.add(accessory);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Processor: ").append(processor).append("\n");
        result.append("RAM: ").append(ramSizeGb).append(" GB\n");
        result.append("Hard drive: ").append(hardDrive).append("\n");
        result.append("Graphics card: ").append(graphicsCard).append("\n");
        result.append("Operating system: ").append(operatingSystem).append("\n");

        if (accessories.isEmpty()) {
            result.append("Accessories: None\n");
        } else {
            result.append("Accessories: ").append(String.join(", ", accessories)).append("\n");
        }

        return result.toString();
    }
}

