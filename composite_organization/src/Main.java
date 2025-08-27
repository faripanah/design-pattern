//client:
public class Main {
    public static void main(String[] args) {
        // Create employees
        Employee e1 = new Employee("Alice", 50000);
        Employee e2 = new Employee("Bob", 60000);
        Employee e3 = new Employee("Charlie", 55000);
        Employee e4 = new Employee("Diana", 70000);

        // Create departments
        Department root = new Department("Headquarters");
        Department hr = new Department("HR");
        Department it = new Department("IT");

        // Build hierarchy
        root.add(hr);
        root.add(it);

        hr.add(e1);
        hr.add(e2);

        it.add(e3);
        it.add(e4);

        // Print total salary
        System.out.println("Total organization salary: " + root.getSalary());


    }
}