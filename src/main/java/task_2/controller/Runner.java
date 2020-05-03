package task_2.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task_2.bean.Employee;
import task_2.bean.Position;
import task_2.bean.Salary;
import task_2.service.EmployeeService;
import task_2.service.PositionService;
import task_2.service.SalaryService;
import task_2.utility.Months;

import java.util.Random;

public class Runner {

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.emulateLife();
    }

    private void emulateLife() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_2.xml");

        EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
        PositionService positionService = context.getBean("positionService", PositionService.class);
        SalaryService salaryService = context.getBean("salaryService", SalaryService.class);

        Salary salary = context.getBean("salary", Salary.class);
        salary.setValueOfSalary(new Random().nextInt(1000));
        Salary baristaSalary = context.getBean("salary", Salary.class);
        baristaSalary.setValueOfSalary(new Random().nextInt(100));
        Salary lowSalary = context.getBean("salary", Salary.class);
        lowSalary.setValueOfSalary(100);
        Salary middleSalary = context.getBean("salary", Salary.class);
        middleSalary.setValueOfSalary(300);
        Salary bigSalary = context.getBean("salary", Salary.class);
        bigSalary.setValueOfSalary(500);

        Employee employee_1 = context.getBean("employee", Employee.class);
        employee_1.setName("Nik");
        Employee employee_2 = context.getBean("employee", Employee.class);
        employee_2.setName("Victoria");
        Employee employee_3 = context.getBean("employee", Employee.class);
        employee_3.setName("Geno");
        Employee employee_4 = context.getBean("employee", Employee.class);
        employee_4.setName("Margaret");
        Employee employee_5 = context.getBean("employee", Employee.class);
        employee_5.setName("Tim");

        Position barista = context.getBean("position", Position.class);
        barista.setName("Barista");
        barista.setSalary(baristaSalary);
        positionService.create(barista);

        Position junior = context.getBean("position", Position.class);
        junior.setName("Junior");
        junior.setSalary(lowSalary);
        positionService.create(junior);

        Position middle = context.getBean("position", Position.class);
        middle.setName("Middle");
        middle.setSalary(middleSalary);
        positionService.create(middle);

        Position senior = context.getBean("position", Position.class);
        senior.setName("Senior");
        senior.setSalary(bigSalary);
        positionService.create(senior);

        Position boss = context.getBean("position", Position.class);
        boss.setName("BOSS");
        boss.setSalary(salary);
        positionService.create(boss);

        employeeService.recruiting(employee_5, boss);
        employeeService.recruiting(employee_1, barista);
        employeeService.recruiting(employee_2, junior);
        employeeService.recruiting(employee_3, middle);
        employeeService.recruiting(employee_4, senior);

        System.out.println("The boss " + employee_5.getName() + " hired employees:");
        consoleOutputInformation(positionService);
        System.out.println("\n");

        for(Months month : Months.values()){
            System.out.println(month);
            if (month == Months.April){
                System.out.println("Delete " + employee_1.getPosition().getName() + " " + employee_1.getName());
                employeeService.dismissing(employee_1);
            }
            if (month == Months.December){
                System.out.println("Add " + employee_1.getName() + " on position " + junior.getName());
                employeeService.recruiting(employee_1, junior);
            }
            changeSalary(salaryService, positionService);
            consoleOutputInformation(positionService);
            System.out.println("\n");
        }
    }

    private void consoleOutputInformation(PositionService positionService){
        for (Position position : positionService.getPositions()){
            for (Employee employee : position.getEmployees()){
                System.out.println(employee.getName() + " - " + employee.getPosition().getName() + " - " +
                        Math.round(employee.getSalary().getValueOfSalary()) + "$");
            }
        }
    }

    private void changeSalary(SalaryService salaryService, PositionService positionService){
        Position position = positionService.getPositions().stream()
                .skip(new Random().nextInt(positionService.getPositions().size()))
                .findFirst()
                .get();
        if (position.getEmployees().size() > 0) {
            Employee employee = position.getEmployees().get(new Random().nextInt(position.getEmployees().size()));
            salaryService.calculateSalary(employee.getSalary());
        }
    }
}
