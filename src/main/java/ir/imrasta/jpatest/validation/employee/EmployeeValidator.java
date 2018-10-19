package ir.imrasta.jpatest.validation.employee;

import ir.imrasta.jpatest.domain.Employee;
import ir.imrasta.jpatest.domain.Keshvar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployeeValidator implements ConstraintValidator<EmployeeEntity, Employee> {
    public void initialize(EmployeeEntity constraintAnnotation) {

    }

    public boolean isValid(Employee employee, ConstraintValidatorContext constraintValidatorContext) {
        if (!Keshvar.IRAN.equals(employee.getMelliat()))
            return true;

        if (employee.getCodeMelli() == null || employee.getCodeMelli().length() != 10)
            return false;

        return true;
    }
}
