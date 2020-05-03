package task_2.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Scope("prototype")
public class Salary {
    private double valueOfSalary;

    public double getValueOfSalary() {
        return valueOfSalary;
    }

    public void setValueOfSalary(double valueOfSalary) {
        this.valueOfSalary = valueOfSalary;
    }

    public Salary() {
    }

    public Salary(double valueOfSalary) {
        this.valueOfSalary = valueOfSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return salary.valueOfSalary == this.valueOfSalary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValueOfSalary());
    }

    @Override
    public String toString() {
        return "Salary " + valueOfSalary;
    }
}
