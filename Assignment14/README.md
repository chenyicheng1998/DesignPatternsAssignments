# Assignment 14 - Computer Builder

This assignment implements the Builder design pattern for constructing different computer configurations.

## Pattern Roles

- `Computer`: product class that stores all computer components.
- `ComputerBuilder`: builder interface that defines build steps.
- `GamingComputerBuilder` and `OfficeComputerBuilder`: concrete builders for two computer types.
- `ComputerDirector`: directs the build sequence.
- `Main`: demonstrates building and printing final configurations.

## Components in `Computer`

- Processor
- RAM size (GB)
- Hard drive
- Graphics card
- Operating system
- Accessories (optional customization)

## How to Run

From the project root (`DesignPatternsAssignments`):

```powershell
mvn -pl Assignment14 -am compile
java -cp Assignment14/target/classes builder.computer.Main
```

## Example Output (shortened)

- Gaming computer with high-end parts and gaming accessories
- Office computer with balanced parts and office accessories

