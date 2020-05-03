package task_1.bean;

public class Employee {
    private String name;
    private Position position;
    private Salary salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Employee() {}

    public Employee(String name){
        this.name = name;
    }

    public Employee(String name, Position position, Salary salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (name == null || salary == null || position == null ||
                employee.getPosition() == null || employee.getSalary() == null || employee.getName() == null) {
            return false;
        }

        return getName().equals(employee.getName()) &&
                getPosition().equals(employee.getPosition()) &&
                getSalary().equals(employee.getSalary());
    }

    @Override
    public int hashCode() {
        return (name.hashCode() +
                (salary != null ? 57 * salary.hashCode() : 0) +
                (position != null ? 79 * salary.hashCode() : 0));
    }

    @Override
    public String toString() {
        return (name + " " + position + " " + salary);
    }
}
