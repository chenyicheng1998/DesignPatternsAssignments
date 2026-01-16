/**
 * Abstract base class for all organization components.
 * This is the Component in the Composite design pattern.
 * Allows uniform treatment of departments and employees.
 */
public abstract class OrganizationComponent {

    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Add a component to this organization component.
     * Only meaningful for composite objects (departments).
     */
    public abstract void add(OrganizationComponent component);

    /**
     * Remove a component from this organization component.
     * Only meaningful for composite objects (departments).
     */
    public abstract void remove(OrganizationComponent component);

    /**
     * Get the total salary of this component and all its children.
     */
    public abstract double getTotalSalary();

    /**
     * Print this component and its children in XML format.
     * @param indent indentation level for formatting
     */
    public abstract void printXML(int indent);

    /**
     * Helper method to generate indentation string.
     */
    protected String getIndent(int level) {
        return "  ".repeat(level);
    }
}
