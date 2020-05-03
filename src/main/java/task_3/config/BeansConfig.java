package task_3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import task_3.bean.Employee;
import task_3.bean.Position;
import task_3.bean.Salary;
import task_3.service.EmployeeService;
import task_3.service.PositionService;
import task_3.service.SalaryService;
import java.util.Random;

@Configuration
@ComponentScan("task_3")
public class BeansConfig {
    @Bean
    public EmployeeService employeeService(){
        return new EmployeeService();
    }

    @Bean
    public PositionService positionService(){
        return new PositionService();
    }

    @Bean
    public SalaryService salaryService(){
        return new SalaryService();
    }

    @Bean
    public Salary bigSalary(){
        return new Salary(500);
    }

     @Bean
    public Salary middleSalary(){
        return new Salary(300);
     }

    @Bean
    public Salary lowSalary(){
        return new Salary(100);
    }

    @Bean
    public Salary salary(){
        return new Salary(new Random().nextInt(1000));
    }

    @Bean
    public Salary baristaSalary(){
        return new Salary(new Random().nextInt(100));
    }

    @Bean
    public Position barista(){
        return new Position("Barista", baristaSalary());
    }

    @Bean
    public Position junior(){
        return new Position("Junior", lowSalary());
    }

    @Bean
    public Position middle(){
        return new Position("Middle", middleSalary());
    }

    @Bean
    public Position senior(){
        return new Position("Senior", bigSalary());
    }

    @Bean
    public Position boss(){
        return new Position("BOSS", salary());
    }

    @Bean
    public Employee firstEmployee(){
       return new Employee("Nik");
    }

    @Bean
    public Employee secondEmployee(){
        return new Employee("Victoria");
    }

    @Bean
    public Employee thirdEmployee(){
        return new Employee("Geno");
    }

    @Bean
    public Employee fourthlyEmployee(){
        return new Employee("Margaret");
    }

    @Bean
    public Employee fifthEmployee(){
        return new Employee("Tim");
    }
}
