package ir.imrasta.jpatest.validation.codeposti;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CodePostiValidator.class)
@Documented
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
public @interface CodePosti {
    String message() default "PostCode isnt valid!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    boolean containsDash() default false;
}
