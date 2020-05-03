package task_3.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import task_3.bean.Employee;
import task_3.bean.Position;
import task_3.config.BeansConfig;
import task_3.service.EmployeeService;
import task_3.service.PositionService;
import task_3.service.SalaryService;
import task_3.utility.Months;

import java.util.Random;

public class Runner {

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.emulateLife();
    }

    private void emulateLife(){
        ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);

        EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
        PositionService positionService = context.getBean("positionService", PositionService.class);
        SalaryService salaryService = context.getBean("salaryService", SalaryService.class);

        Employee employee_1 = context.getBean("firstEmployee", Employee.class);
        Employee employee_2 = context.getBean("secondEmployee", Employee.class);
        Employee employee_3 = context.getBean("thirdEmployee", Employee.class);
        Employee employee_4 = context.getBean("fourthlyEmployee", Employee.class);
        Employee employee_5 = context.getBean("fifthEmployee", Employee.class);

        Position barista = context.getBean("barista", Position.class);
        positionService.create(barista);

        Position junior = context.getBean("junior", Position.class);
        positionService.create(junior);

        Position middle = context.getBean("middle", Position.class);
        positionService.create(middle);

        Position senior = context.getBean("senior", Position.class);
        positionService.create(senior);

        Position boss = context.getBean("boss", Position.class);
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

