import java.util.*;
//composite
public class Department implements Organization {
    private String name;
    private List<Organization> children = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void add(Organization unit) {
        children.add(unit);
    }

    public void remove(Organization unit) {
        children.remove(unit);
    }

    public Organization getChild(int i) {
        return children.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    // total salary of this department (employees + subdepartments)
    @Override
    public double getSalary() {
        double total = 0;
        for (Organization unit : children) {
            total += unit.getSalary();
        }
        return total;
    }


}
