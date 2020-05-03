package task_1.service;

import task_1.bean.Employee;
import task_1.bean.Position;

public class EmployeeService {

    public void recruiting(Employee employee, Position position) {
        if (employee == null || position == null) throw new NullPointerException();
        employee.setPosition(position);
        employee.setSalary(position.getSalary());
        position.getEmployees().add(employee);
    }

    public void dismissing(Employee employee){
        if (employee == null) throw new NullPointerException();
        employee.getPosition().getEmployees().remove(employee);
        employee.setPosition(null);
    }
}