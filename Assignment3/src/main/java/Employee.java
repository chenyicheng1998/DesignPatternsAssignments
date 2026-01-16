/**
 * Represents an employee in the organization.
 * This is a Leaf in the Composite design pattern.
 * Employees cannot contain other components.
 */
public class Employee extends OrganizationComponent {

    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot add components to an employee");
    }

    @Override
    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot remove components from an employee");
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public void printXML(int indent) {
        System.out.println(getIndent(indent) + "<Employee name=\"" + name + "\" salary=\"" + salary + "\" />");
    }
}
