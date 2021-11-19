package validTest.myvalid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @date 2021/11/19
 */
public class MyValidator implements ConstraintValidator<EqualsZhao, String> {

    private String val;

    @Override
    public void initialize(EqualsZhao constraintAnnotation) {
        this.val = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (val == null) {
            return false;
        }

        return value.equals(val);

        //return false;
    }

}
