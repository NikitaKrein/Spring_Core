package task_1.service;

import task_1.bean.Salary;
import java.util.Random;

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