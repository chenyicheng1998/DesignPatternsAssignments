/**
 * Main class to demonstrate the Organization Structure using Composite pattern.
 * Creates a sample organization with departments and employees,
 * and demonstrates the key functionality.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Organization Structure - Composite Pattern Demo");
        System.out.println("========================================\n");

        // Create the organization structure

        // Root department - the entire organization
        Department company = new Department("TechCorp");

        // Create main departments
        Department engineering = new Department("Engineering");
        Department sales = new Department("Sales");
        Department hr = new Department("Human Resources");

        // Create sub-departments within Engineering
        Department softwareDev = new Department("Software Development");
        Department qa = new Department("Quality Assurance");

        // Create employees for Software Development
        Employee dev1 = new Employee("Alice Johnson", 85000);
        Employee dev2 = new Employee("Bob Smith", 90000);
        Employee dev3 = new Employee("Carol White", 95000);

        // Create employees for QA
        Employee qa1 = new Employee("David Brown", 70000);
        Employee qa2 = new Employee("Eve Davis", 72000);

        // Create employees for Sales
        Employee sales1 = new Employee("Frank Miller", 65000);
        Employee sales2 = new Employee("Grace Wilson", 68000);
        Employee sales3 = new Employee("Henry Taylor", 71000);

        // Create employees for HR
        Employee hr1 = new Employee("Iris Anderson", 62000);
        Employee hr2 = new Employee("Jack Thomas", 64000);

        // Build the organization structure

        // Add employees to Software Development
        softwareDev.add(dev1);
        softwareDev.add(dev2);
        softwareDev.add(dev3);

        // Add employees to QA
        qa.add(qa1);
        qa.add(qa2);

        // Add sub-departments to Engineering
        engineering.add(softwareDev);
        engineering.add(qa);

        // Add employees to Sales
        sales.add(sales1);
        sales.add(sales2);
        sales.add(sales3);

        // Add employees to HR
        hr.add(hr1);
        hr.add(hr2);

        // Add main departments to company
        company.add(engineering);
        company.add(sales);
        company.add(hr);

        // Demonstrate functionality

        System.out.println("=== Organization Structure in XML Format ===\n");
        company.printXML(0);

        System.out.println("\n=== Total Salary Calculations ===\n");

        // Print total salary for entire company
        System.out.println("Total salary for " + company.getName() + ": $"
            + String.format("%.2f", company.getTotalSalary()));

        // Print total salary for specific departments
        System.out.println("Total salary for " + engineering.getName() + ": $"
            + String.format("%.2f", engineering.getTotalSalary()));

        System.out.println("Total salary for " + softwareDev.getName() + ": $"
            + String.format("%.2f", softwareDev.getTotalSalary()));

        System.out.println("Total salary for " + sales.getName() + ": $"
            + String.format("%.2f", sales.getTotalSalary()));

        System.out.println("Total salary for " + hr.getName() + ": $"
            + String.format("%.2f", hr.getTotalSalary()));

        // Demonstrate adding and removing components
        System.out.println("\n=== Dynamic Operations Demo ===\n");

        System.out.println("Adding a new employee to Sales department...");
        Employee newSalesRep = new Employee("Kate Martinez", 66000);
        sales.add(newSalesRep);
        System.out.println("New total salary for Sales: $"
            + String.format("%.2f", sales.getTotalSalary()));

        System.out.println("\nRemoving an employee from HR department...");
        hr.remove(hr2);
        System.out.println("New total salary for HR: $"
            + String.format("%.2f", hr.getTotalSalary()));

        System.out.println("\nAdding a new department to the company...");
        Department marketing = new Department("Marketing");
        Employee marketing1 = new Employee("Leo Garcia", 73000);
        Employee marketing2 = new Employee("Mia Rodriguez", 75000);
        marketing.add(marketing1);
        marketing.add(marketing2);
        company.add(marketing);

        System.out.println("Total salary for " + marketing.getName() + ": $"
            + String.format("%.2f", marketing.getTotalSalary()));

        System.out.println("\n=== Final Organization Total Salary ===\n");
        System.out.println("Total salary for " + company.getName() + ": $"
            + String.format("%.2f", company.getTotalSalary()));

        System.out.println("\n=== Final Organization Structure in XML ===\n");
        company.printXML(0);

        System.out.println("\n========================================");
        System.out.println("Demo completed!");
        System.out.println("========================================");
    }
}
