package task_2.service;

import org.springframework.stereotype.Component;
import task_2.bean.Salary;

import java.util.Random;

@Component
public class SalaryService {
    public void calculateSalary(Salary salary){
        Random random = new Random();
        if (salary == null) throw new NullPointerException();
        if (random.nextInt(2) == 0) {
            salary.setValueOfSalary(salary.getValueOfSalary() - random.nextInt((int) salary.getValueOfSalary()));
        }else {
            salary.setValueOfSalary(salary.getValueOfSalary() + random.nextInt((int)salary.getValueOfSalary()));
        }
    }
}
