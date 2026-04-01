package builder.computer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector gamingDirector = new ComputerDirector(gamingBuilder);

        Computer gamingComputer = gamingDirector.constructComputerWithAccessories(
                List.of("Mechanical keyboard", "Gaming mouse", "RGB headset")
        );

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector officeDirector = new ComputerDirector(officeBuilder);

        Computer officeComputer = officeDirector.constructComputerWithAccessories(
                List.of("Webcam", "Wireless keyboard")
        );

        System.out.println("=== Gaming Computer ===");
        System.out.println(gamingComputer);

        System.out.println("=== Office Computer ===");
        System.out.println(officeComputer);
    }
}

