import java.util.ArrayList;
import java.util.List;

/**
 * Represents a department in the organization.
 * This is a Composite in the Composite design pattern.
 * Departments can contain other departments and employees.
 */
public class Department extends OrganizationComponent {

    private List<OrganizationComponent> components;

    public Department(String name) {
        super(name);
        this.components = new ArrayList<>();
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }

    /**
     * Get a component by index.
     */
    public OrganizationComponent getComponent(int index) {
        return components.get(index);
    }

    /**
     * Get all components in this department.
     */
    public List<OrganizationComponent> getComponents() {
        return new ArrayList<>(components);
    }

    @Override
    public double getTotalSalary() {
        double total = 0;
        for (OrganizationComponent component : components) {
            total += component.getTotalSalary();
        }
        return total;
    }

    @Override
    public void printXML(int indent) {
        System.out.println(getIndent(indent) + "<Department name=\"" + name + "\">");
        for (OrganizationComponent component : components) {
            component.printXML(indent + 1);
        }
        System.out.println(getIndent(indent) + "</Department>");
    }
}
