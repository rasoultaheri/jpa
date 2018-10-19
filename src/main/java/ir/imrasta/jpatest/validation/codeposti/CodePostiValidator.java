package ir.imrasta.jpatest.validation.codeposti;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CodePostiValidator implements ConstraintValidator<CodePosti, String> {

    boolean containsDash;

    public void initialize(CodePosti constraintAnnotation) {
        containsDash = constraintAnnotation.containsDash();
    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.length() == 0)
            return false;
        if (containsDash && s.length() != 11)
            return false;
        if (!containsDash && s.length() != 10)
            return false;
        return true;
    }
}
