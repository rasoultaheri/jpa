package ir.imrasta.jpatest.validation.employee;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = EmployeeValidator.class)
@Documented
@Target({ METHOD, FIELD, TYPE})
@Retention(RUNTIME)
public @interface EmployeeEntity {
    String message() default "Employee isnt valid!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
